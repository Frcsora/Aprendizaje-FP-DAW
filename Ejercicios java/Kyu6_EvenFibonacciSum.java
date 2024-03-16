//https://www.codewars.com/kata/55688b4e725f41d1e9000065
import java.math.BigInteger;
class Kata {
    public static long fibonacci(long max) {
       
        BigInteger maxi = BigInteger.valueOf(max);
        BigInteger suma = BigInteger.ZERO;
        BigInteger n1 = BigInteger.ZERO;
        BigInteger n2 = BigInteger.ONE;
        BigInteger n3 = BigInteger.ZERO;
        while(n2.compareTo(maxi) < 0){
           
            if(n2.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
               suma = suma.add(n2);

            }
           n3 = n1.add(n2);
            n1 = n2;
            n2 = n3;
            
        }
      
      return suma.longValue();
      
    }
}
