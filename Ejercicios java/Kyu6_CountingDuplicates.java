//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CountingDuplicates {
  public static int duplicateCount(String text) {
    int mayor = 0;
        for(int i = 0 ; text.length() > 0 && mayor < 26; ){
            int count = 0;
            
            String patron = "[" + Character.toString(text.charAt(i)) + Character.toString(text.charAt(i)).toUpperCase() + "]";
            Pattern p = Pattern.compile(patron);
            Matcher m = p.matcher(text);
            while(m.find()){
                count++;
            }
            text = text.replaceAll(Character.toString(text.charAt(i)), "");
            if(count > 1){
              mayor++;
            }
            
        }
    return mayor;
  }
}
