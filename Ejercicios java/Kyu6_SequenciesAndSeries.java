//https://www.codewars.com/kata/5254bd1357d59fbbe90001ec
public class Sequence {

  public static long getScore(long n) {
    long score = 0;
    long aumento = 50;
    for(int i = 1 ; i <= n ; i++){
      if(i == 1){
        score=50;
      }else{
       score += aumento;  
      }
      aumento += 50;
    }
    return score;
  }
}
