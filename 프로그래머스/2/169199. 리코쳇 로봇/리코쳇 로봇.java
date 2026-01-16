import java.util.*;
class Solution {
    char[][] map;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited;
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        int[] dr = new int[]{1,0,0,-1};
        int[] dc = new int[]{0,1,-1,0};
        
        int[] start;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if(c=='R'){
                    start = new int[]{i,j};
                    for(int k=0; k<4;k++){
                        q.add(new int[]{i,j,0});
                    }
                    visited[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int cnt = cur[2];
            //직진
            for(int i=0; i<4; i++){
                int nr=curR;
                int nc=curC;
                while(true){
                    int nextR = nr+dr[i];
                    int nextC = nc+dc[i];
                    if(nextR<0 || nextR>=n || nextC<0 || nextC>=m || map[nextR][nextC]=='D'){
                        break;
                    }
                    nr = nextR;
                    nc = nextC;
                }
                if(map[nr][nc]=='G')return cnt+1;
                if(!visited[nr][nc]){
                    q.add(new int[]{nr,nc,cnt+1});
                    visited[nr][nc]=true;
                }
            }
            
        }

        return -1;
    }
}