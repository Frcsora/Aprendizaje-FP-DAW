//https://www.codewars.com/kata/577bd8d4ae2807c64b00045b
public class Kata {
  public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
    boolean player1 = firstAttacker.equals(fighter1.name) ? false : true;
    while(fighter1.health > 0 && fighter2.health > 0){
      player1 = player1 ? false : true;
      if(player1){
        fighter2.health -= fighter1.damagePerAttack;
      }else{
        fighter1.health -= fighter2. damagePerAttack;
      }
    }
    return player1 ? fighter1.name : fighter2.name;
    
    
  }
}
