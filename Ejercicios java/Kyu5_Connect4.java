//https://www.codewars.com/kata/586c0909c1923fdb89002031
import java.util.*;
public class Connect4 {
  int[][] board = new int[6][7];
  
  boolean player = false;
	public String play(int column) {
    
    player = player ? false : true;
    
    if(ganador(board)){
      return "Game has finished!";
    }

      int casilla = board.length - 1;                                                                     //Comprobamos si la columna existe, y en ese caso
                                                                   //si estuviera llena, en ese caso daremos un
            while(casillaOcupada(board, casilla, column)){                                                     //mensaje de error y pediremos que nos introduzca una columna valida
                casilla--;
                if(casilla < 0){
                    player = player ? false : true;
                    return "Column full!";
                }
            }
      board[casilla][column] = player ? 1 : 2;
      if(!ganador(board)){
        return player ? "Player 1 has a turn" : "Player 2 has a turn";
      }
    return player ? "Player 1 wins!" : "Player 2 wins!"; 
  }
  static boolean victoria(int a, int b, int c, int d){            // esta función nos servirá para comprobar si se cumplen
        return a == b && a == c && a ==d;
    }
    static boolean ganador(int board[][]){                                   //esta función nos servirá para determinar si se ha dado o no un ganador
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                if(j < 4){
                    if(victoria(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]) //comprobamos filas
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3){
                    if(victoria(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]) //comprobamos columnas
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j < 4){
                    if(victoria(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]) //comprobamos diagonales de izquierda a derecha
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j > 2){
                    if(victoria(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]) //comprobamos diagonales de derecha a izquierda
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
    static boolean empate(int board[][]){
        for(int i = 0; i < board.length; i++){              //comprobamos la posibilidad de que alla un empate,
            for (int j = 0; j < board[i].length ; j++){     //si una casilla esta vacia retornara directamente falso, 
                if(!casillaOcupada(board, i, j)){           //en caso contrario verdadero
                    return false;
                }
            }
        }
        return true;
    }
  static boolean casillaOcupada(int board[][], int i, int j){  //comprobamos si la casilla esta ocupada ya o no
        return board[i][j] != 0;
    }
}
