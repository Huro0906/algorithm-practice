
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
            Arrays.fill(min[i],Integer.MAX_VALUE);
        }
        min[0][0] = map[0][0];
        min[0][1] = map[0][1];
        min[0][2] = map[0][2];
        max[0][0] = map[0][0];
        max[0][1] = map[0][1];
        max[0][2] = map[0][2];

        for(int i=0; i<n-1; i++){
            for(int j=0; j<3; j++){
                if(j>0){
                    min[i+1][j-1] = Math.min(min[i+1][j-1], map[i+1][j-1]+min[i][j]);
                    max[i+1][j-1] = Math.max(max[i+1][j-1],map[i+1][j-1]+max[i][j]);
                }
                min[i+1][j] = Math.min(min[i+1][j], map[i+1][j]+min[i][j]);
                max[i+1][j] = Math.max(max[i+1][j],map[i+1][j]+max[i][j]);

                if(j<2) {
                    min[i + 1][j + 1] = Math.min(min[i + 1][j + 1], map[i + 1][j + 1] + min[i][j]);
                    max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], map[i + 1][j + 1] + max[i][j]);
                }
            }
        }

        int maxV = Arrays.stream(max[n-1]).max().getAsInt();
        int minV = Arrays.stream(min[n-1]).min().getAsInt();
        System.out.println(maxV+" "+minV);

    }

}