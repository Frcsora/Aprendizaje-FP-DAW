//https://www.codewars.com/kata/5417423f9e2e6c2f040002ae
import java.util.Arrays;
public class Solution{
  public static int[] digitize(int n){
    String longitud = Integer.toString(n);
    int array[] = new int[longitud.length()];
    for (int i = array.length - 1 ; i >=0 ; i--){
      array[i] = n % 10;
      n = n / 10;
    }
    return array;
  }
}
