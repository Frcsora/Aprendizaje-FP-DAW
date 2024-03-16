//https://www.codewars.com/kata/546e2562b03326a88e000020
public class SquareDigit {

  public int squareDigits(int n) {
    String s = Integer.toString(n);
    String s2 = "";
    for(int i = 0 ; i < s.length() ; i++){
      int n2 = Integer.parseInt(Character.toString(s.charAt(i)));
      n2 *= n2;
      s2 += Integer.toString(n2);
    }
    return Integer.parseInt(s2);
  }

}
