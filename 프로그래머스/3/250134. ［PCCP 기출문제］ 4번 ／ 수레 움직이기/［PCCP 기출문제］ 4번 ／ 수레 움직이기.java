import java.util.*;
class Solution {
    int[][] maze;
    int n;
    int m;
    int[][] endLoc;
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int minTurn = Integer.MAX_VALUE;
    int[] dr = new int[]{1,0,0,-1};
    int[] dc = new int[]{0,1,-1,0};
    
    //0 은 빨강 1은 파랑
    int[][] startLoc;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        startLoc = new int[2][];
        endLoc = new int[2][];
        redVisited= new boolean[n][m];
        blueVisited= new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    startLoc[0]=new int[]{i,j};
                }
                else if(maze[i][j]==2){
                    startLoc[1]=new int[]{i,j};
                }
                else if(maze[i][j]==3){
                    endLoc[0]=new int[]{i,j};
                }
                else if(maze[i][j]==4){
                    endLoc[1] = new int[]{i,j};
                }
            }
        }
        redVisited[startLoc[0][0]][startLoc[0][1]]=true;
        blueVisited[startLoc[1][0]][startLoc[1][1]]=true;
        dfs(startLoc[0],startLoc[1],0);
        return minTurn==Integer.MAX_VALUE ? 0 : minTurn;
    }
    
    public void dfs(int[] red, int[] blue, int turn){
        if(minTurn<turn)return;
        
        List<int[]> nRedList = new ArrayList<>();
        List<int[]> nBlueList = new ArrayList<>();
        
        boolean redArrived = isArrived(red[0],red[1],0);
        boolean blueArrived = isArrived(blue[0],blue[1],1);
        
        if(redArrived && blueArrived){
            minTurn = Math.min(minTurn, turn);
            return;
        }
        if(redArrived){
            nRedList.add(red);
        }
        else{
            for(int i=0; i<4; i++){
                int[] nRed = new int[]{red[0]+dr[i],red[1]+dc[i]};
                if(isValid(nRed[0],nRed[1]) && !redVisited[nRed[0]][nRed[1]]){
                    nRedList.add(nRed);
                }
            }
        }
        
        if(blueArrived){
            nBlueList.add(blue);
        }
        else{
            for(int i=0; i<4; i++){
                int[] nBlue = new int[]{blue[0]+dr[i],blue[1]+dc[i]};
                if(isValid(nBlue[0],nBlue[1]) && !blueVisited[nBlue[0]][nBlue[1]]){
                    nBlueList.add(nBlue);
                }
            }
        }
        
        for(int[] nr : nRedList){
            for(int[] nb: nBlueList){
                //같은 칸으로 이동 불가
                if(nr[0]==nb[0] && nr[1]==nb[1])continue;
                
                //위치 바꾸기 불가
                if(nr[0]==blue[0] && nr[1]==blue[1] &&
                  nb[0]==red[0] && nb[1] == red[1])continue;
                
                if(!redArrived)redVisited[nr[0]][nr[1]]=true;
                if(!blueArrived)blueVisited[nb[0]][nb[1]]=true;
                
                dfs(nr,nb,turn+1);
                
                if(!redArrived)redVisited[nr[0]][nr[1]]=false;
                if(!blueArrived)blueVisited[nb[0]][nb[1]]=false;
            }
        }
    }
    
    
    
    public boolean isArrived(int r, int c, int index){
        return r==endLoc[index][0] && c==endLoc[index][1];
    }
    
    //벽이 아니고 범위를 벗어나지 않는지 
    public boolean isValid(int r, int c){
        return r>=0 && r<n && c>=0 && c<m && maze[r][c]!=5;
    }
    
}