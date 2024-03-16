//https://www.codewars.com/kata/5208f99aee097e6552000148
class Solution {
  public static String camelCase(String input) {
    StringBuilder sb = new StringBuilder();
    for ( int i = 0 ; i < input.length() ; i++){
      if(Character.isLowerCase(input.charAt(i))){
        sb.append(input.charAt(i));
      }
      else if(Character.isUpperCase(input.charAt(i))){
        sb.append(" ");
        sb.append(input.charAt(i));
      }
    }
    String s = sb.toString();
    return s;
  }
}
