
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
            boolean isDup = false;
            while(!stack.isEmpty() && stack.peek()[0]<=h){
                if(h == stack.peek()[0] && stack.size()>1){
                    p++;
                    p+= (stack.peek()[1]++);
                    isDup = true;
                    break;
                }
                else if(h == stack.peek()[0] && stack.size()==1){
                    p+= (stack.peek()[1]++);
                    isDup = true;
                    break;
                }
                else{
                    p+=stack.pop()[1];
                    isDup=false;
                }
            }
            if(!isDup && !stack.isEmpty()){
                p++;
                stack.push(new int[]{h,1});
            }
            else if(!isDup){
                stack.push(new int[]{h,1});
            }
        }

        System.out.println(p);
        
    }}