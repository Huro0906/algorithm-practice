import java.util.function.Function;

class Solution {
    
    
    //0000~9999 한번씩 실행 -> 4개의 숫자 파악
    // 4개의 숫자 배치 경우의수 4*3*2*1 =24 
    //총 b=33으로 
    public int solution(int n, Function<Integer, String> submit) {
        for(int i = 1111; i <= 9999; i+=1111){
            if (submit.apply(i).equals("4S 0B")) return i;
        }
        return 0;
    }
    
    public int a()
    
    
    
    
    
    
}