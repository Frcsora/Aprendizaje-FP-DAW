//https://www.codewars.com/kata/5aa67541373c2e69a20000c9
import java.util.*;

public class Dinglemouse {

  public static String playOX3D(final List<int[]> moves) {
    String board[][][] = new String[4][4][4];
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                   
                    Arrays.fill(board[i][j] ," ");
                }
            }
            boolean player1 = false;
            int turns = 0;
            for(int i = 0 ; i < moves.size() && !finPartida(board) ; i++){
                
                player1 = player1 ? false : true;
                board[moves.get(i)[0]][moves.get(i)[1]][moves.get(i)[2]] = player1? "O" : "X";
                turns++;

            }
            if(!finPartida(board)){
                return "No winner";
            }
    return empate(board) ? "No winner" : player1 ? "O wins after " + turns + " moves" : "X wins after " + turns + " moves";
  }
  static boolean equal(String a, String b, String c, String d){
            return a.equals(b) && a.equals(c) && a.equals(d);
        }
        static boolean casillaOcupada(String board[][][], int i, int j, int k){
            return !board[i][j][k].equals(" ");
        }
        static boolean empate(String board[][][]){
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                    for(int k = 0 ; k < board[i][j].length ; k++){
                        if(!casillaOcupada(board, i, j, k)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        static boolean finPartida(String board[][][]){
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                    for(int k = 0 ; k < board[i][j].length ; k++){
                        if(i == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j][k], board[i + 2][j][k], board[i + 3][j][k])){
                                return true;
                            }
                        }
                        if(j == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j + 1][k], board[i][j + 2][k], board[i][j + 3][k])){
                                return true;
                            }
                        }
                        if(k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j][k + 1], board[i][j][k + 2], board[i][j][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && j == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j + 1][k], board[i + 2][j + 2][k], board[i + 3][j + 3][k])){
                                return true;
                            }
                        }
                        if(i == 0 && j == board[i].length - 1){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j - 1][k], board[i + 2][j - 2][k], board[i + 3][j - 3][k])){
                                return true;
                            }
                        }
                        if(i == 0 && j == 0 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j + 1][k + 1], board[i + 2][j + 2][k + 2], board[i + 3][j + 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == board.length - 1 && j == 0 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j + 1][k + 1], board[i - 2][j + 2][k + 2], board[i - 3][j + 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && j == board.length - 1 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j - 1][k + 1], board[i + 2][j - 2][k + 2], board[i + 3][j - 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == board.length - 1 && j == board.length - 1 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j - 1][k + 1], board[i - 2][j - 2][k + 2], board[i - 3][j - 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j][k + 1], board[i + 2][j][k + 2], board[i + 3][j][k + 3])){
                                return true;
                          }
                        }
                        if(i == board.length - 1 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j][k + 1], board[i - 2][j][k + 2], board[i - 3][j][k + 3])){
                                return true;
                          }
                        }
                        if( j == 0 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j + 1][k + 1], board[i][j + 2][k + 2], board[i][j + 3][k + 3])){
                                return true;
                          }
                        }
                        if(j == board.length - 1 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j - 1][k + 1], board[i][j - 2][k + 2], board[i][j - 3][k + 3])){
                                return true;
                          }
                        }
                }
              }
            }
            if(empate(board)){
                return true;
            }
            return false;
    }
  }
