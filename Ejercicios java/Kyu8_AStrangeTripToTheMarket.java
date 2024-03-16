//https://www.codewars.com/kata/55ccdf1512938ce3ac000056
public class Nessie {
    public static boolean isLockNessMonster(String s){
      //Importante el truco este de indexOf -1, lo he encontrado por internet y al principio me petaba la cabeza pero lo he acabado entendiendo
     if (s.indexOf("tree fiddy") != -1 || s.indexOf("3.50") != -1 || s.indexOf("three fifty") != -1 ){
       return true;
     }
      return false;
    }
}
