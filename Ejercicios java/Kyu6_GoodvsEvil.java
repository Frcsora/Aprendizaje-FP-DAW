//https://www.codewars.com/kata/52761ee4cffbc69732000738
public class GoodVsEvil {
  public static String battle(String goodAmounts, String evilAmounts) {
    String[] goods = goodAmounts.split(" ");
    String[] evils = evilAmounts.split(" ");
    int good = 0;
    int evil = 0;
    for(int i = 0 ; i < goods.length ; i++){
      if(i == 0){
        good += Integer.parseInt(goods[i]);
      }else if(i == 1){
        good += Integer.parseInt(goods[i]) * 2;
      }else if(i == 2){
        good += Integer.parseInt(goods[i]) * 3;
      }else if(i == 3){
        good += Integer.parseInt(goods[i]) * 3;
      }else if(i == 4){
        good += Integer.parseInt(goods[i]) * 4;
      }else if(i == 5){
        good += Integer.parseInt(goods[i]) * 10;
      }
      
    }
    for(int i = 0 ; i < evils.length ; i++){
      if(i == 0){
        evil += Integer.parseInt(evils[i]);
      } else if(i == 1){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 2){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 3){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 4){
        evil += Integer.parseInt(evils[i]) * 3;
      } else if(i == 5){
        evil += Integer.parseInt(evils[i]) * 5;
      } else if(i == 6){
        evil += Integer.parseInt(evils[i]) * 10;
      }
    }
    System.out.println("Good: " + good + " evil: " + evil);
    return good == evil ? "Battle Result: No victor on this battle field" : good > evil ? "Battle Result: Good triumphs over Evil" : "Battle Result: Evil eradicates all trace of Good";
  }
}
