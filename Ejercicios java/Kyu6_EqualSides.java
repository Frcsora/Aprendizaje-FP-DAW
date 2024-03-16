//https://www.codewars.com/kata/5679aa472b8f57fb8c000047
public class Kata {
  public static int findEvenIndex(int[] arr) {
    for(int i = 0 ; i < arr.length ; i++){
      int right = 0;
      int left= 0;
      for(int j = i - 1 ; j >= 0; j--){
        right += arr[j];
      }
      for(int j = i + 1 ; j < arr.length ; j++){
        left += arr[j];
      }
      if(right == left){
        return i;
      }
      
    }
    return -1;
  }
}
