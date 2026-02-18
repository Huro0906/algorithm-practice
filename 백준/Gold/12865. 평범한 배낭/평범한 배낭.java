import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        int max=0;

        int[][] arr = new int[n][2];
        
    
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            arr[i][0] = w;
            arr[i][1] = v;
        }
        
        for(int[] item : arr){
            int w = item[0];
            int v = item[1];
            for(int i=k; i>=w; i--){
                dp[i] = Math.max(dp[i],dp[i-w]+v);
                if(dp[i]>max)max=dp[i];
            }
        }

        System.out.println(max);
    }
}
