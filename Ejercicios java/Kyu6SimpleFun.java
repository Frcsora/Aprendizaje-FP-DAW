//https://www.codewars.com/kata/5936371109ca68fe6900000c
public class NumberAndIPAddress {

	public static String numberAndIPaddress(String s) {
    if(s.matches("^(\\d+\\.){3}\\d+$"))
            {
                long suma = 0;
                long potencia =31;
                String[] bin = s.split("\\.");
                StringBuilder sb = new StringBuilder();
                for(int i = bin.length - 1 ; i >= 0 ; i--){
                    for(int j = 0 ; j < 8 ; j++){
                        long resto = Long.parseLong(bin[i]) % 2;
                        sb.insert(0, Long.toString(resto));
                        bin[i] = Long.toString(Long.parseLong(bin[i]) / 2);
                    }
                }
                String s2 = sb.toString();

                for(char c : s2.toCharArray()){
                    
                    long n = Long.parseLong(Character.toString(c));
                    suma += n * Math.pow(2, potencia);
                    potencia--;
                }
                String sum = Long.toString(suma);
                return sum;

            }
                String[] bin = new String[4];
                StringBuilder sb = new StringBuilder(); 
                StringBuilder ip = new StringBuilder();
                
                long sl = Long.parseLong(s);
                for (int i = 0 ; i < 32 ; i++){
                    sb.append(Long.toString(sl % 2));
                    sl /= 2;

                }
                String toBin = sb.reverse().toString();
                for (int i = 0 ; i < 4 ; i++){
                    long potencia = 7;
                    long suma = 0;
                    bin[i] = toBin.substring(i * 8, i * 8 + 8);
                    for( char c : bin[i].toCharArray()){
                        long n = Long.parseLong(Character.toString(c));
                        suma += n* Math.pow(2, potencia);
                        potencia--;
                    }
                    if( i > 2){
                        ip.append(Long.toString(suma));
                    }else{
                        ip.append(Long.toString(suma) + ".");
                    }
                }
                
		            return ip.toString();
  }
}  
