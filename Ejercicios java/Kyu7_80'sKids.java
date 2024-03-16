//https://www.codewars.com/kata/5660aa3d5e011dfd6e000063
public class EightiesKids2 {

  public static String findSpaceship(String map) {
    String location = "";
    int x = 0;
    int y = 0;
    String[] mapa = map.split("\n");
    for(int i = 0 ; i < mapa.length ; i++){
      for(int j = 0 ; j < mapa[i].length() ; j++){
        if(mapa[i].charAt(j) == 'X'){
          x = mapa.length - 1 - i;
          y = j;
          return "[" + y + ", " + x +"]";
        }
      }
    }
    return "Spaceship lost forever.";
  }
}
