//https://www.codewars.com/kata/59e66e48fc3c499ec5000103
import java.util.List;

public class Kata {
    public static int solve(final List<List<Integer>> data) {
      boolean order = false;
      int total = 1;
      while(!order){
        order = true;
        for(int i = 0 ; i < data.size() ; i++){
          for(int j = 0 ; j < data.get(i).size() - 1 ; j++){
            for(int k = j + 1 ; k < data.get(i).size(); k++){
                if(data.get(i).get(j) == data.get(i).get(k)){
                  data.get(i).remove(k);
                  order = false;
                }                
            }
          }
        }
      }
      for(int i = 0 ; i < data.size() ; i++){
        total *= data.get(i).size();
      }
        
      return total; 
    }
}
