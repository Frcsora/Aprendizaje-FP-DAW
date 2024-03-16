//https://www.codewars.com/kata/554ca54ffa7d91b236000023
public class EnoughIsEnough {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
    if(maxOccurrences == 0){
      return new int[0];
    }
    int[] elements2 = new int[elements.length];
    int total = 0;
		for(int i = 0 ; i < elements.length ; i++){
      if(elements[i] == -1){
        continue;
      }
      int count = 0;
      for(int j = i + 1; j < elements.length; j++){
        
        if(elements[i] == elements[j]){
          count++;
        }
        
        if(elements[i] == elements[j] && count >= maxOccurrences){
          elements[j] = -1;
        }
      }
      if(elements[i]!= -1){
          elements2[total] = elements[i];
          total++;
        }
    }
    int[] elements3 = new int[total];
    for(int i = 0 ; i < elements3.length ; i++){
      elements3[i] = elements2[i];
    }

		return elements3;
	}

}
