//https://www.codewars.com/kata/55f8a9c06c018a0d6e000132
public class Solution {
  public static boolean validatePin(String pin) {
    return pin.matches("[0-9]{4}|[0-9]{6}");
  }
}
