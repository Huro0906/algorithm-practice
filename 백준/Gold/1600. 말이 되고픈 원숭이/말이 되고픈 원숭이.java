import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        byte[][] arr = new byte[h][w];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                arr[i][j] = (byte)Integer.parseInt(st.nextToken());
            }   
        }

        System.out.println(bfs(arr,h,w,k));

    }

    public static int bfs(byte[][] arr, int r, int c, int k){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][]visited = new boolean[r][c][k+1];

        q.add(new int[]{0,0,0});
        int[] dr = {-2,-1,1,2,2,1,-1,-2,1,0,-1,0};
        int[] dc = {-1,-2,-2,-1,1,2,2,1,0,1,0,-1};
        int[] dk = {1,1,1,1,1,1,1,1,0,0,0,0};
        
        int turn = 0;

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                int[]cur = q.poll();
                
                if(cur[0] == r-1 && cur[1] == c-1){
                    return turn;
                }

                for(int j=0; j<12; j++){
                    int nr = cur[0]+dr[j];
                    int nc = cur[1]+dc[j];
                    int nk = cur[2]+dk[j];

                    if(nr>=0 && nr<r && nc>=0 && nc<c && nk<=k && !visited[nr][nc][nk] && arr[nr][nc]!=1){
                        q.add(new int[]{nr,nc,nk});
                        visited[nr][nc][nk]= true;
                    }
                }

            }
            turn++;
        }
        return -1;
    }
}