//https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08
public class Multiplication{
  public static int [][] multiplicationTable(int n){
    int[][] array = new int[n][n];
    for(int i = 0 ; i < array.length ; i++){
      for (int j = 0 ; j < array[i].length ; j++){
        array[i][j] = (i + 1) * (j + 1);
      }
    }
    return array;
  }
}
