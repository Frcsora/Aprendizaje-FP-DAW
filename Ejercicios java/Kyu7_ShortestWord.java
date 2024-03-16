//https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9
public class Kata {
    public static int findShort(String s) {
        String[] palabra = s.split(" ");
        int menor = 25;
        for ( int i = 0 ; i < palabra.length ; i++){
          int longitud = palabra[i].length();
          if(longitud < menor){
            menor = longitud;
          }
        }
        return menor;
    }
}
