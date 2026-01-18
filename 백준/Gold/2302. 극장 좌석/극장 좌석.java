
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isFixed = new boolean[n+1];
        int[] dp = new int[n+1];
        for(int i=0; i<m; i++){
            isFixed[Integer.parseInt(br.readLine())]=true;
        }
        dp[0]=1;
        dp[1]=1;
        // n번째까지의 경우의 수 = (n-1)이 고정석이 아니라면 n-1 번째가 안바꿨을때 * 2 + n-2의 2배 (이게 n-1이 바꿨을때 경우의 수)
        for(int i=2; i<=n; i++){
            if(isFixed[i-1] || isFixed[i]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];

        }
        System.out.println(dp[n]);

    }
}