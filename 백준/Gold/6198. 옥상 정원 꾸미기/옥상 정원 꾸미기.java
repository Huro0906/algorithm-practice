
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long p = 0;
        for(int i=1; i<=n; i++){
            int h = Integer.parseInt(br.readLine());
            
            while(!stack.isEmpty() && stack.peek()[1]<=h){
                stack.pop();
            }

            p+=stack.size();
            
            stack.push(new int[]{i,h});
        }

        System.out.println(p);
    }
}