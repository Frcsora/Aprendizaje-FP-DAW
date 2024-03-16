//https://www.codewars.com/kata/517abf86da9663f1d2000003
import java.lang.StringBuilder;
class Solution{

  static String toCamelCase(String s){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(s.charAt(i) == '-' || s.charAt(i) == '_' ){
                sb.append(Character.toUpperCase(s.charAt(i + 1)));
                i++;
            }
        }
    
    return sb.toString().replaceAll("[-_]", "");
  }
}
