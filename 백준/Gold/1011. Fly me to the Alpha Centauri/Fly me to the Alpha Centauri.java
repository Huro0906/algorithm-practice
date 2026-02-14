
import java.io.*;
import java.util.*;

public class Main {
    public static Stack<Integer> s = new Stack<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(b-a);
            int k = (int)d;
            int powK = (int)Math.pow(k,2);

            if(powK == b-a){
                sb.append(2*k-1).append("\n");
            }
            else if(b-a>powK && b-a <= powK+k){
                sb.append(2*k).append("\n");
            }else{
                sb.append(2*k+1).append("\n");
            }

        }

        System.out.println(sb);
    }
}