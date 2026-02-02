
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{

        int[][] cost;
        int[][] dp;
        int t = 1;
        StringBuilder sb = new StringBuilder();
         while(true){
             int n = Integer.parseInt(br.readLine());
             if(n==0)break;
             cost = new int[n][3];
             dp = new int[n][3];

             for(int i=0; i<n; i++){
                 StringTokenizer st = new StringTokenizer(br.readLine());
                 for(int j=0; j<3; j++){
                     cost[i][j] = Integer.parseInt(st.nextToken());
                 }
             }
             dp[0][0] = 1000000000;
             dp[0][1] = cost[0][1];
             dp[0][2] = dp[0][1]+cost[0][2];

             for(int i=1; i<n; i++){
                 dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][0];
                 dp[i][1] = Math.min(Math.min(dp[i-1][0],dp[i-1][1]),dp[i-1][2])+cost[i][1];
                 dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2])+cost[i][2];

                 dp[i][1] = Math.min(dp[i][0]+cost[i][1],dp[i][1]);
                 dp[i][2] = Math.min(dp[i][1]+cost[i][2], dp[i][2]);
             }
             sb.append(t).append(". ").append(dp[n-1][1]).append("\n");
             t++;
         }
         System.out.println(sb.toString());
    }
}