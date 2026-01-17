
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        //dp[n] = dp[n-1]+dp[n-2]
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}