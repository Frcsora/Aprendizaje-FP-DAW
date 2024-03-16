//https://www.codewars.com/kata/57d29ccda56edb4187000052
import java.util.*;
public class Kata {
  
  public static String rpsls(String player1, String player2){
    HashMap<Integer, String> mapa = new HashMap<Integer, String>();
            mapa.put(0, "scissors");
            mapa.put(1, "paper");
            mapa.put(2, "rock");
            mapa.put(3, "lizard");
            mapa.put(4, "spock");
           
            if(Empate(player1, player2)){
                return "Draw!";
            } else{
                if(player1.equals(mapa.get(0))){
                    return player2.equals(mapa.get(1)) || player2.equals(mapa.get(3)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = tijeras
                } else if(player1.equals(mapa.get(1))){
                    return player2.equals(mapa.get(2)) || player2.equals(mapa.get(4)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = papel
                } else if(player1.equals(mapa.get(2))){
                    return player2.equals(mapa.get(0)) || player2.equals(mapa.get(3)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = piedra
                }else if(player1.equals(mapa.get(3))){
                    return player2.equals(mapa.get(1)) || player2.equals(mapa.get(4)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = lagarto
                }else if(player1.equals(mapa.get(4))){
                    return player2.equals(mapa.get(0)) || player2.equals(mapa.get(2)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = spock
                }
            }
    return "";
  }
  static boolean Empate(String a, String b){
            if(a.equals(b)){
                return true;
            }
            return false;
        }
}
