
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int [n+1];
        int[] path = new int[n+1];

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            path[i] = i-1;
            if(i%3==0 && dp[i/3]+1<dp[i]){
                dp[i] = dp[i/3]+1;
                path[i] = i/3;
            }
            if(i%2==0 && dp[i/2]+1<dp[i]){
                dp[i] = dp[i/2]+1;
                path[i] = i/2;
            }


        }
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        int idx = n;
        sb.append(idx).append(" ");
        while(idx!=1){
            idx=path[idx];
            cnt++;
            sb.append(idx).append(" ");
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}