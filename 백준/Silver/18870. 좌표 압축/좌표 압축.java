import java.util.*;
import java.io.*;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[] arr;
    public static int[] sorted;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sorted = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(sorted);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            sb.append(binarySearch(0,sorted.length-1,arr[i])).append(" ");
        }

        System.out.print(sb);
    }
    //중복인 경우
    public static int binarySearch(int start, int end, int target){
        if(end<=start)return end;
        int mid = (start+end)/2;
        int midV = sorted[mid];
        if(midV==target){
            return mid;
        }
        if(midV<target){
            return binarySearch(mid+1, end, target);
        }
        else{
            return binarySearch(start, mid-1,target);
        }
    }




}