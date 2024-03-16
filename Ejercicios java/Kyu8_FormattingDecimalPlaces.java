//https://www.codewars.com/kata/5641a03210e973055a00000d
public class Numbers
{
  public static double TwoDecimalPlaces(double number)
  {
    long redondeo = (long) (number * 1000);
    if(redondeo % 10 >= 5){
      redondeo /= 10;
      redondeo++;
    } else {
      redondeo /= 10;
    }
    
    return (double) (redondeo) / 100;
  }
}
