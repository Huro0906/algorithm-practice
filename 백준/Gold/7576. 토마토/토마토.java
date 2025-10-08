import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        Integer zeroC =0 ;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if(tmp==1){
                    q.add(new int[]{j,i});
                }else if(tmp ==0){
                    zeroC++;
                }
            }
        }
        System.out.println(bfs(arr,q,n,m,zeroC));
        
        
    }

    public static int bfs(int[][] arr, Queue<int[]> q, int n,int m,Integer zeroC){
        
        int day = 0;
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        
        while(!q.isEmpty()){
            if(zeroC==0)break;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] current = q.poll();
                int curX =  current[0];
                int curY = current[1];

                for(int j=0; j<4; j++){
                    int nx = curX+dx[j];
                    int ny = curY+dy[j];
                    if(nx>=0 && nx<m && ny >=0 && ny <n && arr[ny][nx]==0 ){
                        arr[ny][nx] = 1;
                        q.add(new int[]{nx,ny});
                        zeroC--;
                    }
                }
            }
            day++;
        }

        if(zeroC==0){
            return day;
        }
        else{
            return -1;
        }
        
    }   
}