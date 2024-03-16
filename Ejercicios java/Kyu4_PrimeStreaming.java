//https://www.codewars.com/kata/5519a584a73e70fa570005f5
import java.util.stream.IntStream;


public class Primes {
  public static IntStream stream() {
    return IntStream.iterate(2, i -> siguientePrimo(i));
  }
  static int siguientePrimo(int n){
    do{
      n++;
    } while(!esPrimo(n));
    return n;
  }
  static boolean esPrimo(int n){
    for(int i = 2 ; i <= (int)(Math.sqrt(n)); i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }
}
