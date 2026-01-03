import java.util.*;

class Solution {
    int result =0;
    boolean[] selected;
    int[][] q;
    int[]ans;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        selected = new boolean[n+1];
        this.ans = ans;
        this.q = q;
        combine(0, n, 1);
        return result;
    }
    
    public void combine (int depth, int n,int idx){
        if(depth==5){
            if(check())result++;
            return;
        }
        for(int i = idx; i<=n; i++){
            selected[i] = true;
            combine(depth+1, n, i+1);
            selected[i] = false;
        }
    }
    
    public boolean check(){
        int[] dup = new int[q.length];
        for(int j=0; j<q.length; j++){
            for(int k=0; k<5; k++){
                if(selected[q[j][k]])
                    dup[j]++;
            }
        }
        
        for(int j=0; j<q.length; j++){
            if(ans[j]!=dup[j])return false;
        }
        return true;
        
    }
}