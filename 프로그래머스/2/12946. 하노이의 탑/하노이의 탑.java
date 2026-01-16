import java.util.*;
class Solution {
    int[][] answer;
    int idx=0;
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,3,2);
        return answer;
    }
    public void hanoi(int n, int start, int end, int sub){
        if(n==1)
            move(start,end);
        else{
            hanoi(n-1,start, sub, end);
            move(start,end);
            hanoi(n-1,sub,end,start);
        }
    }
    public void move(int start, int end){
        answer[idx++] = new int[]{start,end};
    }
}