
import java.io.*;
import java.util.*;

public class Main {
    static int[] wine;
    static int[] dp;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        dp = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0]=0;
        dp[1] = wine[1];
        if(n>1)dp[2] = wine[2]+wine[1];

        for(int i=2; i<=n; i++){
            int a =( i>2 ? dp[i-3] : 0 ) + wine[i]+ wine[i-1];
            int b = dp[i-2]+wine[i];
            int c = dp[i-1];
            dp[i] = Math.max(Math.max(a,b),c);
        }

        System.out.println(dp[n]);


    }
}