//https://www.codewars.com/kata/573f5c61e7752709df0005d2
import java.util.*;
public class Kata {
	public static int[] mergeArrays(int[] first, int[] second) {

            HashMap<Integer, Integer> mapa = new HashMap<Integer,Integer>(); 
            for(int n : first){
                mapa.put(n, mapa.getOrDefault(n, 0) + 1);
            }
            for(int n : second){
                mapa.put(n, mapa.getOrDefault(n, 0) + 1);
            }
            int[] third = new int[mapa.size()];
            int j = 0;
            for(Map.Entry<Integer,Integer> entrada : mapa.entrySet()){
                third[j] = entrada.getKey();
                j++;
            }
    Arrays.sort(third);
    return third;
	}
}
