
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            
            if(n==0){
                break;
            }
            Stack<int[]> stack = new Stack<>();
            long max = 0;
            for(int i=0; i<n; i++){
                int h = Integer.parseInt(st.nextToken());
                while(!stack.isEmpty() && stack.peek()[1]>h){
                    int[] peek = stack.pop();
                    int w;
                    if(stack.isEmpty()){
                        w = i;
                    }
                    else{
                        w = i - stack.peek()[0] -1   ;
                    }
                    long e = (long)w*peek[1];
                    if(max < e){
                        max = e; 
                    }
                }

                stack.push(new int[]{i,h});
            }
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    int[] peek = stack.pop();
                    int w;
                    if(stack.isEmpty()){
                        w = n;
                    }
                    else{
                        w = n - stack.peek()[0] -1   ;
                    }
                    long e = (long)w*peek[1];
                    if(max < e){
                        max = e; 
                    }
                }
                
            }

            System.out.println(max);
        }
    }}
    
