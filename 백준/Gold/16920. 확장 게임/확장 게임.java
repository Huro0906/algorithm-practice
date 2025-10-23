import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int zeroCnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n,m,p;
        int[]range;
        int[][] map;
        int[] cnt;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cnt = new int[p+1];
        
        range = new int[p+1];
        st = new StringTokenizer(br.readLine());
        List<Queue<int[]>> queues = new ArrayList<>();
        for(int i=1; i<=p; i++){
            int r = Integer.parseInt(st.nextToken());
            range[i] = r>n*m ? n*m : r;
            queues.add(new ArrayDeque<>());
        }
        queues.add(new ArrayDeque<>());

        
        for(int i=0; i<n; i++){
            char[]line = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                if(line[j]=='.'){
                    map[i][j] = 0;
                    zeroCnt++;
                }else if(line[j]=='#'){
                    map[i][j] = -1;
                }
                else{
                    int player = line[j]-'0';
                    map[i][j] = player;
                    cnt[player]++;
                    queues.get(player).add(new int[]{player,i,j});
                }
                
            }
        }
        StringBuilder sb = new StringBuilder();
        bfs(map,n,m,p,queues,cnt,range);
        for(int i=1; i<=p; i++){
            sb.append(cnt[i]+" ");
        }
        System.out.println(sb.toString());
        
    }

    public static void bfs(int[][]map, int n,int m,int p, List<Queue<int[]>> queues, int[] cnt, int[] range){
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[n][m];

        boolean hasExpandedGround = true;
        while(hasExpandedGround){
            hasExpandedGround = false;

            for(int i=1; i<=p; i++){
            Queue<int[]> q = queues.get(i);
            int r = range[i];
                for(int j=0; j<r; j++){
                    int qSize = q.size();
                    for(int k=0; k<qSize; k++){
                        int[] cur = q.poll();
                        for(int l=0; l<4; l++){
                            int nr = cur[1]+dr[l];
                            int nc = cur[2]+dc[l];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==0 ){
                                zeroCnt--;
                                map[nr][nc]= i;
                                cnt[i]++;
                                q.add(new int[]{i,nr,nc});
                                hasExpandedGround=true;
                            }
                        }
                    }
                }
            }
            if(!hasExpandedGround)break;
        }
        

    }
}