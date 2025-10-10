import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];


        for(int i=0; i<n; i++){ 
            char[] line = br.readLine().toCharArray();

            for(int j=0; j<n; j++){
                arr[i][j] = line[j];
            }
        }

        System.out.print(bfs(arr,n)+" ");

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]=='R')arr[i][j]='G';
            }
        }
        System.out.print(bfs(arr,n));
        
        

    }

    public static int bfs(char[][] arr, int n){
        boolean[][] visited = new boolean[n][n];
        int cnt=0;

        Queue<int[]> q = new ArrayDeque<>();
        int[] dl = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    cnt++;
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        
                        for(int k=0;k<4; k++){
                            int nc = cur[1]+dc[k];
                            int nl = cur[0]+dl[k];

                            if(nc>=0 && nc<n && nl>=0 && nl<n && arr[cur[0]][cur[1]] == arr[nl][nc] && !visited[nl][nc]){
                                q.add(new int[]{nl,nc});
                                visited[nl][nc]=true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }


}