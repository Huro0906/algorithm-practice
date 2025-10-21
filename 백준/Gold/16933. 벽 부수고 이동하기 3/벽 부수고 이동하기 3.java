import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        byte[][] arr = new byte[n][m];
        for(int i=0; i<n; i++){
            char[]line = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                arr[i][j] = (byte)(line[j]-'0');
            }
        }

        System.out.println(bfs(arr,n,m,k));
        
    }

    public static int bfs(byte[][] arr, int n, int m, int k){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][k+1];
        // day 홀수 = 낮 
        int day = 1;
        q.add(new int[]{0,0,0});
        int[] dr = new int[]{0,1,0,-1,0};
        int[] dc = new int[]{1,0,-1,0,0};

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                int[] cur = q.poll();

                if(cur[0] == n-1 && cur[1] == m-1)return day;
                
                //낮은 가만히 있을 이유가 없음.
                //밤에 다음에 이동할려는 경로가 벽이면 X
                int jmax = (day%2==0) ? 5 : 4;
                for(int j=0; j<jmax; j++){
                    int nr = cur[0]+dr[j];
                    int nc = cur[1]+dc[j];
                    if(!(nr>=0 && nr<n && nc>=0 && nc<m))continue;

                    if(j==4){
                        q.add(cur);
                        continue;
                    }
                    int nk = j==4 ? cur[2] : cur[2]+ arr[nr][nc];
                    if(day%2==0 && arr[nr][nc]==1)continue;
                    else if(nk<=k && !visited[nr][nc][nk]){
                        q.add(new int[]{nr,nc,nk});
                        visited[nr][nc][nk]= true;
                    }
                    
                }
            }
            day++;
        }
        return -1;
    }
}