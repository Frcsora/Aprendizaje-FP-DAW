//https://www.codewars.com/kata/5f7c38eb54307c002a2b8cc8
public class Kata {
    public static String removeParentheses(final String str) {
        String s = str;
        while(s.contains("(")){
          s = s.replaceAll("\\([\\w\\s]*\\)", "");
        }
        return s;
    }
}
