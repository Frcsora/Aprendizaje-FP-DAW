//https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
public class Snail {

    public static int[] snail(int[][] array) {
      if(array== null|| array.length == 0 || array[0].length == 0){
        return new int[0];
      }
      int[] snailArray = new int[(int) (Math.pow(array.length,2))];
      int totalCiclos = 1;
      for(int i = 1 ; i < array.length ; i++ ){
        totalCiclos += 2;
      }
      int contador = 0;
      int limite1 = 0;
      int limite2 = array.length - 1;
      for(int i = 0 ; i < totalCiclos; i++){
        if(i % 2 == 0){
          if(i % 4 == 0){//fila de arriba
            for(int j = limite1 ; j <= limite2 ; j++){
              
              snailArray[contador] = array[limite1][j];
              contador++;
            }
            limite1++;
          }else{//fila de abajo
            for(int j = limite2 - 1 ; j >= limite1 - 1 ; j--){
              snailArray[contador] = array[limite2][j];
              contador++;
            }
            limite2--;
          }
        }else{
          if((i - 1) % 4 == 0){//columna de la derecha
            System.out.println(limite1);
            System.out.println(limite2);
            for(int j = limite1 ; j <= limite2 ; j++){
              snailArray[contador] = array[j][limite2];
              contador++;
            }
          } else{//columna de la izquierda
            for(int j = limite2 ; j >= limite1 ; j--){
              snailArray[contador] = array[j][limite1 - 1];
              contador++;
            }
          } 
        }
      }
      return snailArray;
   } 
}
