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
        char[][] arr = new char[n][m];
        int[] loc = null;
        Queue<int[]>fireQ = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                arr[i][j] = line[j];
                if(line[j]=='J') loc = new int[]{j,i};
                if(line[j] == 'F') fireQ.add(new int[]{j,i});
            }
        }

        int day = bfs(arr,n,m,loc,fireQ);

        if(day ==-1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(day);
        }
        
        
        
    }

    public static int bfs(char[][] arr, int n, int m, int[] loc, Queue<int[]> fireQ){
        int day=1;
        Queue<int[]>myQ = new ArrayDeque<>();
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        myQ.add(loc);

        while(!myQ.isEmpty()){
            int fSize = fireQ.size();
            for(int i=0; i<fSize; i++){
                int[] current = fireQ.poll();
                int curX = current[0];
                int curY = current[1];
                for(int j=0; j<4; j++){
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];

                    //다음 탐색경로가 .또는 J일 경우 
                    if(nx>=0 && nx<m && ny>=0 && ny< n && (arr[ny][nx]=='.' )){
                        arr[ny][nx]= 'F';
                        fireQ.add(new int[]{nx,ny});
                    }
                }
            }
            int size = myQ.size();
            for(int i=0; i<size; i++){
                int[] current = myQ.poll();
                int curX = current[0];
                int curY = current[1];
                if(curX==0 || curX==m-1 || curY==0 || curY==n-1){
                    return day;
                }
                for(int j=0; j<4; j++){
                    int nx = curX + dx[j];
                    int ny = curY + dy[j];

                    //다음 탐색경로가 .일경우
                    if(nx>=0 && nx<m && ny>=0 && ny< n && arr[ny][nx]=='.'){
                        
                        arr[ny][nx]= 'J';
                        myQ.add(new int[]{nx,ny});
                    }
                }
            }

            
            day++;

            
        }

        return -1;

    }
}