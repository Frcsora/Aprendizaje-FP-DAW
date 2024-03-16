//https://www.codewars.com/kata/59377c53e66267c8f6000027
import java.util.*;
public class Kata{
    public static String alphabetWar(String fight){
        int leftAddition = 0;
        int rightAddition = 0;
        System.out.println(fight);
        Character[] left = {'w', 'p', 'b', 's'};
        Character[] right = {'m', 'q', 'd', 'z'};
        HashMap<Character, Integer> mapa1 = new HashMap<Character, Integer>();
        Integer j = 4;
        for(Character s : left){
          mapa1.put(s, j);
          j--;
        }
        j = 4;
        for(Character s : right){
          mapa1.put(s, j);
          j--;
        }

        for(Character c : fight.toCharArray()){
          for(int i = 0 ; i < left.length ; i++){
            if(c == left[i]){
              leftAddition += mapa1.get(c);
            }
            
          }
          for(int i = 0 ; i < right.length ; i++){
            if(c == right[i]){
              rightAddition += mapa1.get(c);
            }
          }
        }
        
        return leftAddition == rightAddition ? "Let's fight again!" : leftAddition > rightAddition ? "Left side wins!" : "Right side wins!";
    }
}
