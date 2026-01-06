import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> degree = new HashMap<>();
        int[] answer =   new int[4];
        //int[0]:out [1]:in
        for(int[] edge : edges){
            degree.putIfAbsent(edge[0],new int[2]);
            degree.putIfAbsent(edge[1],new int[2]);
            //out
            degree.get(edge[0])[0]++;
            //in
            degree.get(edge[1])[1]++;
        }
        
        for(int key : degree.keySet()){
            int[] inOut = degree.get(key);
            
            int out = inOut[0];
            int in = inOut[1];
            
            if(in==0 && out>=2){
                answer[0] = key;
            }else if(out==0){
                answer[2]++;
            }else if(in>=2 && out==2){
                answer[3]++;
            }
        }
        
        answer[1] = degree.get(answer[0])[0]-answer[2]-answer[3];
        
        return answer;
    }
}