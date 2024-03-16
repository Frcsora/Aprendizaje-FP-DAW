//https://www.codewars.com/kata/634913db7611b9003dff49ad
public class TheCullingOfStratholme  {
    public static String purify(String s) {
        return s.replaceAll("[\\w]{0,1}[iI]+[\\w]{0,1}", "").replaceAll("( )+", " ").trim();
    }
}
