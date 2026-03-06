import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n,m,t;
    static int[] dr = new int[]{1,0,0,-1};
    static int[] dc = new int[]{0,1,-1,0};
    static ArrayList<int[]> cleaner = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());     
                if(map[i][j]==-1)cleaner.add(new int[]{i,j});
            }
        }

        for(int i=0; i<t; i++){
            int[][] dif = new int[n][m];
            
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    int sum =0;
                    for(int d=0; d<4; d++){
                        int nr = j+dr[d];
                        int nc = k+dc[d];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]!=-1){
                            dif[nr][nc] += map[j][k]/5;
                            sum+=map[j][k]/5;
                        }
                    }
                    dif[j][k] -=sum;
                }
            }

            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    map[j][k]+= dif[j][k];
                }
            }
            clean();
        }
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]>0)answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void clean(){
        Queue<int[]> q = new LinkedList<>();
        int cleaner1R = cleaner.get(0)[0];
        int cleaner2R = cleaner.get(1)[0];

        for(int i=cleaner1R-1; i>0; i--)map[i][0] = map[i-1][0];
        for(int i=0; i<m-1; i++)map[0][i] = map[0][i+1];
        for(int i=0; i<cleaner1R; i++)map[i][m-1] = map[i+1][m-1];
        for(int i=m-1; i>1; i--)map[cleaner1R][i] = map[cleaner1R][i-1];
        map[cleaner1R][1] = 0;

        for(int i=cleaner2R+1; i<n-1; i++)map[i][0] = map[i+1][0];
        for(int i=0; i<m-1; i++)map[n-1][i] = map[n-1][i+1];
        for(int i=n-1; i>cleaner2R; i--)map[i][m-1] = map[i-1][m-1];
        for(int i=m-1; i>1; i--)map[cleaner2R][i] = map[cleaner2R][i-1];
        map[cleaner2R][1]=0;
        
    }
}
