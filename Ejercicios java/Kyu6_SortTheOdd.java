//https://www.codewars.com/kata/578aa45ee9fd15ff4600090d

public class Kata {
  public static int[] sortArray(int[] array) {
    boolean ordenado = false;
    while(!ordenado){
      ordenado = true;
      for(int i = 0; i < array.length - 1 ; i++){
        if(array[i] % 2 == 0){
          continue;
        }
        for(int j = i + 1 ; j < array.length ; j++){
          if(array[j] % 2 == 0){
            continue;
          }
          if(array[j] < array[i]){
            int a = array[i];
            array[i] = array[j];
            array[j] = a;
            ordenado = false;
            break;
          }
        }
      }
    }
    return array;
  }
}
