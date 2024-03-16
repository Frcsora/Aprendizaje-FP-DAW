//https://www.codewars.com/kata/526989a41034285187000de4
import java.util.*;
public class CountIPAddresses {

	public static long ipsBetween(String start, String end) {

            String[] startArr = start.split("\\.");
            String[] endArr = end.split("\\.");
            HashMap<Integer, String> mapa1 =  new HashMap<Integer,String>();
            HashMap<Integer, String> mapa2 =  new HashMap<Integer,String>();
            Integer n = 0;
            for(String s : startArr){

                mapa1.put(n + 1,s);
                n++;
            }
            for(Map.Entry<Integer, String> entrada: mapa1.entrySet()){
                
            }
            n = 0;
            for(String s : endArr){

                mapa2.put(n + 1,s);
                n++;
            }
            long n1 = 0;
            long n2 = 0;
            long n3 = 0;
            long n4 = 0;
            long total = 0;
            if(Long.parseLong(mapa1.get(1)) == Long.parseLong(mapa2.get(1))){
                if((long) Long.parseLong(mapa1.get(2)) == Long.parseLong(
                        mapa2.get(2))){
                    if((long) Long.parseLong(mapa1.get(3)) == Long.parseLong(mapa2.get(3))){
                        n4 = (long)Long.parseLong(mapa2.get(4)) - Long.parseLong(mapa1.get(4));
                      total = n4;
                    }else{
                        n3 = (long) (Long.parseLong(mapa2.get(3)) - Long.parseLong(mapa1.get(3)));
                        n4 = (long)Long.parseLong(mapa2.get(4)) - Long.parseLong(mapa1.get(4));
                        total = (256 * n3) + n4;
                    }
                } else {
                        n2 = (long)Long.parseLong(mapa2.get(2)) - Long.parseLong(mapa1.get(2));
                        n3 = (long) (Long.parseLong(mapa2.get(3)) - Long.parseLong(mapa1.get(3)));
                        n4 = (long)Long.parseLong(mapa2.get(4)) - Long.parseLong(mapa1.get(4));
                        total = (long)(Math.pow(256, 2) * n2) + (256 * n3) + n4;
                    }
            }else{
                n1 = (long)Long.parseLong(mapa2.get(1)) - Long.parseLong(mapa1.get(1));
                n2 = (long)Long.parseLong(mapa2.get(2)) - Long.parseLong(mapa1.get(2));
                n3 = (long) (Long.parseLong(mapa2.get(3)) - Long.parseLong(mapa1.get(3)));
                n4 = (long)Long.parseLong(mapa2.get(4)) - Long.parseLong(mapa1.get(4));
                total = (long)(Math.pow(256,3) * n1) + (long)(Math.pow(256, 2) * n2) + (256 * n3) + n4;
            }
    return total;
	}
}
