//https://www.codewars.com/kata/56541980fa08ab47a0000040
public class Printer {
    
    public static String printerError(String s) {
      int count = 0;
      for (int i = 0; i < s.length() ; i++){
            if(Character.toString(s.charAt(i)).matches("^[n-z]$")){
                count++;
            }
        }
      return count + "/" + s.length();
    }
}
