import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt =0;

        byte[][] arr= new byte[n][n];
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer> wList = new ArrayList<>();
        

        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();

            for(int j=0; j<n; j++){
                arr[i][j] = (byte)(line[j]-'0');
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    cnt++;
                    wList.add(bfs(arr,visited,new int[]{i,j},n));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        wList.sort(Comparator.naturalOrder());
        sb.append(cnt);
        
        wList.stream().forEach((i) -> sb.append("\n").append(i));
        System.out.println(sb.toString());
    }

    public static int bfs(byte[][] arr, boolean[][] visited, int[] loc, int n){
        int size=1;
        visited[loc[0]][loc[1]]=true;

        int[] dr ={0,1,0,-1};
        int[] dc ={1,0,-1,0};

        Queue<int[]> q = new ArrayDeque<>();

        q.add(loc);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc] && arr[nr][nc] ==1 ){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                    size++;
                }
            }
        }

        return size;
    }
}