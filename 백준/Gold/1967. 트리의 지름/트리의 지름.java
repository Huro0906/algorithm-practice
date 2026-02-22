import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static int maxLen =0;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<int []> eList = list.get(p);
            eList.add(new int[]{c,b});
        }

        dfs(1,0);
        System.out.println(maxLen);
    }

    public static int dfs(int s, int b){
        int first=0;
        int second=0;
        if(list.get(s).isEmpty()){
            return b;
        }
        for(int[] vertex : list.get(s)){
            int m = dfs(vertex[0],vertex[1]);
            if(m > first){
                second = first;
                first = m;
            }
            else if(m > second){
                second = m;
            }
        }
        if(first+second>maxLen){
            maxLen = first+second;
        }

        return first+b;
    }
}