import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        Stack stack = new Stack();

        for(int i=0; i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            switch(st.nextToken()){
                case "push":
                stack.push(Integer.parseInt(st.nextToken()));
                break;
                case "pop":
                System.out.println(stack.pop());
                break;

                case "top":
                System.out.println(stack.top());
                break;

                case "empty":
                System.out.println(stack.isEmpty());
                break;

                case "size":
                System.out.println(stack.size());
                break;
            }

            
        }
    }
        
}

class Stack {
    int[] array;
    int pt;
    public Stack(){
        array = new int[10000];
        pt=0;
    }
    
    public int isEmpty(){
        if(pt==0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void push(int n){
        if(pt<10000){
            array[pt++] = n;
        }
    }

    public int top(){
        if(pt == 0){
            return -1;
        }
        else{
            return array[pt-1];
        }
    }

    public int pop(){
        if(pt == 0){
            return -1;
        }
        else{
            return array[--pt];
        }
    }

    public int size(){
        return pt;
    }
}