import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer= 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long b = reverse(Long.parseLong(st.nextToken()));
            long a = Long.parseLong(st.nextToken());
            answer = (answer+a*b%MOD)%MOD;
        }

        System.out.println(answer);
    }

    public static long reverse(long a){
        long cur = 1;
        long result=1;

        while(cur<=(MOD-2)){
            if((cur & (MOD-2)) > 0){
                result = (result%MOD*a%MOD)%MOD;
            }    
            
            a = (a*a)%MOD;
            cur = cur<<1;
        }
        return result;
    }
}
