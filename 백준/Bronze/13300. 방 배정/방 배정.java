import java.util.Scanner;

public class Main {
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        int arr[][] = new int[2][7];
        
        int amount,limit;
        int s,g;
        int room=0;


        amount = sc.nextInt();
        
        limit = sc.nextInt();

        for(int i=0; i<amount; i++){
            s = sc.nextInt();
            g = sc.nextInt();
            if(++arr[s][g]%limit==1){
                room++;
            }
        }
        System.out.println(room);
    }
    
}