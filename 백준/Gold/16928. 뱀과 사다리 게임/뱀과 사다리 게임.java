import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Map<Integer, Integer>ladder = new HashMap<>();
        Map<Integer, Integer>snake = new HashMap<>();

        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladder.put(start,end);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snake.put(start,end);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(1);
        visited[1]=true;
        int t=0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            t++;
            for(int i=0; i<qSize; i++){
                int cur = q.poll();
                if(cur==100){
                    System.out.println(t-1);
                    return;
                }

                for(int j=1; j<=6; j++){
                    int next = cur+j;

                    if(ladder.containsKey(next)){
                        next = ladder.get(next);
                    }
                    if(snake.containsKey(next)){
                        next = snake.get(next);
                    }

                    if(next<=100 && !visited[next]){
                        q.add(next);
                        visited[next]=true;
                    }
                }
            }

        }




    }


}