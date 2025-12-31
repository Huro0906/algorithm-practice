import java.util.*;

class Solution {
    int numberOfDice;
    boolean[] selected;
    int[][] dice;
    int[] selectedIndexs;
    int[] unselectedIndexs;
    List<Integer> selectedSums;
    List<Integer> unselectedSums;
    int max=0;
    int[] maxIndexs;
    
    public int[] solution(int[][] dice) {
        numberOfDice = dice.length;
        selected = new boolean[numberOfDice];
        this.dice = dice;
        
        combine(0, 0);
        
        for(int i=0; i<maxIndexs.length; i++){
            maxIndexs[i]++;
        }
        return maxIndexs;
    }
    
    public void combine(int index, int count){
        if(count == numberOfDice/2){
            selectedIndexs = new int[count];
            unselectedIndexs = new int[count];
            selectedSums = new ArrayList<>();
            unselectedSums = new ArrayList<>();
            int selectedIndex=0;
            int unselectedIndex=0;
            for(int i=0; i<numberOfDice; i++){
                if(selected[i]) selectedIndexs[selectedIndex++] = i;
                else unselectedIndexs[unselectedIndex++] = i;
            }
            
            dfs(0, selectedSums, 0, selectedIndexs);
            dfs(0, unselectedSums, 0, unselectedIndexs);
            
            Collections.sort(selectedSums);
            Collections.sort(unselectedSums);
            int totalWins =0;
            for(int n: selectedSums){
                totalWins+= binarySearch(0, unselectedSums.size(), n, unselectedSums);
                
            }
            if(totalWins>max){
                max = totalWins;
                maxIndexs = selectedIndexs;
            }
            return;
        }
        
        for(int i=index; i<numberOfDice; i++){
            selected[i] = true;
            combine(i+1, count+1);
            selected[i] = false;
        }
    }
    
    public void dfs(int depth, List<Integer> sums, int currentSum, int[] diceIndexs){
        if(depth == numberOfDice/2){
            sums.add(currentSum);
            return;
        }
        
        for(int i=0; i<6; i++){
            dfs(depth+1, sums, currentSum+dice[diceIndexs[depth]][i], diceIndexs);
        }
    }
    
    public int binarySearch(int start, int end, int key, List<Integer> sums){
        if(start>=end)return start;
        
        int mid = (start+end)/2;
        int midV = sums.get(mid);
        
        
        if(midV >= key){
            return binarySearch(start, mid, key, sums);
        }else {
            return binarySearch(mid+1, end, key, sums);
        }
    }
}