import java.util.*;

public class RomanNumerals {
 
  public static String toRoman(int n) {
     HashMap<Integer, String> mapFromRoman = new HashMap<Integer,String>();
           StringBuilder sb = new StringBuilder();
           mapFromRoman.put(1000, "M");
           mapFromRoman.put(900,"CM");
           mapFromRoman.put(500,"D");
           mapFromRoman.put(400, "CD");
           mapFromRoman.put(100,"C");
           mapFromRoman.put(90, "XC");
           mapFromRoman.put(50,"L");
           mapFromRoman.put(40,"XL");
           mapFromRoman.put(10,"X");
           mapFromRoman.put(9,"IX");
           mapFromRoman.put(5,"V");
           mapFromRoman.put(4,"IV");
           mapFromRoman.put(1,"I");
           while(n - 1000 >= 0){
               n -= 1000;
               sb.append(mapFromRoman.get(1000));
           }
           while(n - 900 >= 0){
               n -= 900;
               sb.append(mapFromRoman.get(900));
           }
           while(n - 500 >= 0){
               n -= 500;
               sb.append(mapFromRoman.get(500));
           }
           while(n - 400 >= 0){
               n -= 400;
               sb.append(mapFromRoman.get(400));
           }
           while(n - 100 >= 0){
               n -= 100;
               sb.append(mapFromRoman.get(100));
           }
           while(n - 90 >= 0){
               n -= 90;
               sb.append(mapFromRoman.get(90));
           }
           while(n - 50 >= 0){
               n -= 50;
               sb.append(mapFromRoman.get(50));
           }
           while(n - 40 >= 0){
               n -= 40;
               sb.append(mapFromRoman.get(40));
           }
           while(n - 10 >= 0){
               n -= 10;
               sb.append(mapFromRoman.get(10));
           }
           while(n - 9 >= 0){
               n -= 9;
               sb.append(mapFromRoman.get(9));
           }
           while(n - 5 >= 0){
               n -= 5;
               sb.append(mapFromRoman.get(5));
           }
           while(n - 4 >= 0){
               n -= 4;
               sb.append(mapFromRoman.get(4));
           }
           while(n - 1 >= 0){
               n -= 1;
               sb.append(mapFromRoman.get(1));
           }
           String romanNumber = sb.toString();
    return romanNumber;
  }
  
  public static int fromRoman(String romanNumeral) {
    int numeral = 0;
           HashMap<Character, Integer> mapToRoman = new HashMap<Character,Integer>();
           mapToRoman.put('M' , 1000);
           mapToRoman.put('D', 500);
           mapToRoman.put('C', 100);
           mapToRoman.put('L', 50);
           mapToRoman.put('X', 10);
           mapToRoman.put('V', 5);
           mapToRoman.put('I', 1);
           for(int i = 0 ; i < romanNumeral.length() ; i++){
                if(i == romanNumeral.length() - 1 ){
                   numeral += mapToRoman.get(romanNumeral.charAt(i));
                } else if(mapToRoman.get(romanNumeral.charAt(i)) < mapToRoman.get(romanNumeral.charAt(i + 1))){
                   numeral -= mapToRoman.get(romanNumeral.charAt(i));
                } else{
                   numeral += mapToRoman.get(romanNumeral.charAt(i));
                }
           }
    return numeral;
  }
}
