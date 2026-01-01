import java.util.*;

class Solution {
    Set<Integer> hands;
    Set<Integer> deck;
    int idx = 0;
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        hands = new HashSet<>();
        deck = new HashSet<>();
        
        for(int i=0; i<n/3; i++){
            hands.add(cards[idx++]);
        }
        int turn=1;
        
        while(idx<n){
            boolean hasPassed=false;
            
            for(int i=0; i<2; i++)deck.add(cards[idx++]);
            
            for(int number: hands){
                if(hands.contains(n+1-number)){
                    hands.remove(number);
                    hands.remove(n+1-number);
                    hasPassed = true;
                    break;
                }
            }
            
            if(!hasPassed && coin>=1){
                for(int number: deck){
                    if(hands.contains(n+1-number)){
                        deck.remove(number);
                        hands.remove(n+1-number);
                        hasPassed = true;
                        coin--;
                        break;
                    }
                }
            }
            
            if(!hasPassed && coin>=2){
                for(int number: deck){
                    if(deck.contains(n+1-number)){
                        deck.remove(number);
                        deck.remove(n+1-number);
                        hasPassed = true;
                        coin-=2;
                        break;
                    }
                }
            }
            
            if(!hasPassed)break;
            turn++;
        }
        
        return turn;
    }
    

}