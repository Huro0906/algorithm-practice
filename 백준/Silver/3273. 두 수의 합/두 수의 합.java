import java.util.Arrays;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        int cnt = 0;

        Arrays.sort(arr);
        
        int pt1, pt2;
        for(pt1 = 0, pt2 = n-1; pt1!=pt2;){
            if(arr[pt1]+arr[pt2] ==x){
                cnt++;
                pt1++;
            }
            else if(arr[pt1]+arr[pt2]>x){
                pt2--;
                continue;
            }
            else{
                pt1++;
                continue;
            }
        }

        System.out.println(cnt);

        sc.close();
    }

    
}