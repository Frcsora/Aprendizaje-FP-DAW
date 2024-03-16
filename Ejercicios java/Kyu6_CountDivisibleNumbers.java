//https://www.codewars.com/kata/55a5c82cd8e9baa49000004c
public class Kata {

  public static long divisibleCount(long x, long y, long k) {
    long count = 0;
    if (x % k != 0) {
            x += k - (x % k);
        }
        if (x <= y) {
            count = (y - x) / k + 1;
        }
    return count;
  }  
}
