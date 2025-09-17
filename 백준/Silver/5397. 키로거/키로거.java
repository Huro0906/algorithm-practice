import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static int pt =0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++){
            pt=0;
            List<Character> arr = new LinkedList<>();
            char[] input = sc.nextLine().toCharArray();
            for(char c : input){
                switch(c){
                    case '<':
                    moveLeft(arr);
                    break;

                    case '>':
                    moveRight(arr);
                    break;

                    case '-':
                    delete(arr);
                    break;
                    
                    default:
                    insert(arr, c);
                }
            }
            
            String result = arr.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println(result);
        }
    }

    public static void delete(List<Character> arr){
        if(pt!=0)arr.remove(--pt);
    }

    public static void insert(List<Character> arr, char in){
        arr.add(pt++, in);
    }

    public static void moveLeft(List<Character> arr){
        if(pt!=0)pt--;
    }

    public static void moveRight(List<Character> arr){
        if(pt<arr.size())pt++;
    }

    
    
}