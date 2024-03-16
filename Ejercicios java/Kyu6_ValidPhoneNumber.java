public class Kata {
  public static boolean validPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("^\\([0-9]{3}\\)\s[0-9]{3}-[0-9]{4}$");
  }
}
