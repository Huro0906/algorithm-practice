import java.util.*;

class Solution {
    //dp[n] : 마지막 블록을 n길이를 뒀을때 경우의 수 
    //1-2-5-2-2-4-2-2-4 .... 
    int mod = 1000000007;
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        //길이가 n짜리인 도형의 개수
        int[] cnt = new int[n+1];
        
        for(int i=1; i<=n; i++){
            if(i==1)cnt[i]=1;
            else if(i==3)cnt[i]=5;
            else if(i%3==0)cnt[i]=4;
            else cnt[i]=2;
        }
        dp[0]=1;
        if (n>=1)
            dp[1]=1;
        if (n>=2)
            dp[2]= 3;
        if (n>=3)
            dp[3]=10;
        //dp[n] = dp[n-1] + dp[n-2]*2 + dp[n-3]*5 + dp[n-4]*2 + dp[n-5]*2 + dp[n-6]*4 2 2,4 ... 
        //지금 이렇게 풀면 n^2
        long dpSum = 0;
        long[] dpSum2 = new long[3];
        for(int i=4; i<=n; i++){
            long count=0;
            //1,2,5 불규칙한 점화식 더하기
            count = ((long)dp[i-1] + (long)dp[i-2]*2 + (long)dp[i-3]*5)%mod;
            dpSum = (dpSum +(long)dp[i-4])%mod;
            dpSum2[(i-4)%3] = (dpSum2[(i-4)%3] + (long)dp[i-4])%mod;
            
            count = (count + dpSum*2)%mod;
            count = (count + dpSum2[i%3]*2)%mod;
            dp[i] = (int)count;
        }
        return dp[n];
    }
}   