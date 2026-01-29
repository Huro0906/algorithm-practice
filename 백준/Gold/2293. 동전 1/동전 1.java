import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        int answer=0;

        for(int i=1; i<=n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        dp[0]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(j-coins[i]>=0)
                    dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }


}