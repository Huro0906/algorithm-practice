import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n,k);
        
    }

    public static void bfs(int n, int k){
        int turn =0;
        Queue<Integer> q = new ArrayDeque<>();

        q.add(n);
        int[] parent = new int[100001];
        Arrays.fill(parent,-1);

        parent[n] = n;
        
        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                int cur = q.poll();
                
                if(cur == k){
                    StringBuilder sb = new StringBuilder();
                    sb.append(turn).append("\n");
                    Stack<Integer> record = new Stack<>();
                    
                    int tmp = k;
                    record.add(k);
                    while(tmp!=n){
                        tmp = parent[tmp];
                        record.add(tmp);
                    }
                    while(!record.isEmpty()){
                        sb.append(record.pop()).append(" ");
                    }

                    System.out.println(sb.toString());
                }
                
                int[] dr = new int[]{cur+1, cur-1, cur*2};

                for(int j=0; j<3; j++){
                    
                    if(dr[j]>=0 && dr[j]<=100000 && parent[dr[j]]==-1){
                        parent[dr[j]] = cur;
                        q.add(dr[j]);
                    }
                }
            }
            turn++;
        }
        
        
    }
}