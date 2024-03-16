//https://www.codewars.com/kata/5412509bd436bd33920011bc
public class Maskify {
    public static String maskify(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
}
