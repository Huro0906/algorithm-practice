import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long b;
    static int[][] arr;
    static int[][] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        
        arr = new int[n][n];
        long cur=1;
        answer = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i==j)answer[i][j]=1;
            }
        }

        while(cur<=b){
            if((cur & b) >0){
                answer = multiple(answer,arr);
            }
            cur*=2;

            arr = multiple(arr,arr);
        }
    
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] multiple(int[][] a, int[][]b){
        int[][] res = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int cur=0;
                for(int k=0; k<n; k++){
                    cur = (cur+a[i][k]*b[k][j])%1000;
                }
                res[i][j]=cur;
            }
        }

        return res;
    }
    
}
