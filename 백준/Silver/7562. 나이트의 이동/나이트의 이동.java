import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<c; i++){
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] roc = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());

            int[] target = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            sb.append(bfs(size,roc,target)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int bfs (int size, int[] roc, int[] target){

        int[] dr ={-1,-2,-2,-1,1,2,2,1};
        int[] dc ={-2,-1,1,2,2,1,-1,-2};
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[size][size];

        visited[roc[0]][roc[1]]=true;
        q.add(roc);
        int turn =0;

        while(!q.isEmpty()){
            int m = q.size();

            for(int i=0; i<m; i++){
                int[] cur = q.poll();
                if(target[0] == cur[0] && target[1] == cur[1])return turn;

                for(int j=0; j<8; j++){
                    int nr = cur[0]+dr[j];
                    int nc = cur[1]+dc[j];

                    if(nr>=0 && nr<size && nc>=0 && nc<size && !visited[nr][nc]){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true; 
                    }
                }
            }
            turn++;
        }

        return -1;
    }
}