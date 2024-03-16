//https://www.codewars.com/kata/55d277882e139d0b6000005d
public class GrassHopper {
    
    public static int findAverage(int[] nums) {
        int suma = 0;
        for (int i = 0 ; i < nums.length ; i++){
          suma += nums[i];
        }
        return suma/nums.length;
    }
}
