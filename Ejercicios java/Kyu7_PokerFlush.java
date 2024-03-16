//https://www.codewars.com/kata/5acbc3b3481ebb23a400007d
public class Kata{
  public static boolean CheckIfFlush(String[] cards){
      if(cards[0].matches("^([2-9]|10|[JQKA])S$")){
        for(int i = 1 ; i < cards.length ; i++){
          if(!cards[i].matches("^([2-9]|10|[JQKA])S$")){
            return false;
          }
        }
      } else if(cards[0].matches("^([2-9]|10|[JQKA])H$")){
        for(int i = 1 ; i < cards.length ; i++){
          if(!cards[i].matches("^([2-9]|10|[JQKA])H$")){
            return false;
          }
        }
      } else if(cards[0].matches("^([2-9]|10|[JQKA])D$")){
        for(int i = 1 ; i < cards.length ; i++){
          if(!cards[i].matches("^([2-9]|10|[JQKA])D$")){
            return false;
          }
        }
      } else if(cards[0].matches("^([2-9]|10|[JQKA])C$")){
        for(int i = 1 ; i < cards.length ; i++){
          if(!cards[i].matches("^([2-9]|10|[JQKA])C$")){
            return false;
          }
        }
      }
      return true;
  }
}
