import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n,k;
    static BufferedReader br;
    static int[][] visited;
    static Queue<Integer> q;
    static int time =0;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        visited = new int[500001][2];
        for(int i=0; i<=500000; i++){
            Arrays.fill(visited[i],-1);
        }
        int time=0;

        if(n==k){
            System.out.println("0");
            return;
        }
        else{
            visited[n][0]=0;
            q.add(n);
            bfs();
            time=1;
            while(k<=500000){
                k+=time;
                if(k>500000)break;
                if(visited[k][time%2]!= -1 && visited[k][time%2] <= time){
                    System.out.println(time);
                    return;
                }
                time ++;
            }
            System.out.println(-1);
        }
    }

    public static void bfs(){
        int[] dr = new int[]{-1,1,2};
        time = 1;
        while(!q.isEmpty()){    
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int cur = q.poll();
                for(int j=0; j<3; j++){
                    int nr = (j==2) ? cur * dr[j] : cur+dr[j];
                    if(nr>=0 && nr<=500000 && visited[nr][time%2]==-1){
                        q.add(nr);
                        visited[nr][time%2]=time;
                    }
                }
            }
            time++;
        }
    }
}