import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        final int MAX_VALUE = 100000000;
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)continue;
                dp[i][j] = MAX_VALUE;
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            dp[start][end] = cost;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    dp[j][k] = Math.min(dp[j][i] + dp[i][k],dp[j][k]);
                }
            }
        }

        int max=0;

        for(int i=1; i<=n; i++){
            if(dp[i][X] + dp[X][i]>max){
                max = dp[i][X] + dp[X][i];
            }    
        }

        System.out.println(max);
        
    }
}
