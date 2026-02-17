import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        int[][]time;
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        time = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i][0]=start;
            time[i][1]=end;
        }

        Arrays.sort(time,(a,b)->{
            if(a[1]==b[1])return a[0]-b[0];
            return a[1]-b[1];
        });

        int used = 0;
        int cnt=0;
        for(int[] cur : time){
            int start = cur[0];
            int end = cur[1];

            if(used<=start){
                used = end;
                cnt++;
            }
        }

        System.out.println(cnt);

    }


}