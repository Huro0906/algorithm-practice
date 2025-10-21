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

    public static int bfs(byte[][] arr, int n, int m ,int k){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][k+1];

        int turn =1;
        q.add(new int[]{0,0,0});
        
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                int[] cur = q.poll();

                if(cur[0]==n-1 && cur[1]== m-1)return turn;

                for(int j=0; j<4; j++){
                    int nr = cur[0]+dr[j];
                    int nc = cur[1]+dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m){
                        int nk = cur[2]+arr[nr][nc];
                        if(nk<=k && !visited[nr][nc][nk]){
                            q.add(new int[]{nr,nc,nk});
                            visited[nr][nc][nk] = true;
                        }
                    }
                }
            }
            turn++;
        }
        return -1;
    }
}