//https://www.codewars.com/kata/5a34af40e1ce0eb1f5000036
public class Kata {
  public static String toCsvText(int[][] array){
    String s = "";
    for(int i = 0 ; i < array.length ; i++){
      for(int j = 0 ; j < array[i].length ; j++){
        if(j != array[i].length - 1){
          s += "" + array[i][j] + ",";
        }else{
          s += "" + array[i][j];
        }
      }
      if(i != array.length - 1){
          s += "\n";
        }else{
          s += "";
        }
    }
    return s;
  }
}
