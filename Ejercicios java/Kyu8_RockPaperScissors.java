//https://www.codewars.com/kata/5672a98bdbdd995fad00000f
public class Kata {
  public static String rps(String p1, String p2) {
    String result = "";
    switch(p1){
        case "scissors":
          if(p2.contains("scissors")){
            result = "Draw!";
          }
          else if(p2.contains("rock")){
            result = "Player 2 won!";
          }
          else if(p2.contains("paper")){
            result = "Player 1 won!";
          }
          break;
        
        case "rock":
          if(p2.contains("rock")){
            result = "Draw!";
          }
          else if(p2.contains("paper")){
            result = "Player 2 won!";
          }
          else if(p2.contains("scissors")){
            result = "Player 1 won!";
          }
          break;
        
        case "paper":
          if(p2.contains("paper")){
            result = "Draw!";
          }
          else if(p2.contains("scissors")){
            result = "Player 2 won!";
          }
          else if(p2.contains("rock")){
            result = "Player 1 won!";
          }
          break;
    }
    return result;
      
  }
}
