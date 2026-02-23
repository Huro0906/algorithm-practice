import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<int[]>> eList = new ArrayList<>();
    static int v,e;
    static int start;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=0; i<=v; i++){
            eList.add(new ArrayList<>());
        }

        start = Integer.parseInt(br.readLine());
        
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eList.get(startV).add(new int[]{endV,w});
        }

        dijk(start);
        
        
    }

    public static void dijk(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        int[] costs = new int[v+1];

        pq.add(new int[]{start, 0});
        Arrays.fill(costs,Integer.MAX_VALUE);
        boolean[] visited = new boolean[v+1];
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curV = cur[0];
            int cost = cur[1];

            if(visited[curV]){
                continue;
            }

            costs[curV] = cost;            
            visited[curV]=true;
            ArrayList<int[]> edges = eList.get(curV);

            for(int[] edge : edges){
                int nv = edge[0];
                int ncost = edge[1];

                if(!visited[nv]){
                    pq.add(new int[]{nv,ncost+cost});
                }
            }
        }

        for(int i=1; i<=v; i++){
            if(costs[i]==Integer.MAX_VALUE){
                answer.append("INF\n");
            }
            else
                answer.append(costs[i]).append("\n");
        }

        System.out.println(answer);
    }

}
