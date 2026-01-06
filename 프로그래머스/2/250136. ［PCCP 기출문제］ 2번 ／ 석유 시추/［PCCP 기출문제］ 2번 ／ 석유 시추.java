import java.util.*;

class Solution {
    //bfs로 넓이 탐색 -> 좌우 min max도 탐색 -> map<>에 석유량 만큼 ++ -> map최대값 찾고 끝
    Map<Integer, Integer> oilMap;
    int n;
    int m;
    boolean[][] visited;
    int[][] land;
    
    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        oilMap = new HashMap<>();
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        
        int maxKey=0;
        int maxV=0;
        
        for(int key : oilMap.keySet()){
            int v = oilMap.get(key);
            if(maxV<v){
                maxKey=key;
                maxV=v;
            }
        }
        return maxV;
    }
    
    public void bfs(int r, int c){
        int[] dr = new int[]{1,0,0,-1};
        int[] dc = new int[]{0,1,-1,0};
        int min = m-1;
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[r][c]=true;
        q.add(new int[]{r,c});
        int amount=0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            amount++;
            if(curC>max)max=curC;
            if(curC<min)min=curC;
            for(int i=0;i<4;i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && land[nr][nc]==1){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
            
        }
        for(int i=min; i<=max; i++){
            oilMap.put(i,oilMap.getOrDefault(i,0)+amount);
        }
    }
}