//https://www.codewars.com/kata/53417de006654f4171000587
public class Game {

  public String winner(String[] deckSteve, String[] deckJosh) {
    int steve = 0;
    int josh = 0;
    String s= "23456789TJQKA";
    for(int i = 0 ; i < deckSteve.length ; i++){
      if(s.indexOf(deckSteve[i]) > s.indexOf(deckJosh[i])){
        steve++;
      } else if(s.indexOf(deckSteve[i]) < s.indexOf(deckJosh[i])){
        josh++;
      }
    }
    if(steve > josh){
      return "Steve wins " + steve + " to " + josh;
    } else if(steve < josh){
      return "Josh wins " + josh + " to " + steve;
    }
    return "Tie";
  }
}
