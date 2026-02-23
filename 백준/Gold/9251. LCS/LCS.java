import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cArr1,cArr2;
        cArr1 = br.readLine().toCharArray();
        cArr2 = br.readLine().toCharArray();

        int[][] dp = new int[cArr1.length+1][cArr2.length+1];
        
        for(int i=1; i<=cArr1.length; i++){
            for(int j=1; j<=cArr2.length; j++){
                
                if(cArr1[i-1] == cArr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[cArr1.length][cArr2.length]);
    }
}
