import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int t;
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++){
            t = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer>map = new TreeMap<>();

            for(int j=0; j<t; j++){
                st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0);
                String second = st.nextToken();

                switch(command){
                    case 'I':
                        int in = Integer.parseInt(second);
                        map.put(in, map.getOrDefault(in,0)+1);

                        break;

                    case 'D':
                        int k=0;
                        if(map.isEmpty())continue;
                        if(second.equals("1")){
                            k = map.lastKey();
                        }
                        else if(second.equals("-1")){
                            k = map.firstKey();
                        }
                        if(map.get(k)==1){
                            map.remove(k);
                        }
                        else{
                            map.put(k,map.get(k)-1);
                        }
                        break;
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }
        }

    }


}