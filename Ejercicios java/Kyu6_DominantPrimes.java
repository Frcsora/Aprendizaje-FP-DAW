//https://www.codewars.com/kata/59ce11ea9f0cbc8a390000ed
class Solution{
    public static int solve(int a, int b){
        int suma = 0;
        int count = 1;
        for(int i = 3; i <= b ; i++){
            
            if(esPrimo(i)){
                count++;
                if(i >= a){
                    if( esPrimo(count)){
                        suma += i;
                        
                    }
                }
            }
            
            
        }
      return suma;
    }
    static boolean esPrimo(int i){
        boolean esprimo = true;
        for(int j = 2 ; j <= (int) Math.sqrt(i) && esprimo ; j++){
                if(i % j == 0){
                    esprimo = false;
                }
            }
        return esprimo;
    }
}
