import java.util.*;

class Solution {
    int[] serverQ;
    int total=0;
    int server=0;
    
    public int solution(int[] players, int m, int k) {
        serverQ = new int[k];
        
        for(int player: players){
            int needServer = (int)Math.floor((double)player/(double)m);
            int requirement;
            
            server-=serverQ[0];
            
            for(int i=0; i<k-1; i++){
                serverQ[i] = serverQ[i+1];
            }
            
            requirement = needServer - server;
            if(requirement>0){
                total+=requirement;
                serverQ[k-1] = requirement;
                server+= requirement;
            }
            else{
                serverQ[k-1]=0;
            }
        }
        
        
        return total;
    }
}