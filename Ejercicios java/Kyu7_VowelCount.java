//https://www.codewars.com/kata/54ff3102c1bad923760001f3
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Vowels {

  public static int getCount(String str) {
    String patron = "[aeiouAEIOU]";
        
        Pattern p = Pattern.compile(patron);
        
        Matcher m = p.matcher(str);
        
        int count = 0;
        while(m.find()){
            count++;
        }
        return count;
  }

}
