import java.io.*;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];

        //RGB
        int[][] dp = new int[n][3];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dp
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min((cost[i][0]+dp[i-1][1]),(cost[i][0]+dp[i-1][2]));
            dp[i][1] = Math.min((cost[i][1]+dp[i-1][0]),(cost[i][1]+dp[i-1][2]));
            dp[i][2] = Math.min((cost[i][2]+dp[i-1][0]),(cost[i][2]+dp[i-1][1]));
        }
        int min = Math.min(dp[n-1][0],dp[n-1][1]);
        min = Math.min(min,dp[n-1][2]);
        System.out.println(min);


    }
}