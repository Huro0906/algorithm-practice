import java.util.*;
import java.io.*;

public class Main {
    static int[] map = new int[100001];
    static int start;
    static int end;
    static int answer=0;
    static int turn=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        if(start==end){
            turn=0;
            answer=1;
        }else
            bfs();
        
        System.out.println(turn+"\n"+answer);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        boolean isFinished = false;
        
        while(!q.isEmpty() && !isFinished){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                int cur = q.poll();
                for(int n : new int[]{cur+1,cur-1,cur*2}){
                    if(n<0 || n>100000)continue;
                    
                    if(n == end){
                        isFinished=true;
                        answer++;
                        continue;
                    }

                    if(map[n]==0 || map[n]==turn+1){
                        map[n] = turn+1;
                        q.add(n);
                    }
                }
                
            }
            turn++;
        }
        
    }
}
