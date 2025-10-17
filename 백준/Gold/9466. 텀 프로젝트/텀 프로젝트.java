import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] results = new String[t];

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr= new int[n+1];
            Integer total = 0;
            boolean[] visited = new boolean[n+1];
            Deque<Integer> dq = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=1; j<=n; j++){
                if(!visited[j]){
                    dq.clear();
                    total+=dfs(arr,visited,j,dq);

                }
            }
            results[i] = String.valueOf(n-total);
        }
        System.out.println(String.join("\n", results));
    }

    public static int dfs(int[] arr,boolean[] visited ,int start, Deque<Integer> dq){
        visited[start] = true;
        dq.add(start);
        if(!visited[arr[start]]){
            return dfs(arr,visited, arr[start],dq);
        }
        else{
            while(!dq.isEmpty() && dq.getFirst() != arr[start]){
                dq.pollFirst();
            }
            return dq.size();
        }
    }
}