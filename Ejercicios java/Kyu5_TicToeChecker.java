//https://www.codewars.com/kata/525caa5c1bf619d28c000335
public class Solution {
    public static int isSolved(int[][] board) {
        for(int i = 0; i < board.length ; i++){
          if(board[i][0] == board[i][1]
            && board[i][0] == board[i][2] &&
            board[i][0] != 0){
            return board[i][0];
          } else if (board[0][i] == board[1][i]
                     && board[0][i] == board[2][i] 
                     && board[2][i] != 0){
            return board[0][i];
          } else if(board[0][0] == board[1][1]
                   && board[0][0]==board[2][2] &&
                    board[0][0] != 0){
            return board[0][0];
          }else if(board[0][2] == board[1][1]
                   && board[0][2]==board[2][0] &&
                    board[0][2] != 0){
            return board[0][2];
          }
        }
        for(int i = 0 ; i < board.length ; i++){
          for(int j = 0 ; j < board[i].length; j++){
            if(board[i][j] == 0){
              return -1;
            }
          }
        }
        return 0;
    }

}
