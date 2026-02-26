import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] inc = new int[n];
        int[] des = new int[n];

        int incIdx = 0;
        int desIdx = 0;
        int[][]dp = new int[n][2];
        inc[0] = arr[0];
        des[0] = arr[n-1];
        dp[0][0]=1;
        dp[0][1]=1;
        for(int i=1; i<n; i++){
            if(inc[incIdx]<arr[i]){
                inc[++incIdx]=arr[i];
                dp[i][0] = incIdx+1;
            }
            else{
                int idx = binarySearch(0,incIdx,arr[i],inc);
                inc[idx] = arr[i];
                dp[i][0] = idx+1;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(des[desIdx]<arr[i]){
                des[++desIdx] = arr[i];
                dp[i][1] = desIdx+1;
            }
            else{
                int idx = binarySearch(0,desIdx,arr[i],des);
                des[idx] = arr[i];
                dp[i][1] = idx+1;
            }
        }
        int max=0;

        for(int i=0; i<n; i++){
            int len = dp[i][0]+dp[i][1]-1;
            if(max<len)max = len;
        }
        System.out.println(max);
    }

    public static int binarySearch(int start, int end, int key, int[] arr){
        while(start<end){
            int mid = (end+start)/2;
            
            if(key>arr[mid]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}
