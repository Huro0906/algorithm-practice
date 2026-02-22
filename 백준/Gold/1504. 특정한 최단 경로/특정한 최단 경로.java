import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<ArrayList<int[]>>vList;
    static int n,e;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        vList = new ArrayList<>();
        for (int i = 0; i <= n; i++) vList.add(new ArrayList<>());

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            vList.get(start).add(new int[]{end,d});
            vList.get(end).add(new int[]{start,d});
        }

        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        long res1 = (long)dijk(1, mid1) + dijk(mid1, mid2) + dijk(mid2, n);

        long res2 = (long)dijk(1, mid2) + dijk(mid2, mid1) + dijk(mid1, n);

        long ans = Math.min(res1, res2);

        if (ans >= 200000000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    public static int dijk(int start, int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {return a[1]-b[1];});
        pq.add(new int[]{start,0});

        int[] dist = new int[n+1];
        Arrays.fill(dist,200000000);
        dist[start]=0;
        boolean[] visited = new boolean[n+1];


        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curV = cur[0];

            if(visited[curV])continue;
            visited[curV] = true;

            int cost = cur[1];
            ArrayList<int[]> vs = vList.get(curV);

            for(int[] v : vs){
                if(dist[v[0]] > cost+v[1]){
                    dist[v[0]]=cost+v[1];
                    pq.add(new int[]{v[0],cost+v[1]});
                }
            }
        }
        return dist[end];
    }






}