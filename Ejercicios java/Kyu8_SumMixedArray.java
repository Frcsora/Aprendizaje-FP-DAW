//https://www.codewars.com/kata/57eaeb9578748ff92a000009
import java.util.List;

public class MixedSum {

 /*
  * Assume input will be only of Integer o String type
  */
	public int sum(List<?> mixed) {	
    int suma = 0;
    for(int i = 0 ; i < mixed.size() ; i++){
      if(mixed.get(i) instanceof Integer){
        suma +=(int) mixed.get(i);
      } else {
        suma += Integer.parseInt((String)mixed.get(i));
      }
    }
		return suma;
	}
}
