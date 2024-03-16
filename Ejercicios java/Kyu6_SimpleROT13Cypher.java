//https://www.codewars.com/kata/5894986e2ddc8f6805000036
public class Kata {
	
	public static String ROT135(String input)
	{
		 StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < input.length() ; i++){
            if(Character.toString(input.charAt(i)).matches("^[A-Za-z]$")){
                if(Character.toString(input.charAt(i)).matches("[N-Zn-z]")){
                    int n = (int) input.charAt(i);
                    n = n - 13;
                    sb.append((char) n);
                }else{
                    int n = (int) input.charAt(i);
                    n = n + 13;
                    sb.append((char) n);
                }
                
            } else if(Character.toString(input.charAt(i)).matches("[0-9]")){
                if(Character.toString(input.charAt(i)).matches("[5-9]")){
                    int n = (int) input.charAt(i);
                    n = n - 5;
                    sb.append((char) n);
                }else{
                    int n = (int) input.charAt(i);
                    n = n + 5;
                    sb.append((char) n);
                }
            } else{
                    sb.append(input.charAt(i));
            }
        }
    return sb.toString();
	}
}
