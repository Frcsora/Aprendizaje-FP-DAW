//https://www.codewars.com/kata/58223370aef9fc03fd000071
public class Solution {

    public static String dashatize(int num) {
      String s = Integer.toString(num);
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length() ; i++){
        
       if(Character.toString(s.charAt(i)).matches("[13579]")){
          sb.append("-" + s.charAt(i) + "-");  
        } else{
          sb.append(s.charAt(i));
       }
        
      }
      return sb.toString().replaceAll("(-)+", "-").replaceAll("^-|-$", "");
    }

}
