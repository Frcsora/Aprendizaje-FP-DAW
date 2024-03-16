//https://www.codewars.com/kata/556deca17c58da83c00002db
public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {
      double[] array = new double[n];
      for(int i = 0 ; i < s.length && i < array.length ; i++){
        array[i] = s[i];
      }
      if(array.length > s.length){
        for(int i = s.length ; i < array.length ; i++){
          array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }  
      }
      
      return array;
  }
}
