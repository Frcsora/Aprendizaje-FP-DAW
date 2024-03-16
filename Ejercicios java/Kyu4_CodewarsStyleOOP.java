//https://www.codewars.com/kata/51fda2d95d6efda45e00004e
class User {
  private int[] ranks ={-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};
  private int i = 0;
  public int rank = ranks[i];
  public int progress = 0;
  
  public User(){
    
  }
  public int getRank(){
    return rank;
  }
  public int getProgress(){
    return progress;
  }
  public int setRank(){
    rank = ranks[this.i];
    return capRank(this.i);
  }
  public int incProgress(int activityRank){
    
    if(!rangoValido(activityRank)){
      throw new IllegalArgumentException("Rango no valido");
    }
    int index= activityRank + 8;
    
    if(activityRank >= 0){
      index--;
    }
    
    if(this.rank == ranks[index]){
      
      progress += 3;
      
    }else if (index < 15 && this.rank == ranks[index + 1] ){
      progress++;
    } 
    else if(this.rank < ranks[index]){
      
      int calc = this.rank - ranks[index];
      if(activityRank >= 0 && rank < 0){
        calc++;
      }
      
      progress += (10 * (int) (Math.pow(calc, 2)  ));
    }else{
      progress = progress;
    }
    while(progress >= 100){
      i++;
      progress -= 100;
    }
    this.rank = setRank();
    System.out.println(rank + " " +progress);
    if(rank == 8){
      progress = 0;
    }
    return progress;
    }
  
  public int capRank(int i){
    return i >= ranks.length ? ranks[ranks.length - 1] : ranks[i];
  }
  public boolean rangoValido(int rank) {
        for (int index = 0; index < ranks.length; index++) {
            if (ranks[index] == rank) {
                return true;
            }
        }
        return false;
    }
  
}
