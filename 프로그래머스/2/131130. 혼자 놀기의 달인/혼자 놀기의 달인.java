import java.util.*;

class Solution {
    List<Integer> loops = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        Queue<Integer> q = new ArrayDeque<>();
        while(true){
            for(int i=0; i<cards.length; i++){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                    break;
                }
            }
            
            if(q.isEmpty())break;
            int s = 0;
            while(!q.isEmpty()){
                int curIdx = q.poll();
                s++;
                int next = cards[curIdx]-1;
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
            loops.add(s);
        }
        
        return findMax();
    }
    
    
    public int findMax(){
        if(loops.size()==1)return 0;
        loops.sort(Comparator.reverseOrder());
        return loops.get(0)*loops.get(1);
    }
}