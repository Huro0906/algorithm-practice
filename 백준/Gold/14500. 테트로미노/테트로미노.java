
import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[]dr = new int[]{1,0,-1,0};
    public static int[]dc = new int[]{0,1,0,-1};
    public static int max=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfs(1, map[i][j],i,j);
                a(i,j);
            }
        }
        System.out.println(max);
    }
    public static void dfs(int depth, int cur, int r, int c){
        if(depth==4){
            if(cur>max)max=cur;
            visited[r][c]=false;
            return;
        }
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){
                visited[nr][nc]=true;
                dfs(depth+1, cur+map[nr][nc], nr, nc);
                visited[nr][nc]=false;
            }
        }
        visited[r][c] = false;
    }

    public static void a(int r,int c){
        int[] dd = new int[]{3,0,1};
        for(int i=0; i<4; i++){
            int sum = map[r][c];

            for(int j=0; j<3; j++){
                int nr = r+dr[(i+dd[j])%4];
                int nc = c+dc[(i+dd[j])%4];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    sum+=map[nr][nc];
                }
            }
            if(sum>max){
                max = sum;
            }
        }
    }
}