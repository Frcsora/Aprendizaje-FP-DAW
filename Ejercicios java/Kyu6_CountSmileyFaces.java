//https://www.codewars.com/kata/583203e6eb35d7980400002a
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SmileFaces {
  
  public static int countSmileys(List<String> arr) {
      String patron = "^[:;][-~]?[\\)D]$";
      int count= 0;
      Pattern p = Pattern.compile(patron);
      for(int i = 0 ; i < arr.size() ; i++){
        Matcher m = p.matcher(arr.get(i));
        while(m.find()){
          count++;
        }
      }
      return count;
  }
}
