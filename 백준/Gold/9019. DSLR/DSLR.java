import java.util.*;
import java.io.*;

public class Main {

    public static class Pair{
        int x;
        String y;
        
        public Pair(int x, String y){
            this.x = x;
            this.y = y;
        }

        public int getLeft(){
            return x;

        }

        public String getRight(){
            return y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bfs(s,e);
        }
    }

    public static void bfs(int start, int end){
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        visited[start]=true;
        q.add(new Pair(start,""));
        boolean isFinished= false;
        
        while(!q.isEmpty()){
            int qSize = q.size();
            
            for(int i=0; i<qSize; i++){
                Pair cur = q.poll();
                int curN = cur.getLeft();
                String curC = cur.getRight();
                if(curN==end){
                    System.out.println(curC);
                }

                int a1 = d(curN);
                int a2 = s(curN);
                int a3= l(curN);
                int a4= r(curN);

                if(!visited[a1]){
                    q.add(new Pair(a1,curC+"D"));
                    visited[a1]=true;
                }
                if(!visited[a2]){
                    q.add(new Pair(a2,curC+"S"));
                    visited[a2]=true;}
                if(!visited[a3]){
                    q.add(new Pair(a3,curC+"L"));
                    visited[a3]=true;}
                if(!visited[a4]){q.add(new Pair(a4,curC+"R"));
                visited[a4]=true;}
            }
        }

    }

    public static int d(int n){
        return (n<<1)%10000;
    }

    public static int s(int n){
        return n-1 ==-1 ? 9999 : n-1;
    }

    public static int l(int n){
        if(n==0)return 0;
        int a = n/1000;
        return (n-a*1000)*10 + a;
    }
    public static int r(int n){
        if(n==0)return 0;

        int a = n%10;
        return n/10+a*1000;
    }
}
