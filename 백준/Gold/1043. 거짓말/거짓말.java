import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        
        int numT = Integer.parseInt(st.nextToken());
        int[] trueP = new int[numT];
        for(int i=0; i<numT; i++){
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>>parties = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int partyN = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int first = Integer.parseInt(st.nextToken());
            party.add(first);

            for(int j=1; j<partyN; j++){
                int next = Integer.parseInt(st.nextToken());
                party.add(next);
                union(first,next);
            }
            parties.add(party);
        }
        
        int cnt=0;

        for(List<Integer> party : parties){
            boolean can = true;
            for(int person : party){
                for(int truePerson : trueP){
                    if(find(truePerson) == find(person)){
                        can =false;
                        break;
                    }
                }
                if(!can)break;
            }
            if(can)cnt++;
        }
        System.out.println(cnt);
    }
}
