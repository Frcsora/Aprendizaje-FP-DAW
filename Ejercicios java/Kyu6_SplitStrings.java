//https://www.codewars.com/kata/515de9ae9dcfc28eb6000001
public class StringSplit {
    public static String[] solution(String s) {
        int longitud = s.length() / 2;
        if(s.length() % 2 != 0){
          longitud++;
        }
        String[] array = new String[longitud];
        for(int i = 0 ; i < s.length() ; i+=2){
          if(i == s.length() - 1){
            array[i/2] = Character.toString(s.charAt(i)) + "_";
          }else{
            array[i/2] = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i + 1));  
          }
          
        }
      for (int i = 0 ; i < array.length ; i++){
        System.out.println(array[i]);
      }
      return array;
    }
}
