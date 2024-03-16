//https://www.codewars.com/kata/52efefcbcdf57161d4000091
import java.util.*;

public class Kata {
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> mapa1 = new HashMap<Character,Integer>();
        for(Character c : str.toCharArray()){
          mapa1.put(c, mapa1.getOrDefault(c, 0) + 1);
        }
        return mapa1;
    }
}
