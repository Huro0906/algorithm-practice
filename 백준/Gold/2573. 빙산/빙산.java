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
        
        int pieceCount=0;

        int[][] arr = new int[n][m];
        int[] iceRoc;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur!=0){pieceCount++;}
                arr[i][j]= cur;
            }
        }
        System.out.println(bfs(arr,n,m,pieceCount));
    }

    public static int bfs(int[][] arr, int n,int m,int pieceCount){
        int day=1;
        pieceCount -= melt(arr, n, m);
        
        while(pieceCount!=0){
            int[] cur = findNotZero(arr, n, m);
            if(countIceSize(arr, n, m, cur)!= pieceCount)return day;
            else{
                pieceCount -= melt(arr, n, m);
                day++;
            }
        }

        return 0;

    }

    public static int countIceSize(int[][]arr, int n, int m, int[] roc){
        Queue<int[]> q = new ArrayDeque<>();
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[n][m];
        q.add(roc);
        visited[roc[0]][roc[1]] = true;
        int size=1;
        while(!q.isEmpty()){    
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if(nr>=0 &&nr<n &&nc>=0 && nc<m && arr[nr][nc]!=0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                        size++;
                }
            }
        }
        return size;
    }

    public static int[] findNotZero(int[][]arr, int n,int m){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]!=0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int melt(int[][] arr, int n,int m){
        byte[][] neighbor = new byte[n][m];
        int melted = 0;
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int zero =0;
                for(int k=0; k<4; k++){
                    int nr = i+dr[k];
                    int nc = j+dc[k];

                    if(nr>=0 &&nr<n &&nc>=0 && nc<m && arr[nr][nc]==0){
                        zero++;
                    }
                }
                neighbor[i][j] = (byte)zero;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0)continue;
                arr[i][j] = Math.max(0,arr[i][j]-neighbor[i][j]);
                if(arr[i][j]==0)melted++;
            }
        }

        return melted;
    }
}