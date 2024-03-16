//https://www.codewars.com/kata/56a4a3d4043c316002000042
public class RegexValidation {

  public static boolean validateTime(String time) {
    return time.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
  }
}
