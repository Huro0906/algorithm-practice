import java.util.*;
import java.io.*;

public class Main {
    public final static int MAX = 100000000;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        int[][] dist = new int[v+1][v+1];
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i==j)continue;
                dist[i][j]=MAX;
            }
        }

        for(int i=0; i<e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            dist[startV][endV] = Math.min(dist[startV][endV], cost);
        }
        
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                for(int k=1; k<=v; k++){
                    dist[j][k] = Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(dist[i][j]==MAX){
                    sb.append(0).append(" ");
                }
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
