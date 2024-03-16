//https://www.codewars.com/kata/5865918c6b569962950002a1
public class CodeWars {
  public static int strCount(String str, char letter) {
    int count = 0;
    for(int i = 0 ; i < str.length() ; i++){
      if(str.charAt(i) == letter){
        count++;
      }
    }
    return count;
  }
}
