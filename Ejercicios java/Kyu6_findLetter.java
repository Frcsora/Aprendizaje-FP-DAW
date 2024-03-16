//https://www.codewars.com/kata/5839edaa6754d6fec10000a2
public class Kata
{
  public static char findMissingLetter(char[] array)
  {
    
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int start = abc.indexOf(Character.toString(array[0]).toUpperCase());
    for(int i = 0 ; i < array.length ; i++){
        System.out.print(Character.toString(array[i]).toUpperCase());
        System.out.print("");
        System.out.print(abc.charAt(start + i));
        if(Character.toString(array[i]).toUpperCase().equals(Character.toString(abc.charAt(start + i)))){
          
          
        }else{
          if(Character.isLowerCase(array[i])){
            
            String s = Character.toString(abc.charAt(start + i));
            return Character.toLowerCase(abc.charAt(start + i));
          }
          return abc.charAt(start + i);
        }
    }
    return ' ';
  }
}
