
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max =1;
        //한번씩 탐색
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());

            for(int j=0; j<i; j++){
                if(seq[j]<seq[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max)max=dp[i];
                }

            }
        }
        System.out.println(max);

    }

}