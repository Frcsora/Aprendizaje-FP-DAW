//https://www.codewars.com/kata/5862fb364f7ab46270000078
public class BasicEncrypt {

    public String encrypt(String text, int rule) {
        String s = "";
        while(rule > 255){
            rule -= 256;
          }
        for(int i = 0 ; i < text.length() ; i++){
          int n = (int) text.charAt(i);
          n += rule;
          if(n > 255){
            n -= 256;
          }
          s += Character.toString((char) n);
        }
      return s;
    }
}
