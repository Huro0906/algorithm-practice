import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            char[] command = br.readLine().toCharArray();

            int n = Integer.parseInt(br.readLine());

            String arr = br.readLine().replace("[","").replace("]", "");
            
            Boolean isReverse = false;
            Boolean isError = false;

            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(arr,",");
            for(int j=0; j<n; j++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for(char c: command){
                if(c=='R'){
                    isReverse = !isReverse;
                }
                else{
                    if(deque.isEmpty()){
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if(isReverse){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }
                }
            }
            if(!isError && !deque.isEmpty()){
                StringBuilder sb = new StringBuilder().append("[");
                
                while(!deque.isEmpty()){
                    int tmp;
                    if(isReverse){
                        tmp = deque.removeLast();
                    }
                    else{
                        tmp = deque.removeFirst();
                    }
                    sb.append(tmp).append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("]");
                System.out.println(sb.toString());
            }
            else if(!isError && deque.isEmpty()){
                System.out.println("[]");
            }
            
        }
    }
    }

