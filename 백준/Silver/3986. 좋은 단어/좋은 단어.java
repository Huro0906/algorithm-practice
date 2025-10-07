import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int cnt =0;
        for(int i=0; i<n; i++){
            char[] arr = br.readLine().toCharArray();

            Stack<Character> s = new Stack<>();
            
            for(char c : arr){
                if(!s.isEmpty() && s.peek() == c){
                    s.pop();
                }
                else{
                    s.push(c);
                }
            }
            if(s.isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}