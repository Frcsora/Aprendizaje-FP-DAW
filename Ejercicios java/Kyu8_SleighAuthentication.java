//https://www.codewars.com/kata/52adc142b2651f25a8000643
public class Sleigh {
  public static Boolean authenticate(String name, String password){
    if(name.equals("Santa Claus") && password.equals("Ho Ho Ho!")){
      return true;
    }
    return false;
  }
}
