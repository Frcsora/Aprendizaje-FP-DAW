//https://www.codewars.com/kata/59c5f4e9d751df43cf000035
import java.util.regex.*;
  class Solution{
    public static int solve(String s){
   
        String[] ar = s.split("[^aeiou]");
        int ind = 0;
        for(int i = 0; i < ar.length ; i++){
            if(ar[i].length() > ind){
                ind = ar[i].length();
            }
        }
      return ind;
  }
}
