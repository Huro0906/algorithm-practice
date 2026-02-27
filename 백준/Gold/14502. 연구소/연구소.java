import java.util.*;
import java.io.*;

public class Main {
    static int n,m,space;
    static int[][] map;
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1};
    static int max=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0)space++;
            }
        }
        combine(0,0);

        System.out.println(max);
    }

    public static void combine(int depth, int idx){
        if(depth==3){
            bfs();
            return;
        }
        for(int i=idx; i<n*m; i++){
            int r = i/m;
            int c = i%m;
            if(map[r][c]==0){
                map[r][c]=1;
                combine(depth+1, i);
                map[r][c]=0;
            }
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int cnt=0;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==2){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }

        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc]==0){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                    cnt++;
                }
            }
        }

        if(max<space-3-cnt){
            max = space-3-cnt;
        }
        
    }
}
