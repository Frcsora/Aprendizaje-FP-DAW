//https://www.codewars.com/kata/54b724efac3d5402db00065e
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
      String s = "";
      String[] morses = morseCode.split("\s");
      for(int i = 0 ; i < morses.length ; i++){
        System.out.println(morses[i]);
        if(morses[i].equals("")){
          s+= " ";
        } else{
          s += MorseCode.get(morses[i]);
        }
        
      }
      return s.replaceAll("( )+"," ").replaceAll("^\s", "");
    }
}
