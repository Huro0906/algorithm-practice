import java.util.function.Function;
import java.util.*;

class Solution {
    
    List<String> all;
    List<String> possible;
    
    public static class Score{
        int s;
        int b;
        
        public Score(int s, int b){
            this.s = s;
            this.b = b;
        }
        
        public boolean isAnswer(){
            return s==4;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o)return true;
            if(this.getClass()!=o.getClass())return false;
            Score score = (Score) o;
            return score.s == this.s && score.b == this.b;
        }
    }
    
    public List<String> init(){
        List<String> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(i==j)continue;
                for(int k=1; k<=9; k++){
                    if(i==k || j==k)continue;
                    for(int l=1; l<=9; l++){
                        if(l==i || l==j || l==k)continue;
                        list.add(String.format("%d%d%d%d",i,j,k,l));
                    }
                }
            }
        }
        return list;
    }
    
    public Score getScore(String answer, String guess){
        int s =0;
        int b = 0;
        for(int i=0; i<4; i++){
            if(answer.charAt(i) == guess.charAt(i))s++;
            else if(answer.indexOf(guess.charAt(i))!=-1)b++;
        }
        return new Score(s,b);
    }
    
    public int solution(int n, Function<Integer, String> submit) {
        String score;
        score = submit.apply(1234);
        Score s = new Score(score.charAt(0)-'0', score.charAt(3)-'0');
        possible = init();
        
        filter("1234",s);
        String guess;
        while(possible.size()!=1){
            guess = findBest();
            score = submit.apply(Integer.parseInt(guess));
            s = new Score(score.charAt(0)-'0', score.charAt(3)-'0');
            filter(guess, s);
        }
        return Integer.parseInt(possible.get(0));
    }
    
    public String findBest(){
        String best = "";
        int bestCnt = 1000000;
        for(String guess : possible){
            int curWorst = 0;
            int[][] counts = new int[5][5];
            for(String answer: possible){
                Score out = getScore(answer,guess);
                counts[out.s][out.b]++;
            }
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(curWorst<counts[i][j])
                        curWorst = counts[i][j];
                }
            }
            
            if(bestCnt>curWorst){
                best = guess;
                bestCnt = curWorst;
            }
        }
        
        return best;
        
    }
    
    public void filter(String guess, Score s){
        possible.removeIf(n ->{
            Score s2 = getScore(n, guess);
            return !s2.equals(s);
        });
    }
    
}