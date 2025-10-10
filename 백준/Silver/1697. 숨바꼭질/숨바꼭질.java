import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int loc = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(bfs(loc,target));
    }

    public static int bfs(int loc, int target){
        int sec = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(loc);
        boolean[] visited = new boolean[100001];

        while(!q.isEmpty()){    
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                visited[cur] = true;
                if(cur == target)return sec;
                if(cur+1<=100000&&!visited[cur+1]){
                    q.add(cur+1);
                }
                if(cur-1>=0 &&cur-1<=100000 && !visited[cur-1]){
                    q.add(cur-1);
                }
                if(cur*2<=100000 && !visited[cur*2]){
                    q.add(cur*2);
                }
            }
            sec++;
        }
        return -1;
    }
}