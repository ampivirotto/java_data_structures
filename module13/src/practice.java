import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice {
    public static boolean isPermuation(String a, String b){
        Map<Character, Integer> aCount = new HashMap<>();
        Map<Character, Integer> bCount = new HashMap<>();
        for(char letter : a.toCharArray()) {
            if (aCount.containsKey(letter) ){
                int let = (int) aCount.get(letter);
                aCount.put(letter, let + 1);
            }else {
                aCount.put(letter, 1);
            }//end if else
        }// for A
        for(char letter : b.toCharArray()) {
            if (bCount.containsKey(letter) ){
                int let = (int) bCount.get(letter);
                bCount.put(letter, let+1);
            } else {
                bCount.put(letter, 1);
            }// end if else
        }// end for B
        for(char letter : aCount.keySet()) {
            if(aCount.get(letter) != bCount.get(letter)){
                return false; }
        } // end for
        if(!aCount.keySet().equals(bCount.keySet())) { return false; }
        return true;
    }// end method

    public static void main(String[] args) {
        System.out.println(isPermuation("flow", "wolf"));
    }
}
