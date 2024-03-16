//https://www.codewars.com/kata/576b93db1129fcf2200001e6
public class Kata
{
  public static int sum(int[] numbers)
  {
   
    if(numbers == null || numbers.length < 3){
      return 0;
    }
    int mayor = numbers[0];
    int menor = numbers[0];
    int suma = numbers[0];
    for(int i = 1 ; i < numbers.length;i++){
      mayor = Math.max(mayor, numbers[i]);
      menor = Math.min(menor, numbers[i]);
      suma += numbers[i];
    }

    suma -= mayor;
    suma -= menor;
    
    return suma;
  }
}
