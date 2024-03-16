//https://www.codewars.com/kata/51b62bf6a9c58071c600001b
import java.util.*;
public class Conversion {

    public String solution(int n) {
 
      StringBuilder sb = new StringBuilder();
      HashMap<Integer, String> mapFromRoman = new HashMap<Integer,String>();
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
}
