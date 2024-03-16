//https://www.codewars.com/kata/566091b73e119a073100003a
import java.util.Map;

public class EightiesKids1 {

  public static String totalLicks(Map<String, Integer> env) {
    int licks = 252;
    int mayor = Integer.MIN_VALUE;
    String max = "";
    for(Map.Entry<String,Integer> entrada: env.entrySet()){
      if(entrada.getValue() > mayor){
        mayor = entrada.getValue();
        max = entrada.getKey();
      }
      licks += entrada.getValue();
    }
    
    return mayor > 0 ? "It took " + licks + " licks to get to the tootsie roll center of a tootsie pop. The toughest challenge was " + max + "."
      : "It took " + licks + " licks to get to the tootsie roll center of a tootsie pop.";
  }
}
