//https://www.codewars.com/kata/52fba66badcd10859f00097e
import java.util.Arrays;
import java.util.ArrayList;
public class Troll {
    public static String disemvowel(String str) {
      return str.replaceAll("[aeiouAEIOU]", "");
    }
}
