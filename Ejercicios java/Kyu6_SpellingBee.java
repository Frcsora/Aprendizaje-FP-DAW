//https://www.codewars.com/kata/57d6b40fbfcdc5e9280002ee
public class Dinglemouse {

    public static int howManyBees(final char [][] hive) {
      if(hive ==null)
        {
        return 0;
      }
      int bees = 0;
      for(int i = 0 ; i < hive.length ; i++){
        for(int j = 0 ; j < hive[i].length ; j++){
          if(i <= hive.length - 3){
            if(bee(hive[i][j], hive[i + 1][j], hive[i + 2][j])){
              bees++;
            }
          }
          if(j <= hive[i].length - 3){
            if(bee(hive[i][j], hive[i][j + 1], hive[i][j + 2])){
              bees++;
            }
          }
        }
      }
      return bees;
    }
    static boolean bee(char a, char b, char c){
      return (a == 'b' && b == 'e' && c == 'e') || (a == 'e' && b == 'e' && c == 'b');
    }
}
