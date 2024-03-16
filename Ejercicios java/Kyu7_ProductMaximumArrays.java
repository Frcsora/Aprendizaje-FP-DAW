//https://www.codewars.com/kata/5a63948acadebff56f000018
import java.util.*;
public class Solution
{
    public static long maxProduct(int[] numbers, int sub_size)
    {
      long producto = 1 ;
        Arrays.sort(numbers);
      for (int i = numbers.length - 1 ; i >= numbers.length - sub_size ; i--){
        producto *= numbers[i];
      }
        return producto;
    }
}
