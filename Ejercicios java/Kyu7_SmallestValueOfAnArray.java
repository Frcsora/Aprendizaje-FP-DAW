//https://www.codewars.com/kata/544a54fd18b8e06d240005c0
public class Arrays {

  public static int findSmallest( final int[] numbers, final String toReturn ) {
    int menor = Integer.MAX_VALUE;
    int i = 0;
    int indiceMenor = -1;
    for(; i < numbers.length - 1; i++){
      if(numbers[i] < menor){
        menor = numbers[i];
        indiceMenor = i;
      }
    }
    
    if(toReturn.equals("value")){
      return menor;
    }

    return indiceMenor;
    
	}
}
