import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        //현 기온이 
        int[] dp = new int[51];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[temperature+10]=0;
        //index 방식: -10~40도이므로 +10 해서 적용 (0~50);
        for(int i=0; i<onboard.length; i++){
            int[] nDp = new int[51];
            Arrays.fill(nDp,Integer.MAX_VALUE);
            for(int j=0; j<=50; j++){
                int temp = j-10;
                if(dp[j]==Integer.MAX_VALUE)continue;
                if(onboard[i]==1 && (temp<t1 || temp>t2))continue;
                
                //킬 때 
                //1. 희망온도가 더 높은경우 
                if(j+1<=50){
                    nDp[j+1] = Math.min(dp[j]+a,nDp[j+1]);
                }
                //2. 희망온도가 더 낮은경우
                if(j-1>=0){
                    nDp[j-1] = Math.min(dp[j]+a,nDp[j-1]);
                }
                //3. 희망온도가 동일한경우
                nDp[j] = Math.min(dp[j]+b,nDp[j]);
                
                //끌 때
                //1. 밖 온도가 더 높은경우
                if(temperature > temp && j+1<=50){
                    nDp[j+1] = Math.min(dp[j],nDp[j+1]);
                }
                //2, 밖 온도와 같은경우
                else if(temperature == temp){
                    nDp[j] = Math.min(dp[j],nDp[j]);
                }
                //3. 밖 온다가 더 낮은경우 
                else if(temperature < temp && j-1>=0){
                    nDp[j-1] = Math.min(dp[j],nDp[j-1]);
                }
            }
            dp = nDp;
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0; i<=50; i++){
            
            if(dp[i]<min){
                min = dp[i];
            }
        }
        return min;
    }
}