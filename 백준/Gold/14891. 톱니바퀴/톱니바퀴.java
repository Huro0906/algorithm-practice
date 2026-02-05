
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] wheel = new int[5][8];
    static int[] point = new int[5];
    public static void main(String[] args)throws Exception{
        for(int i=1; i<=4; i++){
            String nr = br.readLine();
            for(int j=0; j<8; j++){
                wheel[i][j] = (int)(nr.charAt(j)-'0');
            }
        }
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rotated = Integer.parseInt(st.nextToken());
            int dir =  Integer.parseInt(st.nextToken());

            dir *=-1;

            int right = wheel[rotated][(point[rotated]+2+8)%8];
            int left = wheel[rotated][(point[rotated]-2+8)%8];
            rotate(left, rotated-1, true, dir);
            rotate(right, rotated+1, false, dir);
            //12시 포인터 이동
            point[rotated] = (point[rotated]+dir+8)%8;
        }
        int score=0;
        for(int i=1; i<=4; i++){
            if(wheel[i][point[i]]==1)score+=Math.pow(2,i-1);
        }
        System.out.println(score);
    }

    //옆 ns값, 회전시킬 index, 회전시킬 휠이 왼쪽에 있는지
    public static void rotate(int ns, int rotated, boolean isLeft,int dir){
        if(rotated<1 || rotated >4)return;
        int left = wheel[rotated][(point[rotated]-2+8)%8];
        int right = wheel[rotated][(point[rotated]+2+8)%8];
        if(isLeft){
            if(ns!=right){
                rotate(left, rotated-1, true, -dir);
                point[rotated] = (point[rotated]-dir+8)%8;
            }

        }
        else{
            if(ns!=left){
                rotate(right, rotated+1, false, -dir);
                point[rotated] = (point[rotated]-dir+8)%8;
            }
        }
    }
}