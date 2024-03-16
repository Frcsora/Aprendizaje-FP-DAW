//https://www.codewars.com/kata/5813d19765d81c592200001a
public class Kata
{
  public static int dontGiveMeFive(int start, int end)
  {
    int contador = 0;
    for(int i = start ; i <=end ; i++){
      String numero = Integer.toString(i);
      if(numero.indexOf("5")!= -1){
        continue;
      }
      contador++;
    }
    return contador;
  }
}
