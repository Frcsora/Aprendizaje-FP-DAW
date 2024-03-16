//https://www.codewars.com/kata/58f5c63f1e26ecda7e000029
public class MexicanWave {

    public static String[] wave(String str) {
      int cuenta = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ' '){
                cuenta++;
            }
        }
        int contador = 0;
        String array[] = new String[str.length() - cuenta];
        for(int i = 0 ; contador < array.length ; i++){
            StringBuilder sb = new StringBuilder();
            boolean espacio = false;
            if(str.charAt(i) == ' '){
                    continue;
            }
            
            for(int j = 0 ; j < str.length() && !espacio ; j++){
               
                if(j == i){
                    sb.append(Character.toString(str.charAt(j)).toUpperCase());
                }else if(str.charAt(j) == ' '){
                    sb.append(" ");
                    
                   
                } 
                else{
                    sb.append(str.charAt(j));
                }
            
            }
            if(!sb.toString().equals(null)){
                array[contador] = sb.toString();
                contador++;
            }
            
        }
        return array;
    }
    
}
