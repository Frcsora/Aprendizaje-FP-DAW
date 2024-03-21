//https://www.codewars.com/kata/51dda84f91f5b5608b0004cc/java
public class FizzBuzz{
    public static int[] solution(int number) {
      int number1 = number - 1;
      int number2 = number - 1;
      int number3 = number - 1;
      int a = 0;
      int b = 0;
      int c = 0;
      while (number1 > 1){
        if( number1 % 3 == 0 && number1 % 5 != 0){
          a++;
          
        }
        number1--;
      }
      while (number2 > 1){
        
        if( number2 % 3 != 0 && number2 % 5 == 0){
          b++;
        }
        number2--;
      }
      while (number3 > 1){
        if( number3 % 3 == 0 && number3 % 5 == 0){
          c++;
          
        }
        number3--;
      }
      int[] array = {a,b,c};
      return array;
    }
}
