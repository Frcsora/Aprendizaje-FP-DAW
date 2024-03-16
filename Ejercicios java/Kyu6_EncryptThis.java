//https://www.codewars.com/kata/5848565e273af816fb000449
public class Kata {
    public static String encryptThis(String text) {
        StringBuilder sb = new StringBuilder();
        String[] a = text.split(" ");
        for(int i = 0 ; i < a.length ; i++){
            StringBuilder sb2 = new StringBuilder();
            for(int j = 0 ; j < a[i].length() ; j++){
                if(j == 0){
                    int n = (int) a[i].charAt(0);
                    sb2.append(Integer.toString(n));
                } else if(j == 1){
                    sb2.append(a[i].charAt(a[i].length() - 1));
                }
                else if (j == a[i].length() - 1) {
                    sb2.append(a[i].charAt(1));
                }
                else{
                    sb2.append(a[i].charAt(j));
                }
                
            }
            sb.append(" "+ sb2);
        }
      return sb.toString().trim();
    }
}
