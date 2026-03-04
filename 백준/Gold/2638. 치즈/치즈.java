import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int cheese=0;
    static int turn=0;
    static int[] dr = new int[]{1,0,0,-1};
    static int[] dc = new int[]{0,1,-1,0};
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
                if(map[i][j]==1)cheese++;
            }
        }
        while(cheese!=0){
            bfs();
            turn++;
        }
        System.out.println(turn);

    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][]visited = new boolean[n][m];
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for(int i=0; i<4; i++){
                int nr = curR+dr[i];
                int nc = curC+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc]==0){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    int cnt=0;
                    for(int k=0; k<4; k++){
                        int nr= i+dr[k];
                        int nc = j+dc[k];

                        if(visited[nr][nc]){
                            cnt++;
                        }
                    }
                    if(cnt>=2){
                        map[i][j]=0;
                        cheese--;
                    }
                }
            }
        }
    }
}
