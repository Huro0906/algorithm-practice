import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int n;
    int k;
    int[][] reqs;
    
    public int solution(int k, int n, int[][] reqs) {
        this.n = n;
        this.k = k;
        this.reqs = reqs;
        
        for(int[]req : reqs){
            int start = req[0];
            int time = req[1];
            int category = req[2];
            
        }
        int[] mentors = new int[k+1];
        Arrays.fill(mentors,1);
        mentors[0]=0;
        combine(k,mentors,n,1);
        return answer;
    }
    
    public void combine(int depth, int[] mentors, int max, int idx){
        if(depth == max){
            int time = counsel(mentors);
            if(time<answer){
                answer = time;
            }
            return;
        }
        
        for(int i=idx; i<=k; i++){
            mentors[i]++;
            combine(depth+1, mentors, max, i);
            mentors[i]--;
        }
    }
    
    public int counsel(int[] mentors){
        //상담시간
        int total=0;
        //현재 시간
        int curT=0;
        PriorityQueue<Integer>[] pq = new PriorityQueue[mentors.length];
        for(int i=0; i<mentors.length; i++){
            pq[i] = new PriorityQueue<>();
        }
        
        for(int[] req : reqs){
            int start = req[0];
            int time = req[1];
            int category = req[2];
            
            for(int i=1; i<=k; i++){
                while(!pq[i].isEmpty() && pq[i].peek()<=start){
                    pq[i].poll();
                }
            }
            
            // 상담원이 없거나, 멘토가 여유가 있는 경우
            if(pq[category].isEmpty() || pq[category].size()<mentors[category]){
                pq[category].add(start+time);
            }
            //상담원이 없는 경우
            else{
                int end =pq[category].poll();
                total += end-start;
                pq[category].add(end+time);
            }
        }
        return total;
    }
}