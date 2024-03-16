//https://www.codewars.com/kata/578553c3a1b8d5c40300037c
import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int suma = 0;
        int contador = (int)(Math.pow(2, binary.size() - 1));
        for (int i = 0 ; i < binary.size() - 1 ; i++){
         if(binary.get(i) == 1){
            suma += (contador);
          }
          contador /= 2;
        }
        if(binary.get(binary.size() - 1) == 1){
          suma++;
        }
        return suma;
    }
}
