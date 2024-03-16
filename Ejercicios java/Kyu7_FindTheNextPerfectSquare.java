//https://www.codewars.com/kata/56269eb78ad2e4ced1000013
public class NumberFun {
  public static long findNextSquare(long sq) {
      if(sq % (long) Math.sqrt(sq) != 0){
        return -1;
      }
      return (long) Math.pow(Math.sqrt(sq) + 1, 2); 
  }
}
