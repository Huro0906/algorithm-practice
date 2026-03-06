import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n,m,w;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            int[][] dist = new int[n+1][n+1];
            ArrayList<int[]> edges = new ArrayList<>();

            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                edges.add(new int[]{s,e,c});
                edges.add(new int[]{e,s,c});
            }
            for(int j=0; j<w; j++){
                st = new StringTokenizer(br.readLine());
                
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges.add(new int[]{s,e,-c});
            }

            int[] dists = new int[n+1];
            dists[1]=0;
            boolean isPossible = false;
            for(int j=1; j<=n; j++){
                for(int[] edge : edges){
                    int s = edge[0];
                    int e = edge[1];
                    int c = edge[2];

                    if( dists[s]+c < dists[e]){
                        if(j==n){
                            isPossible=true;
                            break;
                        }
                        dists[e] = dists[s]+c;
                    }
                }
            }

            if(isPossible){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
