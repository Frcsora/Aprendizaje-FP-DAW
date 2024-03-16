//https://www.codewars.com/kata/55c04b4cc56a697bb0000048
import java.util.HashMap;
import java.util.Map;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {    
        HashMap <Character, Integer> hm1 = new HashMap<Character,Integer>();
        HashMap <Character, Integer> hm2 = new HashMap<Character,Integer>();
        for(char c : str1.toCharArray()){
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }
        for(char c : str2.toCharArray()){
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entrada : hm2.entrySet()){
            if(!hm1.containsKey((entrada.getKey())) || hm1.get(entrada.getKey()) < entrada.getValue()){
                return false;
            }
        }
        return true;
    }
}
