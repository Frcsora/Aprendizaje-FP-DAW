//https://www.codewars.com/kata/564e7fc20f0b53eb02000106
public class Consonants {
  public static int getCount(String str) {
    str = str.replaceAll("[aeiouAEIOU\\s\\W0-9_]", "");
    return str.length();
  }
}
