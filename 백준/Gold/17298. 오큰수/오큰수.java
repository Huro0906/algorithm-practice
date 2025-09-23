
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr = new int[n+1];
        Arrays.fill(arr,-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){
            int h = Integer.parseInt(st.nextToken());
            
            while(!stack.isEmpty() && stack.peek()[1]<h){
                int[] tmp = stack.pop();
                
                arr[tmp[0]] = h;
            }

            stack.push(new int[]{i,h});
        }
        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}