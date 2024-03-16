//https://www.codewars.com/kata/57faf7275c991027af000679
public class Kata {

  public static String remove(String s, int n){
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0 ; i < n ; i++){
      int ind = sb.indexOf("!");
      if(ind != -1){
        sb.deleteCharAt(ind);
      }
      else{break;}
    }
    s = sb.toString();
    return s;
    
  }
  
}
