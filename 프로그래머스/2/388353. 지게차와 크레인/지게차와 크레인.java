import java.util.*;

class Solution {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    char[][] map;
    int n, m;

    public int solution(String[] storage, String[] requests) {
        int r = storage.length;
        int c = storage[0].length();
        
        n = r + 2;
        m = c + 2;
        map = new char[n][m];
        
        for(int i=0; i<n; i++) Arrays.fill(map[i], ' ');
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(String req : requests){
            char target = req.charAt(0);
            
            boolean[][] isOutside = bfs();
            
            List<int[]> toRemove = new ArrayList<>();
            
            for(int i=1; i<=r; i++){
                for(int j=1; j<=c; j++){
                    if(map[i][j] == target){
                        if(req.length() > 1){
                            
                            toRemove.add(new int[]{i, j});
                        } else {
                            
                            if(check(i, j, isOutside)){
                                toRemove.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }
            
            for(int[] p : toRemove){
                map[p[0]][p[1]] = ' ';
            }
        }
        
        int count = 0;
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(map[i][j] != ' ') count++;
            }
        }
        
        return count;
    }
    
    public boolean[][] bfs(){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(!visited[nr][nc] && map[nr][nc] == ' '){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return visited;
    }
    
    public boolean check(int r, int c, boolean[][] isOutside){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isOutside[nr][nc]) return true;
        }
        return false;
    }
}