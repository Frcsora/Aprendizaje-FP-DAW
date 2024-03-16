//https://www.codewars.com/kata/514b92a657cdc65150000006
public class Solution {

  public int solution(int number) {
    int suma = 0;
    for (int i = number - 1; i > 0 ; i--){
      if(i % 3 == 0 || i % 5 == 0){
        suma += i;
      }
    }
    return suma;
  }
}
