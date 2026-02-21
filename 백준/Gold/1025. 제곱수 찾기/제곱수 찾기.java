import java.util.*;
import java.io.*;

public class Main {

    public static int n,m;
    static int[][] map;
    static int max = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ;j<m; j++){
                map[i][j] = arr[j]-'0';
            }
        }

        for(int startR=0; startR<n; startR++){
            for(int startC=0; startC<m; startC++){
                for(int difR=-n; difR<n; difR++){
                    for(int difC=-m; difC<m; difC++){
                        combine(startR,startC,difR,difC, new LinkedList<>());
                    }
                }
            }
        }

        System.out.println(max);
        
    }

    public static void combine(int r, int c, int difR, int difC, Queue<Integer> q){
        if(difC==0 && difR==0)return;
        if(r>=n || c>=m || r<0 || c<0){
            int cur=0;
            while(!q.isEmpty()){
                cur*=10;
                cur+=q.poll();
                isSquareNum(cur);

            }
            return;
        }

        q.add(map[r][c]);
        combine(r+difR,c+difC,difR,difC,q);
        
    }

    public static void isSquareNum(int n){
        int r = (int)Math.sqrt(n);
        if (r*r == n){
            if(n>max)max=n;
        }
    }
}
