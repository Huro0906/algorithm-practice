import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotCnt = routes.length;
        
        // Queue 구조: {r, c, robotIdx, routeStepIdx}
        // routeStepIdx: 현재 routes[robotIdx] 배열에서 몇 번째 포인트를 향해 가고 있는지 나타냄 (1부터 시작)
        Queue<int[]> q = new LinkedList<>();
        
        // 첫 시작 위치에서의 충돌 체크를 위한 맵
        Map<String, Integer> startMap = new HashMap<>();
        
        for(int i = 0; i < robotCnt; i++) {
            // 시작 포인트 인덱스 가져오기 (1번부터 시작하므로 -1)
            int startIdx = routes[i][0] - 1;
            int r = points[startIdx][0];
            int c = points[startIdx][1];
            
            // 큐에 넣기: {r, c, 로봇번호, 다음목표인덱스(1)}
            q.add(new int[]{r, c, i, 1});
            
            // 0초일 때 충돌 체크 (좌표를 문자열 키로 단순화)
            String key = r + "," + c;
            startMap.put(key, startMap.getOrDefault(key, 0) + 1);
        }
        
        // 0초일 때 충돌한 곳 카운트
        for(int count : startMap.values()){
            if(count > 1) answer++;
        }
        
        // BFS 시뮬레이션 시작
        while(!q.isEmpty()){
            int size = q.size();
            
            // 이번 턴(시간)에 로봇들이 도착한 좌표를 기록할 맵
            // int[101][101] 배열을 매번 만드는 것보다 Map이 메모리상 유리할 수 있음 (좌표가 넓을 경우)
            // 하지만 문제 조건(100x100)상 배열도 괜찮아. 여기선 직관적인 배열로 갈게.
            int[][] map = new int[101][101];
            
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int robotIdx = cur[2];
                int nextRouteStep = cur[3];
                
                // 현재 로봇의 다음 목표 포인트
                int targetPointIdx = routes[robotIdx][nextRouteStep] - 1;
                int targetR = points[targetPointIdx][0];
                int targetC = points[targetPointIdx][1];
                
                // 이동 로직 (r 먼저 이동, 그 다음 c 이동)
                int nr = r;
                int nc = c;
                
                if(nr != targetR){
                    nr += (targetR > nr) ? 1 : -1;
                } else if(nc != targetC){
                    nc += (targetC > nc) ? 1 : -1;
                }
                
                // 이동한 위치 기록
                map[nr][nc]++;
                
                // 다음 상태 큐에 넣기 판별
                if(nr == targetR && nc == targetC){
                    // 목표 포인트에 도달했다면?
                    if(nextRouteStep + 1 < routes[robotIdx].length){
                        // 다음 목표가 남았다면 갱신해서 넣기
                        q.add(new int[]{nr, nc, robotIdx, nextRouteStep + 1});
                    }
                    // 다음 목표가 없다면(최종 도착) 큐에 안 넣고 끝!
                } else {
                    // 아직 목표에 도달 못했으면 현재 목표 유지
                    q.add(new int[]{nr, nc, robotIdx, nextRouteStep});
                }
            }
            
            // 이번 턴에 충돌 발생했는지 체크
            for(int r=0; r<=100; r++){
                for(int c=0; c<=100; c++){
                    if(map[r][c] > 1) answer++;
                }
            }
        }
        
        return answer;
    }
}