//https://www.codewars.com/kata/5a86073fb17101e453000258
import java.util.*;
public class Solution {

    public static String[] sortEmotions(boolean order,String[] emotions) {
        String[] array = {":D", ":)", ":|", ":(", "T_T"};
        HashMap<String, Integer> mapa1 = new HashMap<String,Integer>();
      Integer i = 1;
      for(String s: array){
        mapa1.put(s, i);
        i++;
      }
      boolean ordered = false;
      while(!ordered){
        ordered = true;
        for(int j = 0 ; j < emotions.length - 1; j++){
          if(mapa1.get(emotions[j + 1]) < mapa1.get(emotions[j])){
            String temp = emotions[j + 1];
            emotions[j + 1] = emotions[j];
            emotions[j] = temp;
            ordered = false;
          }
        }
      }
      if(!order){
        String[] ascendingOrder = new String[emotions.length];
        for(int j = emotions.length - 1 ; j >= 0; j--){
          ascendingOrder[emotions.length - 1 - j] = emotions[j];
        }
        emotions = ascendingOrder;
      }
      for(int j = 0 ; j < emotions.length ; j++){
        System.out.println(emotions[j]);
      }
      
        return emotions;
    }

}
