//https://www.codewars.com/kata/5a62da60d39ec5d947000093
public class Kata{
  public static int findSquares(int x, int y){
    int res = 0;
    while(x > 0 && y > 0){
      res += x * y;
      x--;
      y--;
    }
    return res;
  }
}
