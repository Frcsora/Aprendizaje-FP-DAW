//https://www.codewars.com/kata/5b043e3886d0752685000009
public class PizzaPayments {
  public static double michaelPays(double cost) {
    double kate = 0;
        double michael = 0;
        if(cost < 5){
            michael = cost;
        } else{
            kate = cost / 3;
            michael = cost / 3 *2;
            if(kate > 10){
                kate = 10;
                michael = cost - 10;
            }
        }
        michael =(int)(michael * 1000);
        if(michael % 10 >= 5){
            michael+=10;
        }
        michael = (int)(michael/10);

        michael = (double)(michael/100);
    return michael;
  }
}
