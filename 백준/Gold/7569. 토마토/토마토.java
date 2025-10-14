import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m,h;
        int zeroCount=0;
        Queue<int[]> q = new ArrayDeque<>();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        int[][][] arr = new int[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k=0; k<m; k++){
                    int cur = Integer.parseInt(st.nextToken());
                    if(cur==0)zeroCount++;
                    else if(cur==1)q.add(new int[]{i,j,k});
                    arr[i][j][k] = cur;
                }
            }
        }

        System.out.println(bfs(arr,q,n,m,h,zeroCount));

    }

    public static int bfs(int[][][] arr, Queue<int[]> q, int n, int m, int h,int zeroCount){
        boolean[][][] visited = new boolean[h][n][m];
        int[] dr = {0,0,1,0,-1,0};
        int[] dc = {0,0,0,1,0,-1};
        int[] dh = {1,-1,0,0,0,0};

        if(zeroCount==0)return 0;
        
        int day=0;
        while(zeroCount!=0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                int curH = cur[0];
                int curR = cur[1];
                int curC = cur[2];

                visited[curH][curR][curC] = true;
                for(int j=0; j<6; j++){
                    int nh = curH+dh[j];
                    int nr = curR+dr[j];
                    int nc = curC+dc[j];
                    
                    if(nh>=0 && nh<h && nr>=0 && nr< n && nc>=0 && nc<m && arr[nh][nr][nc]==0 && !visited[nh][nr][nc]){
                        visited[nh][nr][nc]=true;
                        q.add(new int[]{nh,nr,nc});
                        arr[nh][nr][nc]=1;
                        zeroCount--;
                    }
                }
            }

            day++;
            if(zeroCount == 0)return day;
        }   

        return -1;
        

    }       
}