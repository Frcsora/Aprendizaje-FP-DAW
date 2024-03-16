//https://www.codewars.com/kata/5282b48bb70058e4c4000fa7
import java.util.HashMap;

public class HexToRGB {
  
  public static HashMap<String, Integer> hexStringToRGB(String hex) {
    hex = hex.replace("#", "");
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        String colors = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        String hexa[] = hex.split("");
        int r = ((colors.indexOf(hexa[0]) * 16) + (colors.indexOf(hexa[1])));
        int b = ((colors.indexOf(hexa[4]) * 16) + (colors.indexOf(hexa[5])));
        int g = ((colors.indexOf(hexa[2]) * 16) + (colors.indexOf(hexa[3])));
        System.out.println(r);
        System.out.println(g);
        System.out.println(b);
        map1.put("r", r);
        map1.put("g", g);
        map1.put("b", b);
    
    
    return map1;
  }
  
}
