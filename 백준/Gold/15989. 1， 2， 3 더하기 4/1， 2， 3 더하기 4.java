
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];

        dp[0]=1;

        for(int i=1; i<=10000; i++){
            dp[i] =1;
        }
        for(int i=2; i<=10000; i++){
            dp[i] +=dp[i-2];
        }
        for(int i=3; i<=10000; i++){
            dp[i]+=dp[i-3];
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.print(sb);
    }
}