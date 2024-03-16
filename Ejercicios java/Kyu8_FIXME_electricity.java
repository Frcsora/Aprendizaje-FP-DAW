//https://www.codewars.com/kata/596c55fc7bd5476bf60000d5
public class Dinglemouse {
  
  private static int ONE_HUNDRED = 100;
  private int value; 
  
  private Dinglemouse() {
    value = ONE_HUNDRED;
  }
  public static final Dinglemouse INST = new Dinglemouse();
  
  public int plus100(int n) {
    return value + n;
  }
  
}
