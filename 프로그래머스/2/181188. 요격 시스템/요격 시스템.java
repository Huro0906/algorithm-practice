import java.util.*;

class Solution {
    //모든 애들의 시작지점에 요격을 하고 -> 하나씩 줄이는데 모두 요격이 되는경우에만 줄임.
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((target1, target2) ->{
            return Integer.compare(target1[1],target2[1]);
        });
        
        for(int[] target : targets){
            pq.add(target);
        }
        
        int recent=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            //만약 cur이 recent사이에 존재하면 계속 poll만 진행
            if(cur[0]<recent){
                continue;
            }
            else{
                recent = cur[1];
                answer++;
            }
            
        }
        return answer;
    }
}