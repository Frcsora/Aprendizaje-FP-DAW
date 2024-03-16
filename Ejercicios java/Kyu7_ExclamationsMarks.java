//https://www.codewars.com/kata/57faf32df815ebd49e000117
public class R {
  public static String removeBang(String str) {
    return str.replaceAll("[!]+ ", ("!  ")).replaceAll("[!]+$|[!]+ ", "");
  }
}
