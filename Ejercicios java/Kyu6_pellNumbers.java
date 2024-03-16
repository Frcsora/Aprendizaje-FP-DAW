//https://www.codewars.com/kata/5818d00a559ff57a2f000082
import java.math.BigInteger;

public class Solution {
  public static BigInteger pell(int n) {
    
    BigInteger n1 = BigInteger.ZERO;
    BigInteger n2 = BigInteger.ONE;
    BigInteger n3 = BigInteger.ZERO;
    BigInteger factor = BigInteger.TWO;
    if(n == 0){
      return n1;
    } else if(n == 1){
      return n2;
    }
    for(int i = 1 ; i < n ; i++){
      n3 = factor.multiply(n2).add(n1);
      n1 = n2;
      n2 = n3;
    }
    return n3;
  }
}
