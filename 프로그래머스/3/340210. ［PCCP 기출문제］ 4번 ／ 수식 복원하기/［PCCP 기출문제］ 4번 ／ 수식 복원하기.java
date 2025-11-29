import java.util.*;

class Solution {
    boolean[] validBase = new boolean[10];
    List<String[]> equations;
    public String[] solution(String[] expressions) {
        Arrays.fill(validBase, true);
        equations = new ArrayList<>();
        
        for(String s: expressions){
            String[] tokens = s.split(" ");
            
            if(tokens[4].equals("X")){
                for(int i=2; i<=9; i++){
                    if(!isValidDigit(tokens[0],i) || !isValidDigit(tokens[0],i))validBase[i] = false;
                }
                equations.add(tokens);
            }
            else{
                filterBase(tokens);
            }
                
        }
        
        String[] answer = new String[equations.size()];
        
        int idx=0;
        for(String[] tokens : equations){
            answer[idx++] = solveExpression(tokens);
        }
        
        return answer;
    }
    
    //진법 판별
    public void filterBase(String[] tokens){
        for(int i=2; i<=9; i++){
            if(!validBase[i])continue;
            
            if(!isValidDigit(tokens[0], i)
              || !isValidDigit(tokens[2], i)
              || !isValidDigit(tokens[4], i)){
                validBase[i] = false;
                continue;
            }
            
            int a = Integer.parseInt(tokens[0], i);
            int b = Integer.parseInt(tokens[2], i);
            int answer = Integer.parseInt(tokens[4],i);
            String oper = tokens[1];
            int calc = oper.equals("+")? a+b : a-b;
            validBase[i] = calc == answer;
        }
    }
    
    // 방정식 풀이 함수
    public String solveExpression(String[] tokens){
        String result = null;
        
        for(int base =2; base<=9; base++){
            if(!validBase[base])continue;
            if(!isValidDigit(tokens[0],base)
              || !isValidDigit(tokens[2],base))continue;
            int a = Integer.parseInt(tokens[0],base);
            int b = Integer.parseInt(tokens[2],base);
            String oper = tokens[1];
            
            String calc = Integer.toString(oper.equals("+")? a+b : a-b, base);
            
            if(result == null){
                result =calc;
            }
            else if(!result.equals(calc)){
                result = "?";
                break;
            }
        }
        
        return String.join(" ",tokens).replace("X",result);
    }
    
    //올바른 진법 숫자인가
    public boolean isValidDigit(String n, int base){
        for(int i=0; i<n.length(); i++){
            if((int)(n.charAt(i))-'0'>=base)return false;
        }
        return true;
    }
    
    
}