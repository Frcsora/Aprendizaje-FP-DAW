//https://www.codewars.com/kata/5ea39ab1d8425e0029fcd035
public class Dinglemouse {

  public static String pingPong(String sounds) {

       int ping = 0;
        int pong = 0;
        String rally[] = sounds.split("-");
        for(int i = 0 ; i < rally.length ; i++){
            if(rally[i].equals("ping")){
                while(rally[i].equals("ping") || rally[i].equals("pong")){
                    i++;
                }
                if(!rally[i - 1].equals("ping")){
                    ping++;
                }
            }
            if(rally[i].equals("pong")){
                while(rally[i].equals("ping") || rally[i].equals("pong")){
                    i++;
                }
                if(!rally[i - 1].equals("pong")){
                    pong++;
                }
            }
        }
        
        int ganaPing = sounds.lastIndexOf("ping");
        int ganaPong = sounds.lastIndexOf("pong");
    
    System.out.println(ping + " " + pong);   
    if(ping == pong){
            return ganaPing < ganaPong ? "ping" : "pong";
        }
       
    return ping < pong ? "pong" : "ping"; // or "pong"
  }
  
}
