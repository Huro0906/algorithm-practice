import java.io.*;
import java.util.*;

public class Main {
    public static int cnt=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, r, c;
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z(n,r,c);
        System.out.println(cnt);

    }

    public static void z(int n, int r, int c) {
        if(n==0)return;

        int half = 1<<(n-1);

        if(r<half && c<half){
            z(n-1,r,c);
        }
        else if(c>=half && r<half){
            cnt+=half*half;
            z(n-1,r,c-half);
        }
        else if(r>=half && c<half){
            cnt+=2*half*half;
            z(n-1,r-half,c);
        }
        else if(r>=half && c>=half){
            cnt+=3*half*half;
            z(n-1,r-half,c-half);
        }
    }
}