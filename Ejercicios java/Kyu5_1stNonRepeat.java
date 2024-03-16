//https://www.codewars.com/kata/52bc74d4ac05d0945d00054e
import java.util.*;
public class Kata {
  public static String firstNonRepeatingLetter(String s){
    String s2 = s.toLowerCase();
    
    HashMap<Character,Integer> mapa1 = new HashMap<Character,Integer>();
    for(Character c : s2.toCharArray()){
      mapa1.put(c, mapa1.getOrDefault(c, 0) + 1);
    }
    for(int i = 0; i < s.length(); i++){
      if(mapa1.get(s2.charAt(i)) == 1){
        return Character.toString(s.charAt(i));
      }
    }
    return "";
  }
}
