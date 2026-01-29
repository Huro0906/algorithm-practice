import java.util.*;
import java.io.*;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t;
        int day;
        //test case
        t = Integer.parseInt(br.readLine());
        long answer=0;
        for(int i=0; i<t; i++){
            answer=0;
            //day
            day = Integer.parseInt(br.readLine());
            //가격 배열
            int[] price = new int[day];
            int max=0;

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<day; j++){
                price[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=day-1; j>=0; j--){
                if(price[j]>max)max=price[j];

                if(max-price[j]>0)answer+=max-price[j];
            }
            System.out.println(answer);
        }

    }
        
    //1. 역순으로 max값 갱신, max값보다 낮은 가격이면 이익 실현. (++)




}