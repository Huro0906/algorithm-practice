import java.util.Scanner;

public class Main {
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        for(int i=0; i<n; i++){
            int[] cntArr = new int[26]; 
            Boolean isPossible = true;
            String input1 = sc.next();
            String input = sc.next();

            if(input1.length()!=input.length()){
                System.out.println("Impossible");
                continue;
            }

            input1.chars().forEach(c -> cntArr[c-'a']++);

            for(char c : input.toCharArray()){
                if(--cntArr[c-'a']<0){
                    isPossible =  false;
                    break;
                }
            }
            if(isPossible){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }
        
    }
    
}