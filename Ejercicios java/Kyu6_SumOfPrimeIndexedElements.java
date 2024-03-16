//https://www.codewars.com/kata/59f38b033640ce9fc700015b
class Solution{
    public static int solve(int [] arr){  
      int suma = 0;  
      for(int i = 0; i < arr.length ; i++){
        if(i > 1 && isPrime(i)){
          suma += arr[i];
        }
      }
      return suma;
    }    
    static boolean isPrime(int n){
      for(int i = 2 ; i <= Math.sqrt(n) ; i++){
        if(n % i == 0){
          return false;
        }
      }
      return true;
    }
}
