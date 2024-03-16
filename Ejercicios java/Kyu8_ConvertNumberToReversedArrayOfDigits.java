//https://www.codewars.com/kata/5583090cbe83f4fd8c000051
public class Kata {
  public static int[] digitize(long n) {
    String longitud = Long.toString(n);
    int array1[] = new int[longitud.length()];
    if ( n == 0 ){ 
      array1[0] = 0;
      return array1;
    }
    for(int i = 0 ; i < array1.length ; i++){
      array1[i] = (int) (n % 10);
      n = n / 10;
    }
    
    return array1;
  }
}
