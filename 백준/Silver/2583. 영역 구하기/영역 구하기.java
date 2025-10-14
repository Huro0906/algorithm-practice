import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        int n,m,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[m][n];
        ArrayList<Integer> w = new ArrayList<>();

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int sr,sc,er,ec;
            sc = Integer.parseInt(st.nextToken());
            sr = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());
            er = Integer.parseInt(st.nextToken());
            
            for(int j=sr; j<er; j++){
                for(int z=sc; z<ec; z++){
                    visited[j][z] = true;
                }
            }
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    cnt++;
                    w.add(bfs(visited,new int[]{i,j},n,m));
                }
            }
        }
        w.sort(Comparator.naturalOrder());
        sb.append(cnt).append("\n");
        w.stream()
        .forEach((i)->{
            sb.append(i).append(" ");
        });

        System.out.println(sb.toString());
    }

    public static int bfs(boolean[][] visited, int[] roc,int n, int m){
        int size =1;
        Queue<int[]>q = new ArrayDeque<>();
        int[] dr ={1,0,-1,0};
        int[] dc = {0,1,0,-1};
        q.add(roc);
        visited[roc[0]][roc[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nr,nc;
                nr = cur[0]+dr[i];
                nc = cur[1]+dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                    size++;
                }
            }

        }

        return size;
    }
}