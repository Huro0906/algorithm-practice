import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        Deque<int[]> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int limit = i-l+1<0 ? 1 : i-l+1;
            while(!d.isEmpty() && d.peekFirst()[0]<limit){
                d.pollFirst();
            }
            while(!d.isEmpty() && d.peekLast()[1]>=tmp){
                d.pollLast();
            }
            d.add(new int[]{i,tmp});
            sb.append(d.peekFirst()[1]).append(" ");
        }
        System.out.println(sb.toString());
    }
}