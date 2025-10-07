import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Stack<Character> s = new Stack<>();
        int score = 0; 
        int tmp = 1;
        char last = ' ';
        for(char c: arr){
            if(tmp ==0 )break;
            switch(c){
                case '(':
                tmp*=2;
                s.push(c);
                break;
                case '[':
                tmp*=3;
                s.push(c);
                break;
                case ')':
                if(!s.isEmpty() && s.pop() == '(' ){
                    if(last == '(')score += tmp;
                    tmp /=2;
                }
                else{
                    score =0 ;
                    tmp =0 ;
                }
                break;
                case ']':
                if(!s.isEmpty() && s.pop() == '['){
                    if(last == '['){
                        score += tmp;
                    }
                    
                    tmp /=3;
                }
                else{
                    score = 0;
                    tmp = 0;
                }
                break;
            }
            last = c;
        }
        if(!s.isEmpty())score=0;

        System.out.println(score);
        
    }
}