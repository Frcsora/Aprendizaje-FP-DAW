//https://www.codewars.com/kata/54da539698b8a2ad76000228
import java.util.*;
public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    HashMap <Character, Integer> mapa1 = new HashMap<Character,Integer>();
    for(int i = 0 ; i < walk.length ; i++){
      mapa1.put(walk[i], mapa1.getOrDefault(walk[i], 0) + 1);
    }
    return walk.length == 10 && (mapa1.get('n') == mapa1.get('s') && mapa1.get('w') == mapa1.get('e'));
  }
}
