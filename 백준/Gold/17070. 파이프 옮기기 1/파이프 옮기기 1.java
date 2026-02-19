import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int in = Integer.parseInt(st.nextToken());
                
                map[i][j] = in;
            }
        }

        int[][][] dp = new int[n+1][n+1][3];
        dp[1][2][0]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j]==1)continue;
                //가로
                dp[i][j][0] += dp[i][j-1][0]+dp[i][j-1][1];

                //세로
                dp[i][j][2] += dp[i-1][j][1]+dp[i-1][j][2];

                //대각선
                if(map[i][j-1]!=1 && map[i-1][j]!=1 )
                    dp[i][j][1] = dp[i-1][j-1][1]+dp[i-1][j-1][0]+dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
    }
}
