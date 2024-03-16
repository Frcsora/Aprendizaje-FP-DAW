//https://www.codewars.com/kata/59752e1f064d1261cb0000ec
import java.util.*;
public class Dinglemouse {

  public static String whatTimeIsIt(final double angle) {    
    int hora = (int) (angle / 30);
    int minuto = (int) ((angle - (30 * hora)) * 2);
    String horaFinal = hora < 10 ? "0" + hora : Integer.toString(hora);
    if(horaFinal.equals("00")){
      horaFinal = "12";
    }
    String minutoFinal = minuto < 10 ? "0" + minuto : Integer.toString(minuto);
    return horaFinal + ":" + minutoFinal;
  }

}
