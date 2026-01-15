import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        int better=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(b[0],a[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });
        
        
        for(int i=1; i<scores.length; i++){
            pq.add(scores[i]);
        }
        
        int max=0;
        while(!pq.isEmpty()){
            int[] score = pq.poll();
            if(score[0]>wanho[0] && score[1]>wanho[1]){
                return -1;
            }
            
            if(max>score[1])continue;
            
            if(wanho[0]+wanho[1]<score[0]+score[1])better++;
            
            if(score[1]>max)max = score[1];
            
        }

        
        return better+1;
        
    }
}