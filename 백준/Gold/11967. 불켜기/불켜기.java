import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n,m,x,y,a,b;
    static boolean[][] visited, isLight;
    static List<int[]>[][] list;
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1};
    static int roomCnt =1;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1][n+1];
        isLight = new boolean[n+1][n+1];
        
        list = new List[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a,b,x,y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(list[x][y] == null)list[x][y] = new ArrayList<>();
            list[x][y].add(new int[]{a,b});
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        q = new ArrayDeque<>();

        q.add(new int[]{1,1});
        visited[1][1]=true;
        isLight[1][1] = true;
        roomCnt =1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            turnOn(cur[0],cur[1]);
            for(int i=0; i<4; i++){
                int nr = dr[i]+cur[0];
                int nc = dc[i]+cur[1];
                
                if(nr>=1 && nr<=n && nc>=1 && nc<=n && isLight[nr][nc] && !visited[nr][nc]){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }   
        }
        return roomCnt;
    }
    //해당 좌표의 스위치에 연결된 불 키기 + 인접한 타일에 이미 접근한 기록이 있으면 갈수 있는 타일이므로 q에 추가 처리 
    public static void turnOn(int r,int c){
        if(list[r][c]==null)return;
        for(int[] cur : list[r][c]){
            if(!isLight[cur[0]][cur[1]]){
                isLight[cur[0]][cur[1]] = true;
                roomCnt++;

                for(int i=0; i<4; i++){
                    int nr = cur[0]+dr[i];
                    int nc = cur[1]+dc[i];
                    if(nr>=1 && nr<=n && nc>=1 && nc<=n && visited[nr][nc]){
                        q.add(new int[]{nr,nc});
                    }
                    
                }
            }
        }
        
    }
}