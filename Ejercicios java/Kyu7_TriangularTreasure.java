//https://www.codewars.com/kata/525e5a1cb735154b320002c8
public class Triangular {
    public static long triangular(long n) {
        if(n <= 0){
          return 0;
        }
        long suma = 0;
        for(int i = 1 ; i <= n ; i++){
          suma += i;
        }
        return suma;
    }
}
