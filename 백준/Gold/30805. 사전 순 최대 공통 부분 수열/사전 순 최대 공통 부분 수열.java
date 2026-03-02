import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int aStart = 0;
        int bStart =0;
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i]==b[j]){
                    l.add(a[i]);
                    break;
                }
            }
        }

        l.sort(Comparator.reverseOrder());
        
        ArrayList<Integer> seq = new ArrayList<>();
        int idx=0;
        while(aStart<n && bStart<m && idx<l.size()){
            int cur = l.get(idx++);
            int aTmp = aStart;
            int bTmp = bStart;

            while(aTmp<n && a[aTmp]!=cur){
                aTmp++;

            }

            while(bTmp<m && b[bTmp]!=cur){
                bTmp++;
            }

            if(aTmp<n && bTmp<m){
                seq.add(cur);
                aStart = aTmp+1;
                bStart = bTmp+1;
            }
        }      

        StringBuilder sb = new StringBuilder();
        sb.append(seq.size()).append("\n");
        for(int i=0; i<seq.size(); i++){
            sb.append(seq.get(i)).append(" ");    
        }
        
        System.out.println(sb);
        
    }


}
