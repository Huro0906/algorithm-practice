
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int min=Integer.MAX_VALUE;
    static int[][] cctv = new int[8][];
    static int cctvCnt=0;
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1}; 
    static int[][] cctvDir = {{0},{0,2},{0,3},{3,0,1},{3,0,1,2}};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int row = 0; row<n; row++){
            st = new StringTokenizer(br.readLine());

            for(int col = 0; col<m; col++){
                int in = Integer.parseInt(st.nextToken());
                map[row][col] = in;
                if(in!=0 && in !=6){
                    cctv[cctvCnt++] = new int[]{row,col,in,0};
                }

                
            }
        }

        combine(0);

        System.out.println(min);
        
    }

    public static void combine(int depth ){
        if(depth==cctvCnt){
            count();
            return;
        }

        for(int i=0; i<4; i++){
            cctv[depth][3]=i;
            combine(depth+1);
        }
    }
    
    public static void count(){
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(map[row][col]==-1)map[row][col]=0;
            }
        }
        
        for(int i = 0; i<cctvCnt; i++){
            int category = cctv[i][2];
            int r = cctv[i][0];
            int c = cctv[i][1];
            int dir = cctv[i][3];
            for(int d : cctvDir[category-1]){
                monitor(r,c,dr[(dir+d)%4],dc[(dir+d)%4]);
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0)cnt++;
            }
        }
        if(min>cnt){
            min = cnt;
        }
    }

    public static void monitor(int r, int c, int nr, int nc){
        while(true){
            if(r<0 || r>=n || c<0 || c>=m || map[r][c]==6)return;

            if(map[r][c]==0)map[r][c]=-1;
            r+=nr;
            c+=nc;    
        }
    }


}