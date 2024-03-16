//https://www.codewars.com/kata/52223df9e8f98c7aa7000062
class Solution {
  
   public static String rot13(String message) {
     StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < message.length() ; i++){
            if(Character.toString(message.charAt(i)).matches("^[A-Za-z]$")){
                if(Character.toString(message.charAt(i)).matches("[N-Zn-z]")){
                    int n = (int) message.charAt(i);
                    n = n - 13;
                    sb.append((char) n);
                }else{
                    int n = (int) message.charAt(i);
                    n = n + 13;
                    sb.append((char) n);
                }
                
            } else{
                sb.append(message.charAt(i));
            }
        }
     return sb.toString();
   }
}
