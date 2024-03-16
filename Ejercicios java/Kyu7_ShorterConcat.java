//https://www.codewars.com/kata/54557d61126a00423b000a45
public class ReverseLonger {


	public static String shorterReverseLonger(String a, String b) {

        String menor = a.length() < b.length() ? a : b;  
        String mayor = a.length() >= b.length() ? a : b;
        StringBuilder sb = new StringBuilder(menor);
        for(int i = mayor.length() - 1 ; i >=0 ; i--){
            sb.append(mayor.charAt(i));
        }
        sb.append(menor);
        return sb.toString();

	}

}
