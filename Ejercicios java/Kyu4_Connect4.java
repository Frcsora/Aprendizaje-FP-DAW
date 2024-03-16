//https://www.codewars.com/kata/56882731514ec3ec3d000009
import java.util.*;

public class ConnectFour {
    public static String whoIsWinner(List<String> piecesPositionList) {
      String[][] board = new String[6][7];
      boolean player1 = true;
      
      for(int i = 0; i < board.length ; i++){
            Arrays.fill(board[i], " ");         
        }
      for(int i = 0 ; i < piecesPositionList.size() && !ganador(board); i++){
          player1 = player1 ? false : true;
          String[] jugada = piecesPositionList.get(i).split("_");
          if(i == 0 && jugada[1].equals("Red")){
            player1 = true;
          } 
          System.out.println(player1);
          System.out.println(i);
          int casilla = board.length - 1;
          int n = (int) (jugada[0].charAt(0) ) - 16;
          char c = (char) n;
          String s = Character.toString(c);
          int n2 = Integer.parseInt(s);
            while(casillaOcupada(board, casilla, n2 - 1)){                                                   
                casilla--;
                if(casilla < 0){
                    break;
                }
            }
          board[casilla][n2 - 1] = player1 ? "X" : "O";
        }
      if(empate(board)){
        return "Draw";
      }
      
        return player1 ? "Red" : "Yellow";
    }
    static boolean victoria(String a, String b, String c, String d){           
        if(a.equals(b) && a.equals(c) && a.equals(d)){    
            return true;
        }
        return false;
    }
    static boolean ganador(String board[][]){                                   
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                if(j < 4){
                    if(victoria(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3){
                    if(victoria(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j < 4){
                    if(victoria(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j > 2){
                    if(victoria(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(empate(board)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean empate(String board[][]){
        for(int i = 0; i < board.length; i++){              
            for (int j = 0; j < board[i].length ; j++){     
                if(!casillaOcupada(board, i, j)){          
                    return false;
                }
            }
        }
        return true;
    }
   
    static boolean casillaOcupada(String board[][], int i, int j){  
        if(!board[i][j].equals(" ")){
            return true;
        }
        return false;
    }
}
