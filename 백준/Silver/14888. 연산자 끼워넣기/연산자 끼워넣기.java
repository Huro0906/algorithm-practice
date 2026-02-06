
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int n;
    static int[] oper = new int[4];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        bf(1,oper[0],oper[1],oper[3],oper[2],arr[0]);

        System.out.println(max+"\n"+min);
    }

    public static void bf(int pt, int plus, int minus, int divide, int multiple, int cur){
        if(plus<0 || minus<0 || divide<0||multiple<0)return;
        if(pt==n) {
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            return;
        }


        bf(pt+1, plus-1,minus,divide,multiple,cur+arr[pt]);
        bf(pt+1, plus,minus-1,divide,multiple,cur-arr[pt]);
        bf(pt+1, plus,minus,divide-1,multiple,cur/arr[pt]);
        bf(pt+1, plus,minus,divide,multiple-1,cur*arr[pt]);

    }


}