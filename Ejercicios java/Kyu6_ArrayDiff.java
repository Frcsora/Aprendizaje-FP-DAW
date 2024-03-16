//https://www.codewars.com/kata/523f5d21c841566fde000009
import java.util.*;
public class Kata {

  public static int[] arrayDiff(int[] a, int[] b) {
    int[] arrayAux = new int[a.length];
    int cuenta = 0;
    for (int i = 0 ; i < a.length ; i++){
      boolean encontrado = false;
      for(int j = 0 ; j < b.length ; j++){
        if(a[i] == b[j]){
          encontrado = true;
          break;
        }
      }
      if(!encontrado){
        arrayAux[cuenta] = a[i];
        cuenta++;
      }
    }
    int array[]  = new int[cuenta];
    for (int i = 0 ; i < array.length ; i++){
      array[i]=arrayAux[i];
    }
    return array;
  }

}
