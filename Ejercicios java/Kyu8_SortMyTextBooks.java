//https://www.codewars.com/kata/5a07e5b7ffe75fd049000051
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class sorter {
  public static List<String> sort(List<String> textbooks) {
    List<String> lista = new ArrayList<String>();
    for (int i = 0 ; i < textbooks.size() ; i++){
      lista.add(textbooks.get(i));  
      Collections.sort(lista, String.CASE_INSENSITIVE_ORDER);//IMPORTANTE ESTE COMANDO PARA HACER QUE NO TENGO EN CUENTA SI MAYUSCULAS O MINUSCULAS
    }
    return lista;
  }
}
