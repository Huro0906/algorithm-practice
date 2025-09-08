import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        in.nextLine();

        for(int i=0; i<cnt; i++){
            String word = in.nextLine();
            if(isValidPS(word)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        
    }
    
    public static Boolean isValidPS(String word){
        int left =0;
        for(char c : word.toCharArray()){
            if(c == '('){
                left++;
            }
            else{
                if(left>0){
                    left--;
                }
                else{
                    return false;
                }
            }
        }
        if(left == 0){
            return true;
        }
        else{
            return false;
        }
    }

    

}

 