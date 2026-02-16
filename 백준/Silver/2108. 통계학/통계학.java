
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());
       int[] arr = new int[8001];
       int min = 5000;
       int max = -5000;
       int maxFre=0;
       int fre=0;
       int freCnt=0;
       int sum=0;

       for(int i=0; i<n; i++){
            int in = Integer.parseInt(br.readLine());
            sum+=in;
            if(in<min)min =in;
            if(in>max)max = in;
            arr[in+4000]++;
            if(arr[in+4000]>maxFre)maxFre = arr[in+4000];
       }


       StringBuilder sb = new StringBuilder();
        //산술 평균
       sb.append(Math.round((double)sum/(double)n)).append("\n");
       int center = n/2+1;
       int cnt=0;
       boolean isFirst=true;
       boolean findFre =false;
       boolean findMid=false;
       for(int i=0; i<=8000; i++){
           if(arr[i]>0)cnt+=arr[i];
           if(cnt >= center && !findMid && arr[i]>0){
               sb.append(i-4000).append("\n");
               findMid=true;
           }
           if(arr[i]==maxFre && !findFre){
               if(!isFirst){
                   fre = i-4000;
                   findFre = true;
               }else{
                   fre = i-4000;
                   isFirst = false;
               }
           }
       }
       sb.append(fre).append("\n");

       sb.append(max-min).append("\n");
       System.out.println(sb);
   }
}