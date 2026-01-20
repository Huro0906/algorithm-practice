
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int t;
        int w;

        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int max=0;
        int[][] dp = new int[t+1][w+1];
        for(int i=1; i<=t; i++){
            int jadoo = Integer.parseInt(br.readLine());
            for(int j=0; j<=w && j<=i; j++){
                if(j-1<0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
                if((j%2==0 && jadoo==1) || (j%2==1 &&jadoo==2)) {
                    dp[i][j]++;
                    if(max<dp[i][j])max = dp[i][j];
                }
            }
        }

        System.out.println(max);
    }
}