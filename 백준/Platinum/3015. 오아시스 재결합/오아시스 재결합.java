
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
            int sameHeightCount = 1;

            while(!stack.isEmpty() && stack.peek()[0]<h){
                p += stack.pop()[1];
            }

            if(!stack.isEmpty() && stack.peek()[0] == h){
                int[] top = stack.pop();
                
                sameHeightCount += top[1];
                p += top[1];

                if(!stack.isEmpty()){
                    p++;
                }
            }
            else if(!stack.isEmpty() && stack.peek()[0]>h){
                p++;
            }

            stack.push(new int[]{h,sameHeightCount});
        }

        System.out.println(p);
        
    }}