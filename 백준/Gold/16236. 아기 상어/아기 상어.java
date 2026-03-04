import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dr = new int[]{-1,0,0,1};
    static int[] dc = new int[]{0,-1,1,0};
    static int turn=0;
    static int[] start;
    static int size=2;
    static int stack=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9)start = new int[]{i,j};
            }
        }

        bfs();
        
        System.out.println(turn);
        
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(start);
        visited[start[0]][start[1]]=true;
        int time=0;
        while(!q.isEmpty()){
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                if(a[0]==b[0])return a[1]-b[1]; 
                return a[0]-b[0];});
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int[] cur= q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int j=0; j<4; j++){
                    int nr = curR+dr[j];
                    int nc = curC+dc[j];

                    if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                        if(map[nr][nc]==0 || map[nr][nc]==9 || map[nr][nc]==size){
                            q.add(new int[]{nr,nc});
                            visited[nr][nc]=true;
                        }

                        else if(size>map[nr][nc]){
                            pq.add(new int[]{nr,nc});
                            visited[nr][nc]=true;
                        }
                    }
                }
            }
            time++;
            if(!pq.isEmpty()){
                stack++;
                if(stack==size){
                    size++;
                    stack=0;
                }
                turn+=time;
                time=0;
                int[] next = pq.poll();
                q.clear();
                pq.clear();
                q.add(next);
                map[next[0]][next[1]]=9;
                visited = new boolean[n][n];
                visited[next[0]][next[1]]=true;
            }
        }
    }
}
