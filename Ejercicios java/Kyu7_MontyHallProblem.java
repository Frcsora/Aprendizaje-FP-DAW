//https://www.codewars.com/kata/54f9cba3c417224c63000872
public class MontyHall {

	public int montyHallCase(int correctDoorNumber, int[] participantGuesses) {
    double prob = 0;
    for(int i = 0 ; i < participantGuesses.length ; i++){

      if(participantGuesses[i] != correctDoorNumber){
        prob += 3.0 /3 * 100;
      }
    }
    double average = prob/participantGuesses.length;
		return Math.round((float)average);
	}

}
