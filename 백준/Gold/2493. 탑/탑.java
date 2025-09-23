import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> stack = new Stack<>();

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[1] < height){
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }
            else{
                sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[]{i+1, height});

        }

        System.out.println(sb.toString().trim());
    }
    }

