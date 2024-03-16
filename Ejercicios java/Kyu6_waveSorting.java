//https://www.codewars.com/kata/596f28fd9be8ebe6ec0000c1
public class WaveSorter {

    public static void waveSort(int[] array) {
        boolean order = false;
        while(!order){
          order = true;
          for(int i = 0 ; i < array.length - 1 ; i++){
            if(i % 2 == 0){
              if(array[i] < array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
              }
            }
            if(i % 2 != 0){
              if(array[i] > array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
              }
            }
          }
        }
    }
}
