//https://www.codewars.com/kata/5226eb40316b56c8d500030f
public class PascalsTriangle {
    public static long[] generate(int level) {
        int l = level;
        long array[] = new long[sumatorio(l)];
        int index = 0;
        for(int i = 0 ; i < l ; i++){
            for (int j = 0 ; j <= i ; j++){
                array[index++] = triangle(i,j);
                
            }
        }
      return array;
    }
      static int sumatorio(int n){
        for(long i = n - 1; i >= 1 ; i--){
            n += i;
        }
        return n ;
    }
    
    static long triangle(int n, int n2) {
        long resultado = 1;
        for (int i = 1; i <= n2; i++) {
            resultado = resultado * (n - i + 1) / i;
        }
        return resultado;
    }
}
