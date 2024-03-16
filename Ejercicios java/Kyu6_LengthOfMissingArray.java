//https://www.codewars.com/kata/57b6f5aadb5b3d0ae3000611
import java.util.Arrays;
public class Kata
{
  public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
  {
        if(arrayOfArrays == null){
          return 0;
        }
        for(int i = 0; i < arrayOfArrays.length ; i++){
            if(arrayOfArrays[i] == null || arrayOfArrays.length == 0 || arrayOfArrays[i].length == 0){
                return 0;
            }
        }
        int[] lengthArray = new int[arrayOfArrays.length];
        for(int i = 0 ; i < lengthArray.length ; i++){
            lengthArray[i] = arrayOfArrays[i].length;
        }
        int missing = 0;
        Arrays.sort(lengthArray);
        for(int i = 0 ; i < lengthArray.length - 1 ; i++){
            
            if(lengthArray[i] + 1 != lengthArray[i + 1]){
                missing =lengthArray[i] + 1;
                break;
            }
        }
    
    return missing;
  }
}
