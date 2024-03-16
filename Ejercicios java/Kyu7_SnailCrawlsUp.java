//https://www.codewars.com/kata/5b93fecd8463745630001d05
public class Kata {
    public static int snail(int column, int day, int night) {
      int dias = 0;
      int height = 0;
      int dif = day - night;
      while(height < column){
        dias++;
        height += day;
        if(height < column){
          height -= night;
        }
      }
      return dias; // your code here
    }
}
