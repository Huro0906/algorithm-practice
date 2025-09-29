
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            switch(st.nextToken()){
                case "push":
                q.push(Integer.parseInt(st.nextToken()));
                break;

                case "pop":
                sb.append(q.pop()).append("\n");
                break;

                case "size":
                sb.append(q.size()).append("\n");
                break;

                case "empty":
                if(q.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
                break;

                case "front":
                sb.append(q.front()).append("\n");
                break;

                case "back":
                sb.append(q.back()).append("\n");
                break;
            }
        }

        System.out.println(sb.toString());
        
    }
}

class Queue{
    private LinkedList<Integer> array = new LinkedList<>();
    private int front;
    private int rear;

    public Queue(){
        this.front = -1;
        this.rear = -1;
    }

    public void push(int v){
        array.add(++rear, v);
    }

    public int pop(){
        if(!isEmpty()){
            return array.get(++front);
        }
        else{
            return -1;
        }
    }   

    public int size(){
        return rear - front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public int front(){
        if(!isEmpty()){
            return array.get(front+1);
        }
        else{
            return -1;
        }
    }

    public int back(){
        if(!isEmpty()){
            return array.get(rear);
        }
        else{
            return -1;
        }
    }
}
    
