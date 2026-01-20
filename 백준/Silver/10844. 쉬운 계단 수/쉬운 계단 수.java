
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[]dp = new int[10];
        Arrays.fill(dp,1);
        dp[0]=0;
        int sum=0;
        if(n==1) {
            System.out.println(9);
            return;
        }
        for(int i=2; i<=n; i++){
            int[]nDp = new int[10];
            sum=0;
            for(int j=0; j<=9; j++){
                int a = j+1 > 9 ? 0 : dp[j+1];
                int b = j-1 < 0 ? 0 : dp[j-1];
                nDp[j] = (int)(((long)a+(long)b)%(long)1000000000);
                sum=(int)(((long)sum+(long)nDp[j])%(long)1000000000);
            }
            dp =nDp;
        }

        System.out.println(sum);
    }
}