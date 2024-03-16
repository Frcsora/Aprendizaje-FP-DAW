//https://www.codewars.com/kata/563a8656d52a79f06c00001f
public class IdentifierChecker {
  public static boolean isValid(String idn) {
    return idn.matches("^[A-Za-z\\$_][A-Za-z\\d_\\$]+$");
  }
}
