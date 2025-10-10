import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int low, col;
            StringTokenizer st = new StringTokenizer(br.readLine());

            low = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            int[][] arr = new int[low][col];

            for(int j=0; j<cnt; j++){
                st = new StringTokenizer(br.readLine());

                int l = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[l][c] =1;
            }
            System.out.println(bfs(arr,low,col));
             
        }
    }

    public static int bfs(int[][] arr, int l, int c){
        boolean[][] visited = new boolean[l][c];
        int count=0;

        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;

                    count++;
                
                    while(!q.isEmpty()){
                        int[] current = q.poll();
                        int curL = current[0];
                        int curC = current[1];
                        for(int k=0;k<4;k++){
                            int nL = curL + dx[k];
                            int nC = curC + dy[k];
                            if(nL>=0 && nL<l && nC>=0 && nC<c && arr[nL][nC] ==1 && !visited[nL][nC]){
                                visited[nL][nC]=true;
                                q.add(new int[]{nL,nC});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}