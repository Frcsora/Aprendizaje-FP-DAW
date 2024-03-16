//https://www.codewars.com/kata/582e0450fe38013dbc0002d3
public class RegexTicTacToeWinChecker {
    public static boolean regexTicTacToeWinChecker(String board) {
      if(board.matches("^[X]{3}[XO-]{6}$") || board.matches("^[XO-]{3}[X]{3}[XO-]{3}$") || board.matches("^[XO-]{6}[X]{3}$")
        || board.matches("^[O]{3}[XO-]{6}$") || board.matches("^[XO-]{3}[O]{3}[XO-]{3}$") || board.matches("^[XO-]{6}[O]{3}$") ||
        board.matches("^O[XO-]{3}O[XO-]{3}O$") || board.matches("^X[XO-]{3}X[XO-]{3}X$") ||
        board.matches("^[XO-]{2}O[XO-]{1}O[XO-]{1}O[XO-]{2}$") 
        || board.matches("^[XO-]{2}X[XO-]{1}X[XO-]{1}X[XO-]{2}$") ){
        return true;
      }
      if(board.matches("^X[XO-]{2}X[XO-]{2}X[XO-]{2}$") ||
         board.matches("^[XO-]X[XO-]{2}X[XO-]{2}X[XO-]{1}$") ||
         board.matches("^[XO-]{2}X[XO-]{2}X[XO-]{2}X  $") ||
         board.matches("^O[XO-]{2}O[XO-]{2}O[XO-]{2}$") ||
         board.matches("^[XO-]{1}O[XO-]{2}O[XO-]{2}O[XO-]{1}$") ||
         board.matches("^[XO-]{2}O[XO-]{2}O[XO-]{2}O$")){
         return true;
      }
      if(board.matches("^X[XO-]{3}X[XO-]{3}X$") || board.matches("^O[XO-]{3}O[XO-]{3}O$") || 
        board.matches("^[XO-]{2}X[XO-]X[XO-]X[XO-]{2}$") || board.matches("^[XO-]{2}O[XO-]O[XO-]O[XO-]{2}$")){
        return true;
      }
      return false;
    }
}
