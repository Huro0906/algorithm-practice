
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        // 0 : 상담 기간, 1: 돈
        int[][] counsel = new int[n+1][2];
        int[] dp = new int[n+2];
        int max=0;
        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            int duration = counsel[i][0];
            int money = counsel[i][1];
            if(i+duration-1 <=n){
                dp[i+duration] = Math.max(dp[i+duration],dp[i]+money);
                max = Math.max(max,dp[i+duration]);
            }
        }
        System.out.println(Math.max(dp[n+1],dp[n]));
    }
}