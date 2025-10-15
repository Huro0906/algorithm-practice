import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        byte[][] arr= new byte[n][m];

        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();

            for(int j=0; j<m; j++){
                arr[i][j] = (byte)(line[j]-'0');
            }
        }

        System.out.println(bfs(arr,n,m));
        
    }

    public static int bfs(byte[][] arr, int n, int m){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        boolean[][][] visited = new boolean[n][m][2];
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        int day=1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0; j<size; j++){
                int[] cur = q.poll();
            
                if(cur[0]==n-1 && cur[1]==m-1){
                    return day;
                }

                for(int i=0; i<4; i++){
                    int nr = cur[0]+dr[i];
                    int nc = cur[1]+dc[i];
                    if(nr>=0 && nr<n && nc>=0 && nc<m ){
                        if(arr[nr][nc]==1 && cur[2]<1 && !visited[nr][nc][cur[2]+1]){
                            visited[nr][nc][cur[2]+1]=true;
                            q.add(new int[]{nr,nc,cur[2]+1});
                        }
                        else if(arr[nr][nc]==0 && cur[2]<=1 && !visited[nr][nc][cur[2]]){
                            visited[nr][nc][cur[2]]=true;
                            q.add(new int[]{nr,nc,cur[2]});
                        }
                    }
                }
            }
            day++;
            
        }
        return -1;

    }
}