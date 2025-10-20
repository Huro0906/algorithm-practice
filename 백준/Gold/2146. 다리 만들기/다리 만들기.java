import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int islandCount = 0;
        
        int n = Integer.parseInt(br.readLine());
        short[][][] arr = new short[n][n][2];
        for(int i=0; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j][0] = (byte)(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j][0]==1){
                    setBoundary(arr, n, new int[]{i,j}, (short)(++islandCount+1));
                }
            }
        }

        System.out.println(bfs(arr,n));
    }

    public static void setBoundary(short[][][]arr, int n, int[] start, short marker){
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[n][n];
        q.add(start);
        arr[start[0]][start[1]][0] = marker;
        visited[start[0]][start[1]] = true;
    
        
        while(!q.isEmpty()){
            int[]cur = q.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc] && arr[nr][nc][0]==1){
                    arr[nr][nc][0] = marker;
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }

    
    public static int bfs(short[][][] arr, int n){
        short len=1;
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        boolean isLeast = false;
        int leastLen = 10000;
        
        Queue<int[]> q = findBorder(arr, n);
        while(!q.isEmpty()){
            int qSize = q.size();
            if(isLeast){
                return leastLen;
            }
            for(int i=0; i<qSize; i++){
                int[] cur = q.poll();
                short marker = arr[cur[0]][cur[1]][0];
                for(int j=0; j<4; j++){
                    int nr = cur[0]+dr[j];
                    int nc = cur[1]+dc[j];
                    
                    if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc][0]==0){
                        arr[nr][nc][1]= len;
                        arr[nr][nc][0] = marker;
                        q.add(new int[]{nr,nc});
                    }
                    else if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc][0]!=0 && arr[nr][nc][0]!=arr[cur[0]][cur[1]][0]){
                        isLeast = true;
                        if(arr[nr][nc][1] + arr[cur[0]][cur[1]][1]<leastLen){
                            leastLen = arr[nr][nc][1] + arr[cur[0]][cur[1]][1];
                        }
                    }
                }
            }
            len++;
        }
        return -1;
        
    }

    static Queue<int[]> findBorder (short[][][] arr, int n){
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j][0] == 0)continue;

                for(int k=0; k<4; k++){
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && arr[nr][nc][0]==0){
                        q.add(new int[]{i,j});
                        break;
                    }
                }
            }
        }
        return q;
    }
}