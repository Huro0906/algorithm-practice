import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][]dp = new int[triangle.length][];
        dp[0] = new int[]{triangle[0][0]};
        int max=0;
        for(int i=1; i<triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            for(int j=0; j<triangle[i].length; j++){
                int cur = triangle[i][j];
                int a = j==0? 0 : dp[i-1][j-1]+cur;
                int b = j==triangle[i].length-1 ? 0 : dp[i-1][j]+cur;
                dp[i][j] = Math.max(a,b);
                
                if(dp[i][j]>max)max = dp[i][j];
            }
        }
        return max;
    }
    
}