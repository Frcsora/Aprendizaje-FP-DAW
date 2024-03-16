//https://www.codewars.com/kata/5a905c2157c562994900009d
public class Solution
{
    public static long[] productArray(int[] numbers)
    {
        long[] array = new long[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
          long product = 1;
          for (int j = 0 ; j < array.length ; j++){
            if(i == j){
              continue;
            }else{
              product *= numbers[j];
            }
          }
          array[i] = product;
        }
        return array; // Do your magic!
    }
}
