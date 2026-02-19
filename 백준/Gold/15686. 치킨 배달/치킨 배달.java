import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static boolean[] choosed;
    public static ArrayList<int[]> chicken = new ArrayList<>();
    public static int n;
    public static int m;
    public static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                int in = Integer.parseInt(st.nextToken());
                map[i][j] = in;
                if(in==2)chicken.add(new int[]{i,j});
            }

        }
        choosed = new boolean[chicken.size()];
        
        combine(0,0);

        System.out.println(min);
    }

    public static void combine(int depth, int idx){
        if(depth == m){
            bfs();
            return;
        }

        for(int i=idx; i<chicken.size(); i++){
            choosed[i] = true;
            combine(depth+1, i+1);
            choosed[i] = false;
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        int score=0;
        for(int i=0; i<chicken.size(); i++){
            
            if(choosed[i]){
                int[] c = chicken.get(i);

                q.add(c);
                visited[c[0]][c[1]]=true;
            }
        }

        int t=1;
        while(!q.isEmpty()){
            
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int j=0; j<4; j++){
                    int nr = curR+dr[j];
                    int nc = curC+dc[j];

                    if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        if(map[nr][nc]==1){
                            score+=t;
                        }
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            t++;
        }
        
        if(score<min)min = score;
        
    }

}
