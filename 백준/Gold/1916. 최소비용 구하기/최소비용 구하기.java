
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static List<int[]>[] adjList;
    public static void main(String[] args)throws Exception{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adjList = new LinkedList[n+1];
        StringTokenizer st;
        for(int i=1; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }
        int[] d = new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());

            adjList[start].add(new int[]{end,cost});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        d[start]=0;
        boolean[] visited = new boolean[n+1];
        while(true){
            for(int[] adj : adjList[start]){
                int e = adj[0];
                int cost = adj[1];
                d[e] = Math.min(d[e],d[start]+cost);
            }
            visited[start]=true;

            int minC = Integer.MAX_VALUE;

            for(int i=0; i<d.length; i++){
                if(!visited[i] && d[i]<minC){
                    minC = d[i];
                    start=i;
                }
            }
            if(minC==Integer.MAX_VALUE)break;
        }
        System.out.println(d[end]);
    }

}