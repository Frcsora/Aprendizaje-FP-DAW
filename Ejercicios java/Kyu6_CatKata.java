//https://www.codewars.com/kata/5869848f2d52095be20001d1
public class PeacefulYard {
    public static boolean peacefulYard(String[] yard, int minDistance) {
        int distancia = 0;
        boolean pelea = true;
        boolean l = false;
        boolean m = false;
        boolean r = false;
        int gatos = 0;
        
        int gatetes[][] = new int[3][2];
        for (int i = 0 ; i < yard.length ; i++){
            for(int j = 0 ; j < yard[i].length() ; j++){
                if(yard[i].charAt(j) == 'L'){
                    l = true;
                    gatos++;
                    gatetes[0][0] = i;
                    gatetes[0][1] = j;
                } 
                if(yard[i].charAt(j) == 'M'){
                    m = true;
                    gatos++;
                    gatetes[1][0] = i;
                    gatetes[1][1] = j;
                }
                if(yard[i].charAt(j) == 'R'){
                    r = true;
                    gatos++;
                    gatetes[2][0] = i;
                    gatetes[2][1] = j;
                }
            }
        }

        switch(gatos){
            case 0:
              break;
            case 1: 
                System.out.println("Only one cat is in the yard");
                break;
            case 2:
                if(!r){
                    distancia = (int) (Math.sqrt(Math.pow((gatetes[0][0]-gatetes[1][0]) , 2) 
                            + Math.pow((gatetes[0][1]-gatetes[1][1]) , 2)));
                }else if(!l){
                    distancia = (int) (Math.sqrt(Math.pow((gatetes[1][0]-gatetes[2][0]) , 2) 
                            + Math.pow((gatetes[1][1]-gatetes[2][1]) , 2)));
                }else {
                    distancia = (int) (Math.sqrt(Math.pow((gatetes[0][0]-gatetes[2][0]) , 2) 
                            + Math.pow((gatetes[0][1]-gatetes[2][1]) , 2)));
                }
                if(distancia <= minDistance){
                    pelea = false;
                }
                break;
            case 3:
                for(int i = 0; i < 2 && pelea ; i++){
                    distancia = (int) (Math.sqrt(Math.pow((gatetes[i][0]-gatetes[i+1][0]) , 2) 
                            + Math.pow((gatetes[i][1]-gatetes[i+1][1]) , 2)));
                    if(distancia < minDistance){
                        pelea = false;
                    }
                }
                while(pelea){
                    distancia = distancia = (int) (Math.sqrt(Math.pow((gatetes[0][0]-gatetes[2][0]) , 2) 
                            + Math.pow((gatetes[0][1]-gatetes[2][1]) , 2)));
                    if(distancia < minDistance){
                        pelea = false;
                    } else{
                      break;
                    }
                }
            break;
            default:
                System.out.println("No hay gatos en la zona");
        }
      return pelea;
    }
}
