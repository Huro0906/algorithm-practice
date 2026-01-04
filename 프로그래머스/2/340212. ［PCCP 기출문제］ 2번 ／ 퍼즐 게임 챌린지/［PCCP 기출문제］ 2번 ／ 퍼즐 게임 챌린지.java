import java.util.*;

class Solution {
    int[] diffs;
    int[] times;
    long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        int answer = 0;
        return binarySearch(1,Integer.MAX_VALUE);
    }
    
    public int binarySearch(int start, int end){
        if(start>=end)return end;
        
        int mid = (int)(((long)start+(long)end)/2);
        
        if(solve(mid)){
            return binarySearch(start, mid);
        }else{
            return binarySearch(mid+1, end);
        }
    }
    
    public boolean solve(int level){
        long time=0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i]<=level){
                time+=times[i];
            }
            else{
                int count = diffs[i]-level;
                if(i>0)
                    time += count*(times[i-1]+times[i]) + times[i];
                else
                    time += count*(times[i]) + times[i];
            }
        }
        if(time > limit)return false;
        return true;
    }
}