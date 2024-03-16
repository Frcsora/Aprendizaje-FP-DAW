//https://www.codewars.com/kata/5a946d9fba1bb5135100007c
import java.util.ArrayList;
public class Solution
{
    public static int minimumNumber(int[] numbers)
    {
        int suma = 0;
        for(int i = 0 ; i < numbers.length ; i++){
          suma += numbers[i];
        }
        int contadorprimos = 0;
        for(int i = suma ; contadorprimos < 1 ; i++){
          boolean esPrimo = true;
          for(int j = i - 1 ; j >= 2 ; j--){
            if(i % j == 0){
              esPrimo = false;
              break;
            }
          }
          if(esPrimo){
            suma = i - suma;
            contadorprimos++;
          }
        }
        return suma; // Do your magic!
    }
}
