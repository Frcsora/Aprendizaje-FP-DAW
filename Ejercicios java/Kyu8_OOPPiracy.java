//https://www.codewars.com/kata/54fe05c4762e2e3047000add
public class Ship {
  private final double draft;
  private final int crew;
    
  public Ship(double draft, int crew) {
    this.draft = draft;
    this.crew = crew;
  }
  public boolean isWorthIt(){
    double peso = draft;
    double tripulacion = (double)crew;
    peso -= (tripulacion * 1.5);
    if(peso > 20){
      return true;
    }
    return false;
  }
  
} 
