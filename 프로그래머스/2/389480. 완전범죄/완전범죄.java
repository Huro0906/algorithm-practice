import java.util.*;

class Solution {
    //과정?
    int[] nDp;
    int[] dp;
    public int solution(int[][] info, int n, int m) {
        nDp = new int[m];
        Arrays.fill(nDp, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        boolean suspendFlag = true;
        nDp[0]=0;
        for(int i=0; i<info.length; i++){
            dp = nDp;
            nDp = new int[m];
            Arrays.fill(nDp,Integer.MAX_VALUE);
            //모든 경우의 수 갱신 
            for(int j=0; j<m; j++){
                if(dp[j]==Integer.MAX_VALUE)continue;
                
                //a가 가져가는 경우
                if( dp[j]+info[i][0]<n){
                    nDp[j] = Math.min(nDp[j], dp[j]+info[i][0]);
                }
                
                
                //b가 가져가는 경우
                if( j+info[i][1]<m){
                    nDp[j+info[i][1]] = Math.min(nDp[j+info[i][1]], dp[j]);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            if(min> nDp[i]){
                min = nDp[i];
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}