//https://www.codewars.com/kata/6368426ec94f16a1e7e137fc
import java.util.regex.*;
import java.util.ArrayList;
public class Hallway {
  public static int contact(String hallway) {
        Pattern p1 = Pattern.compile(">-*<");
        Matcher m1 = p1.matcher(hallway);
        int menor = Integer.MAX_VALUE;
        while(m1.find()){
            int diferencia = 0;
            int pos1 = m1.start();
            int pos2 = m1.end() - 1;
            while(pos2 > pos1){
                pos1++;
                pos2--;
                diferencia++;
            }

            if(diferencia < menor){
                menor = diferencia;
            }
        }
        if(menor == Integer.MAX_VALUE){
          return -1;
        }
        return menor;
  }
}
