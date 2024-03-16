//https://www.codewars.com/kata/525f50e3b73515a6db000b83
4 kyu
Snail
Java:

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

    10 days ago
    Refactor

public class Snail {

    public static int[] snail(int[][] array) {
        
        if(array.length == 0|| array == null || array[0].length == 0){
          int[] arr = new int[0];
          return arr;
        }
      
        int arr[] = new int[array.length * array[0].length];// el array que estamos rellenando tendra una longitud de todas las posiciones dentro del array bidimensional
        int filas = 0;//esta variable nos permitira controlar la posicion en que nos encomtramos
        int longitud = 1;//esta variable nos permitirá saber cuantos giros necesita para llegar al centro
        for(int i = 0 ; i < array.length ; i++){
          longitud+=2;
        }
        int contador = 0;// esta variable nos permitira llevar la cuenta del indice del array que estamos rellenando
        
        /*La lógica es la siguiente: el patrón es que tras cada rotación par(teniendo en cuenta que empezamos por 0 y contamos 0 como par)
        la cantidad de casillas que recorremos se reduce en 1, para eso utilizamos la variable filas*/
        for(int i = 0; i <= longitud ; i++){
            /*El problema esta en que cada vez  que volvemos a una misma posición la variable filas habra aumentado en 2, sin embargo, por el lado
            en que nos encontramos nosotros solo lo habrá hecho en 1, por eso jugaremos con la variable filas dividiendola entre 2 para tener en cuenta
            las casillas ocupadas en el otro lado de la matriz*/
            if (i % 2 == 0){
                if(i % 4 == 0){//filas de arriba
                    for (int j = filas/2 ; j < array.length - (filas/2) ; j++){//filas/2 en rotaciones(1 = 0, 2 = 1, 3 = 2)
                        arr[contador] = array[filas/2][j];
                        contador++;
                    }
                    
                } else {//filas de abajo
                    for(int j = array.length - (filas + 1) /2 -1; j >= filas/2 ; j--){
                        arr[contador] = array[array.length - (filas/2) - 1][j];
                        contador++;
                    }
                }
                filas++;

            } else {
                if((i-1) % 4 == 0){//columnas de la derecha
                    for (int j = (filas + 1)/2 ; j <= array.length - (filas + 1)/2  ; j++){
                        arr[contador] = array[j][array.length - (filas + 1)/2];
                        contador++;
                    }
                } else {//columnas de la izquierda
                    for(int j = array.length - filas /2 - 1 ; j > filas/2 - 1; j--){
                        arr[contador] = array[j][filas/2 - 1];
                        contador++;
                    }
                }
            }
        }
      return arr;
   } 
}

    last month
    Refactor
    Discuss

public class Snail {

    public static int[] snail(int[][] array) {
        
        if(array.length == 0|| array == null || array[0].length == 0){
          int[] arr = new int[0];
          return arr;
        }
      
        int arr[] = new int[array.length * array[0].length];// el array que estamos rellenando tendra una longitud de todas las posiciones dentro del array bidimensional
        int filas = 0;//esta variable nos permitira controlar la posicion en que nos encotnramos
        int longitud = arr.length/2;// esta variable nos permitre controlar el numero de giros que tenemos que dar
        int contador = 0;// esta variable nos permitira llevar la cuenta del indice del array que estamos rellenando
        if(arr.length % 2 != 0){
            longitud++;
        }
        /*La lógica es la siguiente: el patrón es que tras cada rotación par(teniendo en cuenta que empezamos por 0 y contamos 0 como par)
        la cantidad de casillas que recorremos se reduce en 1, para eso utilizamos la variable filas*/
        for(int i = 0; i <= longitud ; i++){
            /*El problema esta en que cada vez  que volvemos a una misma posición la variable filas habra aumentado en 2, sin embargo, por el lado
            en que nos encontramos nosotros solo lo habrá hecho en 1, por eso jugaremos con la variable filas dividiendola entre 2 para tener en cuenta
            las casillas ocupadas en el otro lado de la matriz*/
            if (i % 2 == 0){
                if(i % 4 == 0){//filas de arriba
                    for (int j = filas/2 ; j < array.length - (filas/2) ; j++){//filas/2 en rotaciones(1 = 0, 2 = 1, 3 = 2)
                        arr[contador] = array[filas/2][j];
                        contador++;
                    }
                    
                } else {//filas de abajo
                    for(int j = array.length - (filas + 1) /2 -1; j >= filas/2 ; j--){
                        arr[contador] = array[array.length - (filas/2) - 1][j];
                        contador++;
                    }
                }
                filas++;

            } else {
                if((i-1) % 4 == 0){//columnas de la derecha
                    for (int j = (filas + 1)/2 ; j <= array.length - (filas + 1)/2  ; j++){
                        arr[contador] = array[j][array.length - (filas + 1)/2];
                        contador++;
                    }
                } else {//columnas de la izquierda
                    for(int j = array.length - filas /2 - 1 ; j > filas/2 - 1; j--){
                        arr[contador] = array[j][filas/2 - 1];
                        contador++;
                    }
                }
            }
        }
      return arr;
   } 
}

    last month
    Refactor
    Discuss

8 kyu
CSV representation of array
Java:

public class Kata {
  public static String toCsvText(int[][] array){
    String s = "";
    for(int i = 0 ; i < array.length ; i++){
      for(int j = 0 ; j < array[i].length ; j++){
        if(j != array[i].length - 1){
          s += "" + array[i][j] + ",";
        }else{
          s += "" + array[i][j];
        }
      }
      if(i != array.length - 1){
          s += "\n";
        }else{
          s += "";
        }
    }
    return s;
  }
}

    10 days ago
    Refactor
    Discuss

5 kyu
First non-repeating character
Java:

import java.util.*;
public class Kata {
  public static String firstNonRepeatingLetter(String s){
    String s2 = s.toLowerCase();
    
    HashMap<Character,Integer> mapa1 = new HashMap<Character,Integer>();
    for(Character c : s2.toCharArray()){
      mapa1.put(c, mapa1.getOrDefault(c, 0) + 1);
    }
    for(int i = 0; i < s.length(); i++){
      if(mapa1.get(s2.charAt(i)) == 1){
        return Character.toString(s.charAt(i));
      }
    }
    return "";
  }
}

    15 days ago
    Refactor
    Discuss

6 kyu
Decode the Morse code
Java:

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
      String s = "";
      String[] morses = morseCode.split("\s");
      for(int i = 0 ; i < morses.length ; i++){
        System.out.println(morses[i]);
        if(morses[i].equals("")){
          s+= " ";
        } else{
          s += MorseCode.get(morses[i]);
        }
        
      }
      return s.replaceAll("( )+"," ").replaceAll("^\s", "");
    }
}

    16 days ago
    Refactor
    Discuss

6 kyu
Basic Encryption
Java:

public class BasicEncrypt {

    public String encrypt(String text, int rule) {
        String s = "";
        while(rule > 255){
            rule -= 256;
          }
        for(int i = 0 ; i < text.length() ; i++){
          int n = (int) text.charAt(i);
          n += rule;
          if(n > 255){
            n -= 256;
          }
          s += Character.toString((char) n);
        }
      return s;
    }
}

    16 days ago
    Refactor
    Discuss

6 kyu
Wave Sorting
Java:

public class WaveSorter {

    public static void waveSort(int[] array) {
        boolean order = false;
        while(!order){
          order = true;
          for(int i = 0 ; i < array.length - 1 ; i++){
            if(i % 2 == 0){
              if(array[i] < array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
              }
            }
            if(i % 2 != 0){
              if(array[i] > array[i + 1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
              }
            }
          }
        }
    }
}

    16 days ago
    Refactor
    Discuss

6 kyu
Delete occurrences of an element if it occurs more than n times
Java:

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

    16 days ago
    Refactor
    Discuss

6 kyu
Count characters in your string
Java:

import java.util.*;

public class Kata {
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> mapa1 = new HashMap<Character,Integer>();
        for(Character c : str.toCharArray()){
          mapa1.put(c, mapa1.getOrDefault(c, 0) + 1);
        }
        return mapa1;
    }
}

    16 days ago
    Refactor
    Discuss

8 kyu
OOP: Object Oriented Piracy
Java:

public class Ship {
  private final double draft;
  private final int crew;
    
  public Ship(double draft, int crew) {
    this.draft = draft;
    this.crew = crew;
  }
  public boolean isWorthIt(){
    double peso = draft;
    double tripulacion = (double)crew;
    peso -= (tripulacion * 1.5);
    if(peso > 20){
      return true;
    }
    return false;
  }
  
} 

    17 days ago
    Refactor
    Discuss

7 kyu
Simple Fun #326: The Shortest Time
JavaScript:

function shortestTime(n,m,speeds){
  if(n === 1){
    return 0;
  }
  let distance = (m - n) * speeds[0];
  distance = distance < 0 ? distance * - 1 : distance;
  let distanceto1 = n - 1;
  let distanceToOnLift = distanceto1 * speeds[0];
  let lift = distance + distanceToOnLift + (2 * speeds[1]) + speeds[2];
  let walk = speeds[3] * distanceto1;

  return lift < walk ? lift : walk;
}

    18 days ago
    Refactor
    Discuss

8 kyu
Basic subclasses - Adam and Eve
Java:

public class Human {
    public String name;

    public Human(String name) {
        this.name = name;
    }

}
class Man extends Human {
        public Man() {
            super("Adam");
        }
    }
class Woman extends Human {
        public Woman() {
            super("Eve");
        }
    }
class God {
  public static Human[] create() {
        Human[] paradise = new Human[2];
        paradise[0] = new Man();
        paradise[1] = new Woman();
        return paradise;
    }  
}

    19 days ago
    Refactor
    Discuss

6 kyu
Pell Numbers
Java:

import java.math.BigInteger;

public class Solution {
  public static BigInteger pell(int n) {
    
    BigInteger n1 = BigInteger.ZERO;
    BigInteger n2 = BigInteger.ONE;
    BigInteger n3 = BigInteger.ZERO;
    BigInteger factor = BigInteger.TWO;
    if(n == 0){
      return n1;
    } else if(n == 1){
      return n2;
    }
    for(int i = 1 ; i < n ; i++){
      n3 = factor.multiply(n2).add(n1);
      n1 = n2;
      n2 = n3;
    }
    return n3;
  }
}

    19 days ago
    Refactor
    Discuss

8 kyu
FIXME: Static electrickery
Java:

public class Dinglemouse {
  
  private static int ONE_HUNDRED = 100;
  private int value; 
  
  private Dinglemouse() {
    value = ONE_HUNDRED;
  }
  public static final Dinglemouse INST = new Dinglemouse();
  
  public int plus100(int n) {
    return value + n;
  }
  
}

    20 days ago
    Refactor
    Discuss

5 kyu
Convert A Hex String To RGB
Java:

import java.util.HashMap;

public class HexToRGB {
  
  public static HashMap<String, Integer> hexStringToRGB(String hex) {
    hex = hex.replace("#", "");
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        String colors = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        String hexa[] = hex.split("");
        int r = ((colors.indexOf(hexa[0]) * 16) + (colors.indexOf(hexa[1])));
        int b = ((colors.indexOf(hexa[4]) * 16) + (colors.indexOf(hexa[5])));
        int g = ((colors.indexOf(hexa[2]) * 16) + (colors.indexOf(hexa[3])));
        System.out.println(r);
        System.out.println(g);
        System.out.println(b);
        map1.put("r", r);
        map1.put("g", g);
        map1.put("b", b);
    
    
    return map1;
  }
  
}

    20 days ago
    Refactor
    Discuss

7 kyu
Alphabet war
Java:

import java.util.*;
public class Kata{
    public static String alphabetWar(String fight){
        int leftAddition = 0;
        int rightAddition = 0;
        System.out.println(fight);
        Character[] left = {'w', 'p', 'b', 's'};
        Character[] right = {'m', 'q', 'd', 'z'};
        HashMap<Character, Integer> mapa1 = new HashMap<Character, Integer>();
        Integer j = 4;
        for(Character s : left){
          mapa1.put(s, j);
          j--;
        }
        j = 4;
        for(Character s : right){
          mapa1.put(s, j);
          j--;
        }

        for(Character c : fight.toCharArray()){
          for(int i = 0 ; i < left.length ; i++){
            if(c == left[i]){
              leftAddition += mapa1.get(c);
            }
            
          }
          for(int i = 0 ; i < right.length ; i++){
            if(c == right[i]){
              rightAddition += mapa1.get(c);
            }
          }
        }
        
        return leftAddition == rightAddition ? "Let's fight again!" : leftAddition > rightAddition ? "Left side wins!" : "Right side wins!";
    }
}

    21 days ago
    Refactor
    Discuss

6 kyu
Alphabet war - airstrike - letters massacre
Java:

import java.util.*;
public class AlphabetWarAirstrike{

  public static String alphabetWar(String fight){

        fight = fight.replaceAll("[a-z]?\\*[a-z]?", "");
        int leftAddition = 0;
        int rightAddition = 0;
        System.out.println(fight);
        Character[] left = {'w', 'p', 'b', 's'};
        Character[] right = {'m', 'q', 'd', 'z'};
        HashMap<Character, Integer> mapa1 = new HashMap<Character, Integer>();
        Integer j = 4;
        for(Character s : left){
          mapa1.put(s, j);
          j--;
        }
        j = 4;
        for(Character s : right){
          mapa1.put(s, j);
          j--;
        }

        for(Character c : fight.toCharArray()){
          for(int i = 0 ; i < left.length ; i++){
            if(c == left[i]){
              leftAddition += mapa1.get(c);
            }
            
          }
          for(int i = 0 ; i < right.length ; i++){
            if(c == right[i]){
              rightAddition += mapa1.get(c);
            }
          }
        }
        
        return leftAddition == rightAddition ? "Let's fight again!" : leftAddition > rightAddition ? "Left side wins!" : "Right side wins!";
  }
}

    21 days ago
    Refactor
    Discuss

6 kyu
Take a Ten Minutes Walk
Java:

import java.util.*;
public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    HashMap <Character, Integer> mapa1 = new HashMap<Character,Integer>();
    for(int i = 0 ; i < walk.length ; i++){
      mapa1.put(walk[i], mapa1.getOrDefault(walk[i], 0) + 1);
    }
    return walk.length == 10 && (mapa1.get('n') == mapa1.get('s') && mapa1.get('w') == mapa1.get('e'));
  }
}

    21 days ago
    Refactor

public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    char[] possibilities = {'n', 'w', 's', 'e'};
    int[] movements = {0, 0, 0, 0};
    for(int i = 0 ; i < walk.length; i++){
      for(int j = 0 ; j < possibilities.length; j++){
        if(walk[i] == possibilities[j]){
          movements[j]++;
          break;
        }
      }
    }
    return walk.length != 10 ? false : movements[0] == movements[2] && movements[1] == movements[3] ? true : false ;
  }
}

    22 days ago
    Refactor
    Discuss

7 kyu
Largest Elements
Java:

public class Solution {
  
   public static int[] largest(int n, int[] arr) {
     boolean order = false;
     while(!order){
       order = true;
       for(int i = 0 ; i < arr.length - 1 ; i++){
         if(arr[i] > arr[i + 1]){
           int temp = arr[i];
           arr[i] = arr[i + 1];
           arr[i + 1] = temp;
           order = false;
         }
       }
     }
     int array[] = new int[n];
     for(int i = 0 ; i < array.length ; i++){
       array[i] = arr[arr.length + i - n]; 
     }
     return array;
   }
}

    22 days ago
    Refactor
    Discuss

8 kyu
The Feast of Many Beasts
Java:

public class Kata {

  public static boolean feast(String beast, String dish) {
    if(beast.charAt(0) == dish.charAt(0) && beast.charAt(beast.length()-1) == dish.charAt(dish.length() - 1)){
      return true;
    }
    return false;
    
  }
  
}
  

    22 days ago
    Refactor
    Discuss

7 kyu
Credit Card Mask
Java:

public class Maskify {
    public static String maskify(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
}

    22 days ago
    Refactor
    Discuss

8 kyu
All Star Code Challenge #18
Java:

public class CodeWars {
  public static int strCount(String str, char letter) {
    int count = 0;
    for(int i = 0 ; i < str.length() ; i++){
      if(str.charAt(i) == letter){
        count++;
      }
    }
    return count;
  }
}

    22 days ago
    Refactor

7 kyu
Product Array (Array Series #5)
Java:

public class Solution
{
    public static long[] productArray(int[] numbers)
    {
        long[] array = new long[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
          long product = 1;
          for (int j = 0 ; j < array.length ; j++){
            if(i == j){
              continue;
            }else{
              product *= numbers[j];
            }
          }
          array[i] = product;
        }
        return array; // Do your magic!
    }
}

    22 days ago
    Refactor
    Discuss

7 kyu
Leap Years
Java:

public class LeapYears {

  public static boolean isLeapYear(int year) {
    if(year % 400 == 0){
      return true;
    }else if(year % 100 == 0){
      return false;
    } else if(year % 4 == 0){
      return true;
    }
    return false;
}
  }

    22 days ago
    Refactor
    Discuss

6 kyu
Clocky Mc Clock-Face
Java:

import java.util.*;
public class Dinglemouse {

  public static String whatTimeIsIt(final double angle) {    
    int hora = (int) (angle / 30);
    int minuto = (int) ((angle - (30 * hora)) * 2);
    String horaFinal = hora < 10 ? "0" + hora : Integer.toString(hora);
    if(horaFinal.equals("00")){
      horaFinal = "12";
    }
    String minutoFinal = minuto < 10 ? "0" + minuto : Integer.toString(minuto);
    return horaFinal + ":" + minutoFinal;
  }

}

    22 days ago
    Refactor
    Discuss

4 kyu
Codewars style ranking system
Java:

// TODO: create the User class/object
// it must support rank, progress, and the incProgress(int rank) method

class User {
  private int[] ranks ={-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};
  private int i = 0;
  public int rank = ranks[i];
  public int progress = 0;
  
  public User(){
    
  }
  public int getRank(){
    return rank;
  }
  public int getProgress(){
    return progress;
  }
  public int setRank(){
    rank = ranks[this.i];
    return capRank(this.i);
  }
  public int incProgress(int activityRank){
    
    if(!rangoValido(activityRank)){
      throw new IllegalArgumentException("Rango no valido");
    }
    int index= activityRank + 8;
    
    if(activityRank >= 0){
      index--;
    }
    
    if(this.rank == ranks[index]){
      
      progress += 3;
      
    }else if (index < 15 && this.rank == ranks[index + 1] ){
      progress++;
    } 
    else if(this.rank < ranks[index]){
      
      int calc = this.rank - ranks[index];
      if(activityRank >= 0 && rank < 0){
        calc++;
      }
      
      progress += (10 * (int) (Math.pow(calc, 2)  ));
    }else{
      progress = progress;
    }
    while(progress >= 100){
      i++;
      progress -= 100;
    }
    this.rank = setRank();
    System.out.println(rank + " " +progress);
    if(rank == 8){
      progress = 0;
    }
    return progress;
    }
  
  public int capRank(int i){
    return i >= ranks.length ? ranks[ranks.length - 1] : ranks[i];
  }
  public boolean rangoValido(int rank) {
        for (int index = 0; index < ranks.length; index++) {
            if (ranks[index] == rank) {
                return true;
            }
        }
        return false;
    }
  
}

    22 days ago
    Refactor
    Discuss

6 kyu
Find the missing letter
Java:

public class Kata
{
  public static char findMissingLetter(char[] array)
  {
    
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int start = abc.indexOf(Character.toString(array[0]).toUpperCase());
    for(int i = 0 ; i < array.length ; i++){
        System.out.print(Character.toString(array[i]).toUpperCase());
        System.out.print("");
        System.out.print(abc.charAt(start + i));
        if(Character.toString(array[i]).toUpperCase().equals(Character.toString(abc.charAt(start + i)))){
          
          
        }else{
          if(Character.isLowerCase(array[i])){
            
            String s = Character.toString(abc.charAt(start + i));
            return Character.toLowerCase(abc.charAt(start + i));
          }
          return abc.charAt(start + i);
        }
    }
    return ' ';
  }
}

    23 days ago
    Refactor
    Discuss

7 kyu
80's Kids #2: Help ALF Find His Spaceship
Java:

public class EightiesKids2 {

  public static String findSpaceship(String map) {
    String location = "";
    int x = 0;
    int y = 0;
    String[] mapa = map.split("\n");
    for(int i = 0 ; i < mapa.length ; i++){
      for(int j = 0 ; j < mapa[i].length() ; j++){
        if(mapa[i].charAt(j) == 'X'){
          x = mapa.length - 1 - i;
          y = j;
          return "[" + y + ", " + x +"]";
        }
      }
    }
    return "Spaceship lost forever.";
  }
}

    23 days ago
    Refactor
    Discuss

5 kyu
Connect 4
Java:

import java.util.*;
public class Connect4 {
  int[][] board = new int[6][7];
  
  boolean player = false;
	public String play(int column) {
    
    player = player ? false : true;
    
    if(ganador(board)){
      return "Game has finished!";
    }

      int casilla = board.length - 1;                                                                     //Comprobamos si la columna existe, y en ese caso
                                                                   //si estuviera llena, en ese caso daremos un
            while(casillaOcupada(board, casilla, column)){                                                     //mensaje de error y pediremos que nos introduzca una columna valida
                casilla--;
                if(casilla < 0){
                    player = player ? false : true;
                    return "Column full!";
                }
            }
      board[casilla][column] = player ? 1 : 2;
      if(!ganador(board)){
        return player ? "Player 1 has a turn" : "Player 2 has a turn";
      }
    return player ? "Player 1 wins!" : "Player 2 wins!"; 
  }
  static boolean victoria(int a, int b, int c, int d){            // esta función nos servirá para comprobar si se cumplen
        return a == b && a == c && a ==d;
    }
    static boolean ganador(int board[][]){                                   //esta función nos servirá para determinar si se ha dado o no un ganador
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                if(j < 4){
                    if(victoria(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]) //comprobamos filas
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3){
                    if(victoria(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]) //comprobamos columnas
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j < 4){
                    if(victoria(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]) //comprobamos diagonales de izquierda a derecha
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j > 2){
                    if(victoria(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]) //comprobamos diagonales de derecha a izquierda
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(empate(board)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean empate(int board[][]){
        for(int i = 0; i < board.length; i++){              //comprobamos la posibilidad de que alla un empate,
            for (int j = 0; j < board[i].length ; j++){     //si una casilla esta vacia retornara directamente falso, 
                if(!casillaOcupada(board, i, j)){           //en caso contrario verdadero
                    return false;
                }
            }
        }
        return true;
    }
  static boolean casillaOcupada(int board[][], int i, int j){  //comprobamos si la casilla esta ocupada ya o no
        return board[i][j] != 0;
    }
}

    23 days ago
    Refactor
    Discuss

7 kyu
80's Kids #1: How Many Licks Does it Take?
Java:

import java.util.Map;

public class EightiesKids1 {

  public static String totalLicks(Map<String, Integer> env) {
    int licks = 252;
    int mayor = Integer.MIN_VALUE;
    String max = "";
    for(Map.Entry<String,Integer> entrada: env.entrySet()){
      if(entrada.getValue() > mayor){
        mayor = entrada.getValue();
        max = entrada.getKey();
      }
      licks += entrada.getValue();
    }
    
    return mayor > 0 ? "It took " + licks + " licks to get to the tootsie roll center of a tootsie pop. The toughest challenge was " + max + "."
      : "It took " + licks + " licks to get to the tootsie roll center of a tootsie pop.";
  }
}

    23 days ago
    Refactor
    Discuss

6 kyu
Emotional Sort ( ︶︿︶)
Java:

import java.util.*;
public class Solution {

    public static String[] sortEmotions(boolean order,String[] emotions) {
        String[] array = {":D", ":)", ":|", ":(", "T_T"};
        HashMap<String, Integer> mapa1 = new HashMap<String,Integer>();
      Integer i = 1;
      for(String s: array){
        mapa1.put(s, i);
        i++;
      }
      boolean ordered = false;
      while(!ordered){
        ordered = true;
        for(int j = 0 ; j < emotions.length - 1; j++){
          if(mapa1.get(emotions[j + 1]) < mapa1.get(emotions[j])){
            String temp = emotions[j + 1];
            emotions[j + 1] = emotions[j];
            emotions[j] = temp;
            ordered = false;
          }
        }
      }
      if(!order){
        String[] ascendingOrder = new String[emotions.length];
        for(int j = emotions.length - 1 ; j >= 0; j--){
          ascendingOrder[emotions.length - 1 - j] = emotions[j];
        }
        emotions = ascendingOrder;
      }
      for(int j = 0 ; j < emotions.length ; j++){
        System.out.println(emotions[j]);
      }
      
        return emotions;
    }

}

    23 days ago
    Refactor
    Discuss

7 kyu
Product Of Maximums Of Array (Array Series #2)
Java:

import java.util.*;
public class Solution
{
    public static long maxProduct(int[] numbers, int sub_size)
    {
      long producto = 1 ;
        Arrays.sort(numbers);
      for (int i = numbers.length - 1 ; i >= numbers.length - sub_size ; i--){
        producto *= numbers[i];
      }
        return producto;
    }
}

    24 days ago
    Refactor
    Discuss

6 kyu
Equal Sides Of An Array
Java:

public class Kata {
  public static int findEvenIndex(int[] arr) {
    for(int i = 0 ; i < arr.length ; i++){
      int right = 0;
      int left= 0;
      for(int j = i - 1 ; j >= 0; j--){
        right += arr[j];
      }
      for(int j = i + 1 ; j < arr.length ; j++){
        left += arr[j];
      }
      if(right == left){
        return i;
      }
      
    }
    return -1;
  }
}

    24 days ago
    Refactor
    Discuss

5 kyu
Not very secure
Java:

public class SecureTester{
  
  public static boolean alphanumeric(String s){
    return s.matches("[A-Za-z\\d]+");
  }

}

    25 days ago
    Refactor
    Discuss

6 kyu
Sort the odd
Java:


public class Kata {
  public static int[] sortArray(int[] array) {
    boolean ordenado = false;
    while(!ordenado){
      ordenado = true;
      for(int i = 0; i < array.length - 1 ; i++){
        if(array[i] % 2 == 0){
          continue;
        }
        for(int j = i + 1 ; j < array.length ; j++){
          if(array[j] % 2 == 0){
            continue;
          }
          if(array[j] < array[i]){
            int a = array[i];
            array[i] = array[j];
            array[j] = a;
            ordenado = false;
            break;
          }
        }
      }
    }
    return array;
  }
}

    26 days ago
    Refactor

6 kyu
Is a number prime?
Java:

public class Prime {
  public static boolean isPrime(int num) {
    if(num <= 0 || num == 1){
      return false;
    }
    for(int i = 2 ; i <= (int) (Math.sqrt(num)); i++){
      if(num % i == 0){
        return false;
      }
    }
    return true; 
  }
}

    26 days ago
    Refactor
    Discuss

8 kyu
Convert a Number to a String!
Java:

class Kata {
  public static String numberToString(int num) {
    return Integer.toString(num);
  }
}

    27 days ago
    Refactor
    Discuss

4 kyu
Shortest Knight Path
Java:

import java.util.*;

public class Chess {

    public static int knight(String start, String finish) {
        String[][] board = new String[8][8];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], " ");
        }

        HashMap<String, Integer> conversion = new HashMap<String, Integer>();
        int n = (int) 'a';
        for (Integer i = 0; i < 8; i++) {
            char c = (char) n;
            String s = Character.toString(c);
            conversion.put(s, i);
            n++;
        }

        int letraStart = conversion.get(Character.toString(start.charAt(0)));
        int numeroStart = Integer.parseInt(start.substring(1, 2)) - 1;
        int letraFinish = conversion.get(Character.toString(finish.charAt(0)));
        int numeroFinish = Integer.parseInt(finish.substring(1, 2)) - 1;
        board[letraStart][numeroStart] = "C";

        int[][] posibilidades = {{-2, 1, -1, 2, -2, 1, -1, 2},
                {1, -2, 2, -1, -1, 2, -2, 1}};

        int cuenta = 0;

        while (!board[letraFinish][numeroFinish].equals("C")) {
            int[][] temporal = new int[8][8];

            boolean movimiento = false;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals("C")) {
                        for (int k = 0; k < 8; k++) {
                            int nuevaLetra = i + posibilidades[0][k];
                            int nuevoNumero = j + posibilidades[1][k];

                            if (posibleMovimiento(board, nuevaLetra, nuevoNumero)) {
                                temporal[nuevaLetra][nuevoNumero] = 1;
                                movimiento = true;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (temporal[i][j] == 1) {
                        movimientoCaballo(board, i, j);
                    }
                }
            }

            if (!movimiento) {
                break;
            }

            cuenta++;
        }
        return cuenta;
    }

    static boolean dentroLimites(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    static boolean posibleMovimiento(String board[][], int i, int j) {
        return dentroLimites(i, j) && (board[i][j].equals(" ") || board[i][j].equals("C"));
    }

    static String movimientoCaballo(String board[][], int i, int j) {
        return board[i][j] = "C";
    }
  }

    27 days ago
    Refactor
    Discuss

3 kyu
Prime Streaming (PG-13)
Java:

import java.util.stream.IntStream;


public class Primes {
  public static IntStream stream() {
    return IntStream.iterate(2, i -> siguientePrimo(i));
  }
  static int siguientePrimo(int n){
    do{
      n++;
    } while(!esPrimo(n));
    return n;
  }
  static boolean esPrimo(int n){
    for(int i = 2 ; i <= (int)(Math.sqrt(n)); i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }
}

    27 days ago
    Refactor
    Discuss

3 kyu
Battleship field validator
Java:

public class BattleField {
    
    public static boolean fieldValidator(int[][] field) {
    
        int battleship = 0;
        int cruisers = 0;
        int destroyers = 0;
        int submarines = 0;
      
        for(int k = 0 ; k < 4 ; k++){
          if(k == 0){
            for(int i = 0 ; i < field.length ; i++){
              for (int j = 0 ; j < field[i].length ; j++){
                if(i < 7){//check for battleships vertical
                  if(!Zero(field[i][j]) && equal(field[i][j], field[i + 1][j], field[i + 2][j], field[i + 3][j])){
                    battleship++;
                    field[i][j] = -1;
                    field[i + 1][j] = -1;
                    field[i + 2][j] = -1;
                    field[i + 3][j] = -1;
                    if(adjacent(field)){
                      return false;
                    }
                  }
                }
                if(j < 7){//check for battleships horizontal
                  if(!Zero(field[i][j]) && equal(field[i][j], field[i][j + 1], field[i][j + 2], field[i][j + 3])){
                    battleship++;
                    field[i][j] = -1;
                    field[i][j + 1] = -1;
                    field[i][j + 2] = -1;
                    field[i][j + 3] = -1;
                    if(adjacent(field)){
                      return false;
                    }
                  }
                }
              }
            }
          }
          if(k == 1){//check for cruisers vertical
            for(int i = 0 ; i < field.length ; i++){
              for (int j = 0 ; j < field[i].length ; j++){
                if(i < 8){
                  if(!Zero(field[i][j]) && equal(field[i][j], field[i + 1][j], field[i + 2][j])){
                    cruisers++;
                    field[i][j] = -1;
                    field[i + 1][j] = -1;
                    field[i + 2][j] = -1;
                    if(adjacent(field)){
                      return false;
                    }
                  }
                }
                if(j < 8){//check for cruisers horizontal
                  if(!Zero(field[i][j]) && equal(field[i][j], field[i][j + 1], field[i][j + 2])){
                    cruisers++;
                    field[i][j] = -1;
                    field[i][j + 1] = - 1;
                    field[i][j + 2] = - 1;
                    if(adjacent(field)){
                      return false;
                    }
                  }
                }
              }
            }
          }
          if(k == 2){//check for destroyers vertical
            for(int i = 0 ; i < field.length ; i++){
            for (int j = 0 ; j < field[i].length ; j++){
              if(i < 9){
                if(!Zero(field[i][j]) && equal(field[i][j], field[i + 1][j])){
                  destroyers++;
                  field[i][j] = -1;
                  field[i + 1][j] = -1;
                  if(adjacent(field)){
                    return false;
                  }
                } 
              }
              if(j < 9){//check for destroyers horizontal
                if(!Zero(field[i][j]) && equal(field[i][j], field[i][j + 1])){
                  destroyers++;
                  field[i][j] = -1;
                  field[i][j + 1] = -1;
                  if(adjacent(field)){
                    return false;
                  }
                }
              }
            }
          }
        }
        if(k == 3){//check for submarines
          for(int i = 0 ; i < field.length ; i++){
            for(int j = 0 ; j < field[i].length ; j++){
              if(field[i][j] == 1){
                submarines++;
                field[i][j] = -1;
                if(adjacent(field)){
                  return false;
                }
              }
            }
          }
        }
      }
        if(battleship == 1 && cruisers == 2 && destroyers == 3 && submarines == 4){
          return true;
        }
        return false;
    }
  
  static boolean equal(int a, int b){
    return a == 1 && b == 1;
  }
  static boolean equal(int a, int b, int c){
    return a == 1 && b == 1 && c == 1;
  }
  static boolean equal(int a, int b, int c, int d){
    return a == 1 && b == 1 && c == 1 && d == 1;
  }
  static boolean Zero(int a){
    return a == 0 || a == -1;
  }
  static boolean correctField(int field[][], int i, int j){
    if(i < 10 && i >= 0 && j >= 0 && j < 10){
      return true;
    }
    return false;
  }
  static boolean adjacent(int field[][]){
    for(int i = 0; i < field.length ; i++){
      for(int j = 0 ; j < field[i].length ; j++){
        if(field[i][j] == -1){
          for(int x = -1 ; x <= 1 ; x++){
            for(int y = -1 ; y <= 1 ; y++){
              if(x != 0 || y != 0){
                int ejeI = i + x;
                int ejeJ = j + y;
                if((x != 0 && y != 0) && correctField(field, ejeI, ejeJ)&& field[ejeI][ejeJ] ==   1){
                  return true;
                }
              }
            }
          }
        }
        
      }
    }
    return false;
  }
}

    28 days ago
    Refactor
    Discuss

4 kyu
Human readable duration format
Java:

public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        if(seconds == 0 ){
          return "now";
        }
        int years = 0, days = 0, hours = 0, minute = 0, second = 0;
        for(int i = 0 ; i < seconds ; i++){
          second++;
          if(second > 59){
            minute++;
            second = 0;
          }
          if(minute > 59){
            hours++;
            minute = 0;
          }
          if(hours > 23){
            days++;
            hours = 0;
          }
          if(days > 364){
            years++;
            days = 0;
          }
        }
       System.out.println(segundos(second));
       String respuesta = años(years) + dias(days) + horas(hours) + minutos(minute) + segundos(second);
      System.out.println(respuesta);
      respuesta = respuesta.trim();
      String respostaFinal = "";
      String paraules[] = respuesta.split(" ");
      int[] datos = {years, days, hours, minute, second};
      for(int i = 0 ;  i < datos.length ; i++){
        if(datos[i] != 0){
          respostaFinal += datos[i] + " " + paraules[i] + ", ";
        }
      }
      respostaFinal = respostaFinal.trim().replaceAll(",$", "");
      
      respostaFinal = respostaFinal.replaceAll(",(?!.*,)", " and ").replaceAll("( )+", " ");
      
      return respostaFinal;
    }
    static String años(int years){
      if (years == 0){
        return ". ";
      }
      return years == 1 ? "year " : "years ";
    }
    static String dias(int days){
      if (days == 0){
        return ". ";
      }
      return days == 1 ? "day " :"days ";
    }static String horas(int hours){
      if (hours == 0){
        return ". ";
      }
      return hours == 1 ? "hour " : "hours ";
    }static String minutos(int minute){
      if(minute == 0){
        return ". ";
      }
      return minute == 1 ? "minute " : "minutes ";
    }static String segundos(int seconds){
      if(seconds == 0){
        return ".";
      }
      return seconds == 1 ? "second" : "seconds";
    }
}

    29 days ago
    Refactor

6 kyu
Pascal's Triangle
Java:

public class PascalsTriangle {
    public static long[] generate(int level) {
        int l = level;
        long array[] = new long[sumatorio(l)];
        int index = 0;
        for(int i = 0 ; i < l ; i++){
            for (int j = 0 ; j <= i ; j++){
                array[index++] = triangle(i,j);
                
            }
        }
      return array;
    }
      static int sumatorio(int n){
        for(long i = n - 1; i >= 1 ; i--){
            n += i;
        }
        return n ;
    }
    
    static long triangle(int n, int n2) {
        long resultado = 1;
        for (int i = 1; i <= n2; i++) {
            resultado = resultado * (n - i + 1) / i;
        }
        return resultado;
    }
}

    29 days ago
    Refactor
    Discuss

6 kyu
Count the divisible numbers
Java:

public class Kata {

  public static long divisibleCount(long x, long y, long k) {
    long count = 0;
    if (x % k != 0) {
            x += k - (x % k);
        }
        if (x <= y) {
            count = (y - x) / k + 1;
        }
    return count;
  }  
}

    29 days ago
    Refactor
    Discuss

6 kyu
Ping Pong
Java:

public class Dinglemouse {

  public static String pingPong(String sounds) {

       int ping = 0;
        int pong = 0;
        String rally[] = sounds.split("-");
        for(int i = 0 ; i < rally.length ; i++){
            if(rally[i].equals("ping")){
                while(rally[i].equals("ping") || rally[i].equals("pong")){
                    i++;
                }
                if(!rally[i - 1].equals("ping")){
                    ping++;
                }
            }
            if(rally[i].equals("pong")){
                while(rally[i].equals("ping") || rally[i].equals("pong")){
                    i++;
                }
                if(!rally[i - 1].equals("pong")){
                    pong++;
                }
            }
        }
        
        int ganaPing = sounds.lastIndexOf("ping");
        int ganaPong = sounds.lastIndexOf("pong");
    
    System.out.println(ping + " " + pong);   
    if(ping == pong){
            return ganaPing < ganaPong ? "ping" : "pong";
        }
       
    return ping < pong ? "pong" : "ping"; // or "pong"
  }
  
}

    29 days ago
    Refactor
    Discuss

6 kyu
Good vs Evil
Java:

public class GoodVsEvil {
  public static String battle(String goodAmounts, String evilAmounts) {
    String[] goods = goodAmounts.split(" ");
    String[] evils = evilAmounts.split(" ");
    int good = 0;
    int evil = 0;
    for(int i = 0 ; i < goods.length ; i++){
      if(i == 0){
        good += Integer.parseInt(goods[i]);
      }else if(i == 1){
        good += Integer.parseInt(goods[i]) * 2;
      }else if(i == 2){
        good += Integer.parseInt(goods[i]) * 3;
      }else if(i == 3){
        good += Integer.parseInt(goods[i]) * 3;
      }else if(i == 4){
        good += Integer.parseInt(goods[i]) * 4;
      }else if(i == 5){
        good += Integer.parseInt(goods[i]) * 10;
      }
      
    }
    for(int i = 0 ; i < evils.length ; i++){
      if(i == 0){
        evil += Integer.parseInt(evils[i]);
      } else if(i == 1){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 2){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 3){
        evil += Integer.parseInt(evils[i]) * 2;
      } else if(i == 4){
        evil += Integer.parseInt(evils[i]) * 3;
      } else if(i == 5){
        evil += Integer.parseInt(evils[i]) * 5;
      } else if(i == 6){
        evil += Integer.parseInt(evils[i]) * 10;
      }
    }
    System.out.println("Good: " + good + " evil: " + evil);
    return good == evil ? "Battle Result: No victor on this battle field" : good > evil ? "Battle Result: Good triumphs over Evil" : "Battle Result: Evil eradicates all trace of Good";
  }
}

    29 days ago
    Refactor
    Discuss

7 kyu
Monty Hall Problem
Java:

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

    29 days ago
    Refactor
    Discuss

7 kyu
Two fighters, one winner.
Java:

public class Kata {
  public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
    boolean player1 = firstAttacker.equals(fighter1.name) ? false : true;
    while(fighter1.health > 0 && fighter2.health > 0){
      player1 = player1 ? false : true;
      if(player1){
        fighter2.health -= fighter1.damagePerAttack;
      }else{
        fighter1.health -= fighter2. damagePerAttack;
      }
    }
    return player1 ? fighter1.name : fighter2.name;
    
    
}
  }

    29 days ago
    Refactor
    Discuss

6 kyu
Array.diff
Java:

import java.util.*;
public class Kata {

  public static int[] arrayDiff(int[] a, int[] b) {
    int[] arrayAux = new int[a.length];
    int cuenta = 0;
    for (int i = 0 ; i < a.length ; i++){
      boolean encontrado = false;
      for(int j = 0 ; j < b.length ; j++){
        if(a[i] == b[j]){
          encontrado = true;
          break;
        }
      }
      if(!encontrado){
        arrayAux[cuenta] = a[i];
        cuenta++;
      }
    }
    int array[]  = new int[cuenta];
    for (int i = 0 ; i < array.length ; i++){
      array[i]=arrayAux[i];
    }
    return array;
  }

}

    29 days ago
    Refactor
    Discuss

4 kyu
The Greatest Warrior
Java:

import java.util.*;
class Warrior {
    String[] ranks = {"Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest"};
    public String name;
    private int experience = 100;
    private int level = experience/100;
    private String rank = ranks[0];
    private ArrayList<String> achievements = new ArrayList<String>();
    public Warrior(){
      
    }
    public Warrior(String name, int level, int experience){
        this.name = name;
        this.level = setLevel(experience);
        this.rank = ranks[setRank(level)];
    }
    public int level(){
      return level;
    }
    public int experience(){
      return experience;
    }
    public String rank(){
      return rank;
    }
    public ArrayList<String> achievements(){
      return achievements;
    }
  
    int setLevel(int experience){
        return experience/100;
    }
    int setRank(int level){
      return level/10;
    }
    int capLevel(int level){
        if(level > 100){
          return 100;
        }
        return level;
    }
    int capExperience(int experience){
      if(experience > 10000){
        return 10000;
      }
      return experience;
    }
    public String battle(int enemyLevel){
        int levelDiff = enemyLevel - level;
        if(enemyLevel < 1 || enemyLevel > 100){
            return "Invalid level";
        }
        if(level / 10 < enemyLevel / 10 && levelDiff >= 5){
            return "You've been defeated";
        }
        if(levelDiff == 0){
            this.experience += 10;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        } else if(levelDiff == -1){
            this.experience += 5;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        } else if(levelDiff <= -2){
            this.experience += 0;
        } else if(levelDiff > 0){
            this.experience += 20 * levelDiff * levelDiff;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        }
        return resultado(levelDiff);
    }
    private String resultado(int levelDiff){
        if(levelDiff <= -2){
            return "Easy fight";
        } else if (levelDiff > 0){
            return "An intense fight";
        } 
        return "A good fight";
    }
    public String training(String description, int experienceEarned, int minLevel){
        int levelDiff = level - minLevel;
        if(levelDiff >= 0){
            experience += experienceEarned;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
            achievements.add(description);
            return description;
        }else{
            
        }
        return "Not strong enough";
    }
    public int subirNivel(){
      return experience / 100;
    }
    public int subirRank(){
      return level/10;
    }
}

    29 days ago
    Refactor
    Discuss

6 kyu
Spelling Bee
Java:

public class Dinglemouse {

    public static int howManyBees(final char [][] hive) {
      if(hive ==null)
        {
        return 0;
      }
      int bees = 0;
      for(int i = 0 ; i < hive.length ; i++){
        for(int j = 0 ; j < hive[i].length ; j++){
          if(i <= hive.length - 3){
            if(bee(hive[i][j], hive[i + 1][j], hive[i + 2][j])){
              bees++;
            }
          }
          if(j <= hive[i].length - 3){
            if(bee(hive[i][j], hive[i][j + 1], hive[i][j + 2])){
              bees++;
            }
          }
        }
      }
      return bees;
    }
    static boolean bee(char a, char b, char c){
      return (a == 'b' && b == 'e' && c == 'e') || (a == 'e' && b == 'e' && c == 'b');
    }
}

    last month
    Refactor
    Discuss

7 kyu
Square Every Digit
Java:

public class SquareDigit {

  public int squareDigits(int n) {
    String s = Integer.toString(n);
    String s2 = "";
    for(int i = 0 ; i < s.length() ; i++){
      int n2 = Integer.parseInt(Character.toString(s.charAt(i)));
      n2 *= n2;
      s2 += Integer.toString(n2);
    }
    return Integer.parseInt(s2);
  }

}

    last month
    Refactor
    Discuss

6 kyu
Mexican Wave
Java:

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

    last month
    Refactor
    Discuss

6 kyu
Split Strings
Java:

public class StringSplit {
    public static String[] solution(String s) {
        int longitud = s.length() / 2;
        if(s.length() % 2 != 0){
          longitud++;
        }
        String[] array = new String[longitud];
        for(int i = 0 ; i < s.length() ; i+=2){
          if(i == s.length() - 1){
            array[i/2] = Character.toString(s.charAt(i)) + "_";
          }else{
            array[i/2] = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i + 1));  
          }
          
        }
      for (int i = 0 ; i < array.length ; i++){
        System.out.println(array[i]);
      }
      return array;
    }
}

    last month
    Refactor
    Discuss

6 kyu
Simple Fun #158: Not So Random
Java:

class Kata {
  public static String notSoRandom(int b, int w) {
    if(b % 2 != 0){
      return "Black";
    }
    return "White";
  }
}

    last month
    Refactor
    Discuss

6 kyu
Even Fibonacci Sum
Java:

import java.math.BigInteger;
class Kata {
    public static long fibonacci(long max) {
       
        BigInteger maxi = BigInteger.valueOf(max);
        BigInteger suma = BigInteger.ZERO;
        BigInteger n1 = BigInteger.ZERO;
        BigInteger n2 = BigInteger.ONE;
        BigInteger n3 = BigInteger.ZERO;
        while(n2.compareTo(maxi) < 0){
           
            if(n2.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
               suma = suma.add(n2);

            }
           n3 = n1.add(n2);
            n1 = n2;
            n2 = n3;
            
        }
      
      return suma.longValue();
      
    }
}

    last month
    Refactor
    Discuss

6 kyu
Roman Numerals Encoder
Java:

import java.util.*;
public class Conversion {

    public String solution(int n) {
 
      StringBuilder sb = new StringBuilder();
      HashMap<Integer, String> mapFromRoman = new HashMap<Integer,String>();
           mapFromRoman.put(1000, "M");
           mapFromRoman.put(900,"CM");
           mapFromRoman.put(500,"D");
           mapFromRoman.put(400, "CD");
           mapFromRoman.put(100,"C");
           mapFromRoman.put(90, "XC");
           mapFromRoman.put(50,"L");
           mapFromRoman.put(40,"XL");
           mapFromRoman.put(10,"X");
           mapFromRoman.put(9,"IX");
           mapFromRoman.put(5,"V");
           mapFromRoman.put(4,"IV");
           mapFromRoman.put(1,"I");
           while(n - 1000 >= 0){
               n -= 1000;
               sb.append(mapFromRoman.get(1000));
           }
           while(n - 900 >= 0){
               n -= 900;
               sb.append(mapFromRoman.get(900));
           }
           while(n - 500 >= 0){
               n -= 500;
               sb.append(mapFromRoman.get(500));
           }
           while(n - 400 >= 0){
               n -= 400;
               sb.append(mapFromRoman.get(400));
           }
           while(n - 100 >= 0){
               n -= 100;
               sb.append(mapFromRoman.get(100));
           }
           while(n - 90 >= 0){
               n -= 90;
               sb.append(mapFromRoman.get(90));
           }
           while(n - 50 >= 0){
               n -= 50;
               sb.append(mapFromRoman.get(50));
           }
           while(n - 40 >= 0){
               n -= 40;
               sb.append(mapFromRoman.get(40));
           }
           while(n - 10 >= 0){
               n -= 10;
               sb.append(mapFromRoman.get(10));
           }
           while(n - 9 >= 0){
               n -= 9;
               sb.append(mapFromRoman.get(9));
           }
           while(n - 5 >= 0){
               n -= 5;
               sb.append(mapFromRoman.get(5));
           }
           while(n - 4 >= 0){
               n -= 4;
               sb.append(mapFromRoman.get(4));
           }
           while(n - 1 >= 0){
               n -= 1;
               sb.append(mapFromRoman.get(1));
           }
           String romanNumber = sb.toString();
    return romanNumber;
}
  }

    last month
    Refactor
    Discuss

6 kyu
Multiplication table
Java:

public class Multiplication{
  public static int [][] multiplicationTable(int n){
    int[][] array = new int[n][n];
    for(int i = 0 ; i < array.length ; i++){
      for (int j = 0 ; j < array[i].length ; j++){
        array[i][j] = (i + 1) * (j + 1);
      }
    }
    return array;
  }
}

    last month
    Refactor
    Discuss

5 kyu
Tic-Tac-Toe (3D)
Java:

 import java.util.*;

public class Dinglemouse {

  public static String playOX3D(final List<int[]> moves) {
    String board[][][] = new String[4][4][4];
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                   
                    Arrays.fill(board[i][j] ," ");
                }
            }
            boolean player1 = false;
            int turns = 0;
            for(int i = 0 ; i < moves.size() && !finPartida(board) ; i++){
                
                player1 = player1 ? false : true;
                board[moves.get(i)[0]][moves.get(i)[1]][moves.get(i)[2]] = player1? "O" : "X";
                turns++;

            }
            if(!finPartida(board)){
                return "No winner";
            }
    return empate(board) ? "No winner" : player1 ? "O wins after " + turns + " moves" : "X wins after " + turns + " moves";
  }
  static boolean equal(String a, String b, String c, String d){
            return a.equals(b) && a.equals(c) && a.equals(d);
        }
        static boolean casillaOcupada(String board[][][], int i, int j, int k){
            return !board[i][j][k].equals(" ");
        }
        static boolean empate(String board[][][]){
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                    for(int k = 0 ; k < board[i][j].length ; k++){
                        if(!casillaOcupada(board, i, j, k)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        static boolean finPartida(String board[][][]){
            for(int i = 0 ; i < board.length ; i++){
                for (int j = 0 ; j < board[i].length ; j++){
                    for(int k = 0 ; k < board[i][j].length ; k++){
                        if(i == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j][k], board[i + 2][j][k], board[i + 3][j][k])){
                                return true;
                            }
                        }
                        if(j == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j + 1][k], board[i][j + 2][k], board[i][j + 3][k])){
                                return true;
                            }
                        }
                        if(k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j][k + 1], board[i][j][k + 2], board[i][j][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && j == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j + 1][k], board[i + 2][j + 2][k], board[i + 3][j + 3][k])){
                                return true;
                            }
                        }
                        if(i == 0 && j == board[i].length - 1){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j - 1][k], board[i + 2][j - 2][k], board[i + 3][j - 3][k])){
                                return true;
                            }
                        }
                        if(i == 0 && j == 0 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j + 1][k + 1], board[i + 2][j + 2][k + 2], board[i + 3][j + 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == board.length - 1 && j == 0 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j + 1][k + 1], board[i - 2][j + 2][k + 2], board[i - 3][j + 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && j == board.length - 1 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j - 1][k + 1], board[i + 2][j - 2][k + 2], board[i + 3][j - 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == board.length - 1 && j == board.length - 1 && k == 0){
                            if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j - 1][k + 1], board[i - 2][j - 2][k + 2], board[i - 3][j - 3][k + 3])){
                                return true;
                            }
                        }
                        if(i == 0 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i + 1][j][k + 1], board[i + 2][j][k + 2], board[i + 3][j][k + 3])){
                                return true;
                          }
                        }
                        if(i == board.length - 1 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i - 1][j][k + 1], board[i - 2][j][k + 2], board[i - 3][j][k + 3])){
                                return true;
                          }
                        }
                        if( j == 0 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j + 1][k + 1], board[i][j + 2][k + 2], board[i][j + 3][k + 3])){
                                return true;
                          }
                        }
                        if(j == board.length - 1 && k == 0){
                          if(casillaOcupada(board, i, j, k) && equal(board[i][j][k], board[i][j - 1][k + 1], board[i][j - 2][k + 2], board[i][j - 3][k + 3])){
                                return true;
                          }
                        }
                }
              }
            }
            if(empate(board)){
                return true;
            }
            return false;
    }
  }

    last month
    Refactor
    Discuss

6 kyu
Sum of prime-indexed elements
Java:

class Solution{
    public static int solve(int [] arr){  
      int suma = 0;  
      for(int i = 0; i < arr.length ; i++){
        if(i > 1 && isPrime(i)){
          suma += arr[i];
        }
      }
      return suma;
    }    
    static boolean isPrime(int n){
      for(int i = 2 ; i <= Math.sqrt(n) ; i++){
        if(n % i == 0){
          return false;
        }
      }
      return true;
    }
}

    last month
    Refactor
    Discuss

4 kyu
Roman Numerals Helper
Java:

import java.util.*;

public class RomanNumerals {
 
  public static String toRoman(int n) {
     HashMap<Integer, String> mapFromRoman = new HashMap<Integer,String>();
           StringBuilder sb = new StringBuilder();
           mapFromRoman.put(1000, "M");
           mapFromRoman.put(900,"CM");
           mapFromRoman.put(500,"D");
           mapFromRoman.put(400, "CD");
           mapFromRoman.put(100,"C");
           mapFromRoman.put(90, "XC");
           mapFromRoman.put(50,"L");
           mapFromRoman.put(40,"XL");
           mapFromRoman.put(10,"X");
           mapFromRoman.put(9,"IX");
           mapFromRoman.put(5,"V");
           mapFromRoman.put(4,"IV");
           mapFromRoman.put(1,"I");
           while(n - 1000 >= 0){
               n -= 1000;
               sb.append(mapFromRoman.get(1000));
           }
           while(n - 900 >= 0){
               n -= 900;
               sb.append(mapFromRoman.get(900));
           }
           while(n - 500 >= 0){
               n -= 500;
               sb.append(mapFromRoman.get(500));
           }
           while(n - 400 >= 0){
               n -= 400;
               sb.append(mapFromRoman.get(400));
           }
           while(n - 100 >= 0){
               n -= 100;
               sb.append(mapFromRoman.get(100));
           }
           while(n - 90 >= 0){
               n -= 90;
               sb.append(mapFromRoman.get(90));
           }
           while(n - 50 >= 0){
               n -= 50;
               sb.append(mapFromRoman.get(50));
           }
           while(n - 40 >= 0){
               n -= 40;
               sb.append(mapFromRoman.get(40));
           }
           while(n - 10 >= 0){
               n -= 10;
               sb.append(mapFromRoman.get(10));
           }
           while(n - 9 >= 0){
               n -= 9;
               sb.append(mapFromRoman.get(9));
           }
           while(n - 5 >= 0){
               n -= 5;
               sb.append(mapFromRoman.get(5));
           }
           while(n - 4 >= 0){
               n -= 4;
               sb.append(mapFromRoman.get(4));
           }
           while(n - 1 >= 0){
               n -= 1;
               sb.append(mapFromRoman.get(1));
           }
           String romanNumber = sb.toString();
    return romanNumber;
  }
  
  public static int fromRoman(String romanNumeral) {
    int numeral = 0;
           HashMap<Character, Integer> mapToRoman = new HashMap<Character,Integer>();
           mapToRoman.put('M' , 1000);
           mapToRoman.put('D', 500);
           mapToRoman.put('C', 100);
           mapToRoman.put('L', 50);
           mapToRoman.put('X', 10);
           mapToRoman.put('V', 5);
           mapToRoman.put('I', 1);
           for(int i = 0 ; i < romanNumeral.length() ; i++){
                if(i == romanNumeral.length() - 1 ){
                   numeral += mapToRoman.get(romanNumeral.charAt(i));
                } else if(mapToRoman.get(romanNumeral.charAt(i)) < mapToRoman.get(romanNumeral.charAt(i + 1))){
                   numeral -= mapToRoman.get(romanNumeral.charAt(i));
                } else{
                   numeral += mapToRoman.get(romanNumeral.charAt(i));
                }
           }
    return numeral;
  }
}

    last month
    Refactor
    Discuss

5 kyu
Count IP Addresses
Java:

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

    last month
    Refactor
    Discuss

6 kyu
Length of missing array
Java:

import java.util.Arrays;
public class Kata
{
  public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
  {
        if(arrayOfArrays == null){
          return 0;
        }
        for(int i = 0; i < arrayOfArrays.length ; i++){
            if(arrayOfArrays[i] == null || arrayOfArrays.length == 0 || arrayOfArrays[i].length == 0){
                return 0;
            }
        }
        int[] lengthArray = new int[arrayOfArrays.length];
        for(int i = 0 ; i < lengthArray.length ; i++){
            lengthArray[i] = arrayOfArrays[i].length;
        }
        int missing = 0;
        Arrays.sort(lengthArray);
        for(int i = 0 ; i < lengthArray.length - 1 ; i++){
            
            if(lengthArray[i] + 1 != lengthArray[i + 1]){
                missing =lengthArray[i] + 1;
                break;
            }
        }
    
    return missing;
  }
}

    last month
    Refactor
    Discuss

7 kyu
Pizza Payments
Java:

public class PizzaPayments {
  public static double michaelPays(double cost) {
    double kate = 0;
        double michael = 0;
        if(cost < 5){
            michael = cost;
        } else{
            kate = cost / 3;
            michael = cost / 3 *2;
            if(kate > 10){
                kate = 10;
                michael = cost - 10;
            }
        }
        michael =(int)(michael * 1000);
        if(michael % 10 >= 5){
            michael+=10;
        }
        michael = (int)(michael/10);

        michael = (double)(michael/100);
    return michael;
  }
}

    last month
    Refactor
    Discuss

7 kyu
Name That Number!
Java:

public class Kata {
  public static String nameThatNumber(int x) {
    int decima = x / 10;
    int unidad = x % 10;
    switch(decima){
        case 0:
          switch(unidad){
              case 0:
                return "zero";
              case 1:
                return "one";
              case 2:
                return "two";
              case 3:
                return "three";
              case 4:
                return "four";
              case 5:
                return "five";
              case 6:
                return "six";
              case 7:
                return "seven";
              case 8:
                return "eight";
              case 9:
                return "nine";
          }
        case 1:
          switch(unidad){
              case 0:
                return "ten";
              case 1:
                return "eleven";
              case 2:
                return "twelve";
              case 3:
                return "thirteen";
              case 4:
                return "fourteen";
              case 5:
                return "fifteen";
              case 6:
                return "sixteen";
              case 7:
                return "seventeen";
              case 8:
                return "eighteen";
              case 9:
                return "nineteen";
          }
        case 2:
          switch(unidad){
              case 0:
                return "twenty";
              case 1:
                return "twenty one";
              case 2:
                return "twenty two";
              case 3:
                return "twenty three";
              case 4:
                return "twenty four";
              case 5:
                return "twenty five";
              case 6:
                return "twenty six";
              case 7:
                return "twenty seven";
              case 8:
                return "twenty eight";
              case 9:
                return "twenty nine";
          }
        case 3:
          switch(unidad){
              case 0:
                return "thirty";
              case 1:
                return "thirty one";
              case 2:
                return "thirty two";
              case 3:
                return "thirty three";
              case 4:
                return "thirty four";
              case 5:
                return "thirty five";
              case 6:
                return "thirty six";
              case 7:
                return "thirty seven";
              case 8:
                return "thirty eight";
              case 9:
                return "thirty nine";
          }
        case 4:
          switch(unidad){
              case 0:
                return "forty";
              case 1:
                return "forty one";
              case 2:
                return "forty two";
              case 3:
                return "forty three";
              case 4:
                return "forty four";
              case 5:
                return "forty five";
              case 6:
                return "forty six";
              case 7:
                return "forty seven";
              case 8:
                return "forty eight";
              case 9:
                return "forty nine";
          }
        case 5:
          switch(unidad){
              case 0:
                return "fifty";
              case 1:
                return "fifty one";
              case 2:
                return "fifty two";
              case 3:
                return "fifty three";
              case 4:
                return "fifty four";
              case 5:
                return "fifty five";
              case 6:
                return "fifty six";
              case 7:
                return "fifty seven";
              case 8:
                return "fifty eight";
              case 9:
                return "fifty nine";
          }
        case 6:
          switch(unidad){
              case 0:
                return "sixty";
              case 1:
                return "sixty one";
              case 2:
                return "sixty two";
              case 3:
                return "sixty three";
              case 4:
                return "sixty four";
              case 5:
                return "sixty five";
              case 6:
                return "sixty six";
              case 7:
                return "sixty seven";
              case 8:
                return "sixty eight";
              case 9:
                return "sixty nine";
          }
        case 7:
          switch(unidad){
              case 0:
                return "seventy";
              case 1:
                return "seventy one";
              case 2:
                return "seventy two";
              case 3:
                return "seventy three";
              case 4:
                return "seventy four";
              case 5:
                return "seventy five";
              case 6:
                return "seventy six";
              case 7:
                return "seventy seven";
              case 8:
                return "seventy eight";
              case 9:
                return "seventy nine";
          }
        case 8:
          switch(unidad){
              case 0:
                return "eighty";
              case 1:
                return "eighty one";
              case 2:
                return "eighty two";
              case 3:
                return "eighty three";
              case 4:
                return "eighty four";
              case 5:
                return "eighty five";
              case 6:
                return "eighty six";
              case 7:
                return "eighty seven";
              case 8:
                return "eighty eight";
              case 9:
                return "eighty nine";
          }
        case 9:
          switch(unidad){
              case 0:
                return "ninety";
              case 1:
                return "ninety one";
              case 2:
                return "ninety two";
              case 3:
                return "ninety three";
              case 4:
                return "ninety four";
              case 5:
                return "ninety five";
              case 6:
                return "ninety six";
              case 7:
                return "ninety seven";
              case 8:
                return "ninety eight";
              case 9:
                return "ninety nine";
          }
    }
    return "";
  }
}

    last month
    Refactor
    Discuss

7 kyu
Walking in the hallway
Java:

import java.util.regex.*;
import java.util.ArrayList;
public class Hallway {
  public static int contact(String hallway) {
        Pattern p1 = Pattern.compile(">-*<");
        Matcher m1 = p1.matcher(hallway);
        int menor = Integer.MAX_VALUE;
        while(m1.find()){
            int diferencia = 0;
            int pos1 = m1.start();
            int pos2 = m1.end() - 1;
            while(pos2 > pos1){
                pos1++;
                pos2--;
                diferencia++;
            }

            if(diferencia < menor){
                menor = diferencia;
            }
        }
        if(menor == Integer.MAX_VALUE){
          return -1;
        }
        return menor;
  }
}

    last month
    Refactor
    Discuss

7 kyu
Rock Paper Scissors Lizard Spock
Java:

import java.util.*;
public class Kata {
  
  public static String rpsls(String player1, String player2){
    HashMap<Integer, String> mapa = new HashMap<Integer, String>();
            mapa.put(0, "scissors");
            mapa.put(1, "paper");
            mapa.put(2, "rock");
            mapa.put(3, "lizard");
            mapa.put(4, "spock");
           
            if(Empate(player1, player2)){
                return "Draw!";
            } else{
                if(player1.equals(mapa.get(0))){
                    return player2.equals(mapa.get(1)) || player2.equals(mapa.get(3)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = tijeras
                } else if(player1.equals(mapa.get(1))){
                    return player2.equals(mapa.get(2)) || player2.equals(mapa.get(4)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = papel
                } else if(player1.equals(mapa.get(2))){
                    return player2.equals(mapa.get(0)) || player2.equals(mapa.get(3)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = piedra
                }else if(player1.equals(mapa.get(3))){
                    return player2.equals(mapa.get(1)) || player2.equals(mapa.get(4)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = lagarto
                }else if(player1.equals(mapa.get(4))){
                    return player2.equals(mapa.get(0)) || player2.equals(mapa.get(2)) ? "Player 1 Won!" : "Player 2 Won!";//jugador 1 = spock
                }
            }
    return "";
  }
  static boolean Empate(String a, String b){
            if(a.equals(b)){
                return true;
            }
            return false;
        }
}

    last month
    Refactor
    Discuss

8 kyu
Merging sorted integer arrays (without duplicates)
Java:

import java.util.*;
public class Kata {
	public static int[] mergeArrays(int[] first, int[] second) {

            HashMap<Integer, Integer> mapa = new HashMap<Integer,Integer>(); 
            for(int n : first){
                mapa.put(n, mapa.getOrDefault(n, 0) + 1);
            }
            for(int n : second){
                mapa.put(n, mapa.getOrDefault(n, 0) + 1);
            }
            int[] third = new int[mapa.size()];
            int j = 0;
            for(Map.Entry<Integer,Integer> entrada : mapa.entrySet()){
                third[j] = entrada.getKey();
                j++;
            }
    Arrays.sort(third);
    return third;
	}
}

    last month
    Refactor
    Discuss

6 kyu
Simple Fun #319: Number And IP Address
Java:

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

    last month
    Refactor
    Discuss

4 kyu
Connect Four
Java:

import java.util.*;

public class ConnectFour {
    public static String whoIsWinner(List<String> piecesPositionList) {
      String[][] board = new String[6][7];
      boolean player1 = true;
      
      for(int i = 0; i < board.length ; i++){
            Arrays.fill(board[i], " ");         
        }
      for(int i = 0 ; i < piecesPositionList.size() && !ganador(board); i++){
          player1 = player1 ? false : true;
          String[] jugada = piecesPositionList.get(i).split("_");
          if(i == 0 && jugada[1].equals("Red")){
            player1 = true;
          } 
          System.out.println(player1);
          System.out.println(i);
          int casilla = board.length - 1;
          int n = (int) (jugada[0].charAt(0) ) - 16;
          char c = (char) n;
          String s = Character.toString(c);
          int n2 = Integer.parseInt(s);
            while(casillaOcupada(board, casilla, n2 - 1)){                                                   
                casilla--;
                if(casilla < 0){
                    break;
                }
            }
          board[casilla][n2 - 1] = player1 ? "X" : "O";
        }
      if(empate(board)){
        return "Draw";
      }
      
        return player1 ? "Red" : "Yellow";
    }
    static boolean victoria(String a, String b, String c, String d){           
        if(a.equals(b) && a.equals(c) && a.equals(d)){    
            return true;
        }
        return false;
    }
    static boolean ganador(String board[][]){                                   
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                if(j < 4){
                    if(victoria(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3){
                    if(victoria(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j < 4){
                    if(victoria(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j > 2){
                    if(victoria(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(empate(board)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean empate(String board[][]){
        for(int i = 0; i < board.length; i++){              
            for (int j = 0; j < board[i].length ; j++){     
                if(!casillaOcupada(board, i, j)){          
                    return false;
                }
            }
        }
        return true;
    }
   
    static boolean casillaOcupada(String board[][], int i, int j){  
        if(!board[i][j].equals(" ")){
            return true;
        }
        return false;
    }
}

    last month
    Refactor
    Discuss

import java.util.*;

public class ConnectFour {
    public static String whoIsWinner(List<String> piecesPositionList) {
      String[][] board = new String[6][7];
      boolean player1 = true;
      
      for(int i = 0; i < board.length ; i++){
            Arrays.fill(board[i], " ");         
        }
      for(int i = 0 ; i < piecesPositionList.size() && !ganador(board); i++){
          player1 = player1 ? false : true;
          String[] jugada = piecesPositionList.get(i).split("_");
          if(i == 0 && jugada[1].equals("Red")){
            player1 = true;
          } 
          System.out.println(player1);
          System.out.println(i);
          int casilla = board.length - 1;
          int n = (int) (jugada[0].charAt(0) ) - 16;
          char c = (char) n;
          String s = Character.toString(c);
          int n2 = Integer.parseInt(s);
            while(casillaOcupada(board, casilla, n2 - 1)){                                                   
                casilla--;
                if(casilla < 0){
                    break;
                }
            }
          board[casilla][n2 - 1] = player1 ? "X" : "O";
        }
      if(empate(board)){
        return "Draw";
      }
      
        return player1 ? "Red" : "Yellow";
    }
    static boolean victoria(String a, String b, String c, String d){           
        if(a.equals(b) && a.equals(c) && a.equals(d)){    
            return true;
        }
        return false;
    }
    static boolean ganador(String board[][]){                                   
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                if(j < 4){
                    if(victoria(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3){
                    if(victoria(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j < 4){
                    if(victoria(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(i < 3 && j > 2){
                    if(victoria(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]) 
                            && casillaOcupada(board, i, j)){
                        return true;
                    }
                }
                if(empate(board)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean empate(String board[][]){
        for(int i = 0; i < board.length; i++){              
            for (int j = 0; j < board[i].length ; j++){     
                if(!casillaOcupada(board, i, j)){          
                    return false;
                }
            }
        }
        return true;
    }
    static String fileresDibuix(){                                              
        String a ="  ";
        for(int i = 0 ; i < 29 ; i++){
            a += "-";                       
        }
        a += "\n";
        return a;
    }
    static String columnesDibuix(String board[]){
        String a = "";
                                                                            
        for (int i = 0 ; i < board.length; i++){
            a += "| " + board[i]+ " ";                  
        }
        a += "|\n";
        return a;
    }
    static String tablero(String board[][]){  
        String a = "";
        for(int i = 0 ; i < 6 ; i ++){
            int n = 49 + i;
            char c = (char) n;
            a += fileresDibuix();
            a += c + " " + columnesDibuix(board[i]); 
        }
        a += fileresDibuix();
        a+= " ";
        for (int i = 0; i < 7 ; i++){
           int n = 65 + i;
           char c = (char) n;
            
            a += "   " + c;
        }
        return a;
    }
    static boolean casillaOcupada(String board[][], int i, int j){  
        if(!board[i][j].equals(" ")){
            return true;
        }
        return false;
    }
}

    last month
    Refactor
    Discuss

8 kyu
Sum without highest and lowest number
Java:

public class Kata
{
  public static int sum(int[] numbers)
  {
   
    if(numbers == null || numbers.length < 3){
      return 0;
    }
    int mayor = numbers[0];
    int menor = numbers[0];
    int suma = numbers[0];
    for(int i = 1 ; i < numbers.length;i++){
      mayor = Math.max(mayor, numbers[i]);
      menor = Math.min(menor, numbers[i]);
      suma += numbers[i];
    }

    suma -= mayor;
    suma -= menor;
    
    return suma;
  }
}

    last month
    Refactor
    Discuss

5 kyu
Scramblies
Java:

import java.util.HashMap;
import java.util.Map;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {    
        HashMap <Character, Integer> hm1 = new HashMap<Character,Integer>();
        HashMap <Character, Integer> hm2 = new HashMap<Character,Integer>();
        for(char c : str1.toCharArray()){
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }
        for(char c : str2.toCharArray()){
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entrada : hm2.entrySet()){
            if(!hm1.containsKey((entrada.getKey())) || hm1.get(entrada.getKey()) < entrada.getValue()){
                return false;
            }
        }
        return true;
    }
}

    last month
    Refactor
    Discuss

import java.util.regex.*;
public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {    
        int count = 0;
      if(str1.contains("abcdefghijklmnopqrstuvwxyz")){
        return true;
      }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(str1);
        for(int i = 0; i < str2.length() ; i++){
        
            for (int j = 0; j < sb2.length() ; j++){
          
                if(str2.charAt(i) == sb2.charAt(j)){
            
                    sb.append(sb2.charAt(j));
                    sb2.deleteCharAt(j);
                    count++;
                    break;
                }
            }
        }
        if(count == str2.length() || sb.toString().equals(str2)){
            return true;
        }
      return false;
    }
}

    last month
    Refactor
    Discuss

8 kyu
SQL Basics: Simple MIN / MAX
SQL:

SELECT MAX(age)as age_max, MIN(age) AS age_min FROM people;

    last month
    Refactor

7 kyu
Regexp Basics - is it a hexadecimal number?
Java:

public class StringUtils {
  
  public static boolean isHexNumber(String s) {
    return s.matches("^(0[Xx])?[0-9A-Fa-f]+$");
  }
}

    last month
    Refactor
    Discuss

7 kyu
Countries Capitals for Trivia Night (SQL for Beginners #6)
SQL:

SELECT capital FROM countries
WHERE (continent = 'Africa' OR continent = 'Afrika') AND country LIKE 'E%'
ORDER BY capital ASC
LIMIT 3;

    last month
    Refactor
    Discuss

7 kyu
Best-Selling Books (SQL for Beginners #5)
SQL:

SELECT * FROM books
ORDER BY copies_sold DESC
LIMIT 5;

    last month
    Refactor
    Discuss

8 kyu
Collect Tuition (SQL for Beginners #4)
SQL:

SELECT * FROM students
WHERE tuition_received = false;

    last month
    Refactor
    Discuss

8 kyu
Register for the Party (SQL for Beginners #3)
SQL:

INSERT INTO participants VALUES('Francesc', 30, true);
SELECT * FROM participants;

    last month
    Refactor
    Discuss

8 kyu
On the Canadian Border (SQL for Beginners #2)
SQL:

SELECT name, country FROM travelers
WHERE country NOT IN ('Canada', 'Mexico', 'USA');

    last month
    Refactor
    Discuss

8 kyu
Adults only (SQL for Beginners #1)
SQL:

SELECT name, age FROM users
WHERE age >= 18;

    last month
    Refactor
    Discuss

6 kyu
Dominant primes
Java:

class Solution{
    public static int solve(int a, int b){
        int suma = 0;
        int count = 1;
        for(int i = 3; i <= b ; i++){
            
            if(esPrimo(i)){
                count++;
                if(i >= a){
                    if( esPrimo(count)){
                        suma += i;
                        
                    }
                }
            }
            
            
        }
      return suma;
    }
    static boolean esPrimo(int i){
        boolean esprimo = true;
        for(int j = 2 ; j <= (int) Math.sqrt(i) && esprimo ; j++){
                if(i % j == 0){
                    esprimo = false;
                }
            }
        return esprimo;
    }
}

    last month
    Refactor
    Discuss

6 kyu
Transform To Prime
Java:

import java.util.ArrayList;
public class Solution
{
    public static int minimumNumber(int[] numbers)
    {
        int suma = 0;
        for(int i = 0 ; i < numbers.length ; i++){
          suma += numbers[i];
        }
        int contadorprimos = 0;
        for(int i = suma ; contadorprimos < 1 ; i++){
          boolean esPrimo = true;
          for(int j = i - 1 ; j >= 2 ; j--){
            if(i % j == 0){
              esPrimo = false;
              break;
            }
          }
          if(esPrimo){
            suma = i - suma;
            contadorprimos++;
          }
        }
        return suma; // Do your magic!
    }
}

    last month
    Refactor
    Discuss

6 kyu
Encrypt this!
Java:

public class Kata {
    public static String encryptThis(String text) {
        StringBuilder sb = new StringBuilder();
        String[] a = text.split(" ");
        for(int i = 0 ; i < a.length ; i++){
            StringBuilder sb2 = new StringBuilder();
            for(int j = 0 ; j < a[i].length() ; j++){
                if(j == 0){
                    int n = (int) a[i].charAt(0);
                    sb2.append(Integer.toString(n));
                } else if(j == 1){
                    sb2.append(a[i].charAt(a[i].length() - 1));
                }
                else if (j == a[i].length() - 1) {
                    sb2.append(a[i].charAt(1));
                }
                else{
                    sb2.append(a[i].charAt(j));
                }
                
            }
            sb.append(" "+ sb2);
        }
      return sb.toString().trim();
    }
}

    last month
    Refactor

6 kyu
Simple ROT13.5 cypher
Java:

public class Kata {
	
	public static String ROT135(String input)
	{
		 StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < input.length() ; i++){
            if(Character.toString(input.charAt(i)).matches("^[A-Za-z]$")){
                if(Character.toString(input.charAt(i)).matches("[N-Zn-z]")){
                    int n = (int) input.charAt(i);
                    n = n - 13;
                    sb.append((char) n);
                }else{
                    int n = (int) input.charAt(i);
                    n = n + 13;
                    sb.append((char) n);
                }
                
            } else if(Character.toString(input.charAt(i)).matches("[0-9]")){
                if(Character.toString(input.charAt(i)).matches("[5-9]")){
                    int n = (int) input.charAt(i);
                    n = n - 5;
                    sb.append((char) n);
                }else{
                    int n = (int) input.charAt(i);
                    n = n + 5;
                    sb.append((char) n);
                }
            } else{
                    sb.append(input.charAt(i));
            }
        }
    return sb.toString();
	}
}

    last month
    Refactor
    Discuss

5 kyu
ROT13
Java:

class Solution {
  
   public static String rot13(String message) {
     StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < message.length() ; i++){
            if(Character.toString(message.charAt(i)).matches("^[A-Za-z]$")){
                if(Character.toString(message.charAt(i)).matches("[N-Zn-z]")){
                    int n = (int) message.charAt(i);
                    n = n - 13;
                    sb.append((char) n);
                }else{
                    int n = (int) message.charAt(i);
                    n = n + 13;
                    sb.append((char) n);
                }
                
            } else{
                sb.append(message.charAt(i));
            }
        }
     return sb.toString();
   }
}

    last month
    Refactor

7 kyu
Find the next perfect square!
Java:

public class NumberFun {
  public static long findNextSquare(long sq) {
      if(sq % (long) Math.sqrt(sq) != 0){
        return -1;
      }
      return (long) Math.pow(Math.sqrt(sq) + 1, 2); 
  }
}

    last month
    Refactor
    Discuss

5 kyu
Tic-Tac-Toe Checker
Java:

public class Solution {
//Guarrada patrocinada por Francesc Barbón
    public static int isSolved(int[][] board) {
        for(int i = 0; i < board.length ; i++){
          if(board[i][0] == board[i][1]
            && board[i][0] == board[i][2] &&
            board[i][0] != 0){
            return board[i][0];
          } else if (board[0][i] == board[1][i]
                     && board[0][i] == board[2][i] 
                     && board[2][i] != 0){
            return board[0][i];
          } else if(board[0][0] == board[1][1]
                   && board[0][0]==board[2][2] &&
                    board[0][0] != 0){
            return board[0][0];
          }else if(board[0][2] == board[1][1]
                   && board[0][2]==board[2][0] &&
                    board[0][2] != 0){
            return board[0][2];
          }
        }
        for(int i = 0 ; i < board.length ; i++){
          for(int j = 0 ; j < board[i].length; j++){
            if(board[i][j] == 0){
              return -1;
            }
          }
        }
        return 0;
    }

}

    last month
    Refactor
    Discuss

public class Solution {

    public static int isSolved(int[][] board) {
        for(int i = 0; i < board.length ; i++){
          if(board[i][0] == board[i][1]
            && board[i][0] == board[i][2] &&
            board[i][0] != 0){
            return board[i][0];
          } else if (board[0][i] == board[1][i]
                     && board[0][i] == board[2][i] 
                     && board[2][i] != 0){
            return board[0][i];
          } else if(board[0][0] == board[1][1]
                   && board[0][0]==board[2][2] &&
                    board[0][0] != 0){
            return board[0][0];
          }else if(board[0][2] == board[1][1]
                   && board[0][2]==board[2][0] &&
                    board[0][2] != 0){
            return board[0][2];
          }
        }
        for(int i = 0 ; i < board.length ; i++){
          for(int j = 0 ; j < board[i].length; j++){
            if(board[i][j] == 0){
              return -1;
            }
          }
        }
        return 0;
    }

}

    last month
    Refactor
    Discuss

7 kyu
Is valid identifier?
Java:

public class IdentifierChecker {
  public static boolean isValid(String idn) {
    return idn.matches("^[A-Za-z\\$_][A-Za-z\\d_\\$]+$");
  }
}

    last month
    Refactor
    Discuss

6 kyu
Maze Runner
Java:

public class MazeRunner {
  public static String walk(int[][] maze, String[] directions) {
    int[] position = new int[2];
        boolean perdido = true;
        String resultado = "";
        for (int i = 0; i < maze.length && perdido ; i++){
            for (int j = 0 ; j < maze[i].length && perdido ; j++){
                if(maze[i][j] == 2){
                    position[0] = i;
                    position[1] = j;
                    perdido = true;
                }
            }
        }
        System.out.println("x: " + position[0] + " y: " + position[1]);
        boolean finish = false;
        for (int i = 0 ; i < directions.length && !finish; i++){
            if(directions[i].equals("N")){
                position[0]--;
            }else if(directions[i].equals("S")){
                position[0]++;
                
            }else if(directions[i].equals("W")){
                position[1]--;
            }else if(directions[i].equals("E")){
                position[1]++;
            }
            try{
                if(maze[position[0]][position[1]] == 0){
                
                } else if(maze[position[0]][position[1]] == 1){
                    resultado = "Dead";
                    finish = true;
                }else if(maze[position[0]][position[1]] == 3){
                    resultado = "Finish";
                    finish = true;
            }
            }catch(IndexOutOfBoundsException e){
                resultado = "Dead";
                finish = true;
            }
            
        }
        if(!finish){
            resultado = "Lost";
        }
    return resultado;
  }
}

    last month
    Refactor
    Discuss

8 kyu
Sum Mixed Array
Java:

import java.util.List;

public class MixedSum {

 /*
  * Assume input will be only of Integer o String type
  */
	public int sum(List<?> mixed) {	
    int suma = 0;
    for(int i = 0 ; i < mixed.size() ; i++){
      if(mixed.get(i) instanceof Integer){
        suma +=(int) mixed.get(i);
      } else {
        suma += Integer.parseInt((String)mixed.get(i));
      }
    }
		return suma;
	}
}

    last month
    Refactor
    Discuss

7 kyu
Longest vowel chain
Java:

import java.util.regex.*;
  class Solution{
    public static int solve(String s){
   
        String[] ar = s.split("[^aeiou]");
        int ind = 0;
        for(int i = 0; i < ar.length ; i++){
            if(ar[i].length() > ind){
                ind = ar[i].length();
            }
        }
      return ind;
  }
}

    last month
    Refactor
    Discuss

7 kyu
Snail crawls up
Java:

public class Kata {
    public static int snail(int column, int day, int night) {
      int dias = 0;
      int height = 0;
      int dif = day - night;
      while(height < column){
        dias++;
        height += day;
        if(height < column){
          height -= night;
        }
      }
      return dias; // your code here
    }
}

    last month
    Refactor
    Discuss

7 kyu
Sum of array singles
Java:

class Solution{
    public static int repeats(int [] arr){
        int suma = 0;
        for (int i = 0 ; i < arr.length ; i++){
          int count = 0;
          for(int j = 0 ; j < arr.length ; j++){
            if(arr[i] == arr[j]){
              count++;
            }
          }
          if(count <= 1){
            suma += arr[i];
          }
        }
      return suma;
    }
}

    last month
    Refactor
    Discuss

6 kyu
Count the smiley faces!
Java:

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SmileFaces {
  
  public static int countSmileys(List<String> arr) {
      String patron = "^[:;][-~]?[\\)D]$";
      int count= 0;
      Pattern p = Pattern.compile(patron);
      for(int i = 0 ; i < arr.size() ; i++){
        Matcher m = p.matcher(arr.get(i));
        while(m.find()){
          count++;
        }
      }
      return count;
  }
}

    last month
    Refactor
    Discuss

6 kyu
Dashatize it
Java:

public class Solution {

    public static String dashatize(int num) {
      String s = Integer.toString(num);
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length() ; i++){
        
       if(Character.toString(s.charAt(i)).matches("[13579]")){
          sb.append("-" + s.charAt(i) + "-");  
        } else{
          sb.append(s.charAt(i));
       }
        
      }
      return sb.toString().replaceAll("(-)+", "-").replaceAll("^-|-$", "");
    }

}

    last month
    Refactor
    Discuss

6 kyu
Valid Phone Number
Java:

public class Kata {
  public static boolean validPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("^\\([0-9]{3}\\)\s[0-9]{3}-[0-9]{4}$");
  }
}

    last month
    Refactor
    Discuss

6 kyu
Counting Duplicates
Java:

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CountingDuplicates {
  public static int duplicateCount(String text) {
    int mayor = 0;
        for(int i = 0 ; text.length() > 0 && mayor < 26; ){
            int count = 0;
            
            String patron = "[" + Character.toString(text.charAt(i)) + Character.toString(text.charAt(i)).toUpperCase() + "]";
            Pattern p = Pattern.compile(patron);
            Matcher m = p.matcher(text);
            while(m.find()){
                count++;
            }
            text = text.replaceAll(Character.toString(text.charAt(i)), "");
            if(count > 1){
              mayor++;
            }
            
        }
    return mayor;
  }
}

    last month
    Refactor
    Discuss

8 kyu
Vowel remover
Java:

public class Kata {
  public static String shortcut(String input) {
    return input.replaceAll("[aeiou]", "");   
  }
}

    last month
    Refactor
    Discuss

8 kyu
Grasshopper - Array Mean
Java:

public class GrassHopper {
    
    public static int findAverage(int[] nums) {
        int suma = 0;
        for (int i = 0 ; i < nums.length ; i++){
          suma += nums[i];
        }
        return suma/nums.length;
    }
}

    last month
    Refactor
    Discuss

6 kyu
Who likes it?
Java:

class Solution {
    public static String whoLikesIt(String... names) {
        if(names.length == 0){
          return "no one likes this";
        } else if(names.length == 1){
          return names[0] +" likes this";
        } else if(names.length == 2){
          return names[0] + " and " + names[1] +" like this";
        } else if(names.length == 3){
          return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        }
        
        return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
    }
}

    last month
    Refactor
    Discuss

8 kyu
Return Negative
Java:

public class Kata {

  public static int makeNegative(final int x) {
    int i = x;
    if(i < 0){
      return i;
    }
    return i * -1; // Your code here.
    
  }
  
}

    last month
    Refactor
    Discuss

6 kyu
Multiples of 3 or 5
Java:

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

    last month
    Refactor
    Discuss

7 kyu
Vowel Count
Java:

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Vowels {

  public static int getCount(String str) {
    String patron = "[aeiouAEIOU]";
        
        Pattern p = Pattern.compile(patron);
        
        Matcher m = p.matcher(str);
        
        int count = 0;
        while(m.find()){
            count++;
        }
        return count;
  }

}

    last month
    Refactor
    Discuss

7 kyu
The Culling of Stratholme
Java:

public class TheCullingOfStratholme  {
    public static String purify(String s) {
        return s.replaceAll("[\\w]{0,1}[iI]+[\\w]{0,1}", "").replaceAll("( )+", " ").trim();
    }
}

    last month
    Refactor

public class TheCullingOfStratholme  {
    public static String purify(String s) {
          return s.replaceAll("[\\w]{0,1}[iI]+[\\w]{0,1}", "").replaceAll("( )+", " ").trim();
    }
}

    last month
    Refactor

public class TheCullingOfStratholme  {
    public static String purify(String s) {
        StringBuilder s1 = new StringBuilder();
        s = s.trim();
        for (int i = 0 ; i < s.length();){
            if(i == 0){
                if( s.toLowerCase().charAt(i) != 'i' && s.toLowerCase().charAt(i + 1) != 'i'){
                    s1.append(s.charAt(i));
                    i++;
                }else{
                    i++;
                } 
            } else if(i == s.length() - 1){
                if(s.toLowerCase().charAt(i) != 'i' && s.toLowerCase().charAt(i - 1) != 'i'){
                    s1.append(s.charAt(i));
                    i++;
                } else {
                    i++;
                }
            } 
            else if (i > 0){
                if( s.toLowerCase().charAt(i) != 'i' && s.toLowerCase().charAt(i + 1) != 'i' && s.toLowerCase().charAt(i - 1) != 'i'){
                    s1.append(s.charAt(i));
                    i++;
                }else if(s.toLowerCase().charAt(i) != 'i' && s.toLowerCase().charAt(i - 1) != 'i' && s.toLowerCase().charAt(i + 1) != 'i'){
                    s1.append(" ").append(s.charAt(i));
                    i++;
                } else{
                    if(s.toLowerCase().charAt(i) == ' ' && s.toLowerCase().charAt(i - 1) == 'i' ){
                        s1.append(" ");
                    }else if (s.toLowerCase().charAt(i) == ' ' && s.toLowerCase().charAt(i + 1) == 'i'){
                        s1.append(" ");
                    }
                    
                    i++;
              } 
            }
        }
      
        for (int i = 1 ; i < s1.length(); ){
            if(s1.charAt(i) == ' ' && s1.charAt(i - 1) == ' '){
                s1.deleteCharAt(i);
            }
          else{
            i++;
          }
           
          }  
        String s2 = s1.toString();
        return s2.trim();
    }
}

    2 months ago
    Refactor
    Discuss

6 kyu
Remove the parentheses
Java:

public class Kata {
    public static String removeParentheses(final String str) {
        String s = str;
        while(s.contains("(")){
          s = s.replaceAll("\\([\\w\\s]*\\)", "");
        }
        return s;
    }
}

    last month
    Refactor
    Discuss

6 kyu
Sequences and Series
Java:

public class Sequence {

  public static long getScore(long n) {
    long score = 0;
    long aumento = 50;
    for(int i = 1 ; i <= n ; i++){
      if(i == 1){
        score=50;
      }else{
       score += aumento;  
      }
      aumento += 50;
    }
    return score;
  }
}

    last month
    Refactor
    Discuss

6 kyu
Squares in a Rectangle
Java:

public class Kata{
  public static int findSquares(int x, int y){
    int res = 0;
    while(x > 0 && y > 0){
      res += x * y;
      x--;
      y--;
    }
    return res;
  }
}

    last month
    Refactor
    Discuss

7 kyu
shorter concat [reverse longer]
Java:

public class ReverseLonger {


	public static String shorterReverseLonger(String a, String b) {

        String menor = a.length() < b.length() ? a : b;  
        String mayor = a.length() >= b.length() ? a : b;
        StringBuilder sb = new StringBuilder(menor);
        for(int i = mayor.length() - 1 ; i >=0 ; i--){
            sb.append(mayor.charAt(i));
        }
        sb.append(menor);
        return sb.toString();

	}

}

    last month
    Refactor
    Discuss

8 kyu
Regexp Basics - is it a digit?
Java:

public class StringUtils {
  
  public static boolean isDigit(String s) {
    return s.matches("^\\d$");
  }
}

    last month
    Refactor
    Discuss

8 kyu
Exclamation marks series #6: Remove n exclamation marks in the sentence from left to right
Java:

public class Kata {

  public static String remove(String s, int n){
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0 ; i < n ; i++){
      int ind = sb.indexOf("!");
      if(ind != -1){
        sb.deleteCharAt(ind);
      }
      else{break;}
    }
    s = sb.toString();
    return s;
    
  }
  
}

    last month
    Refactor
    Discuss

7 kyu
Count consonants
Java:

public class Consonants {
  public static int getCount(String str) {
    str = str.replaceAll("[aeiouAEIOU\\s\\W0-9_]", "");
    return str.length();
  }
}

    last month
    Refactor
    Discuss

7 kyu
Exclamation marks series #5: Remove all exclamation marks from the end of words
Java:

public class R {
  public static String removeBang(String str) {
    return str.replaceAll("[!]+ ", ("!  ")).replaceAll("[!]+$|[!]+ ", "");
  }
}

    last month
    Refactor
    Discuss

6 kyu
Create Phone Number
Java:

import java.util.Arrays;
public class Kata {
  public static String createPhoneNumber(int[] numbers) {
    StringBuilder sb = new StringBuilder();
        String s = Arrays.toString(numbers);
        s = s.replaceAll("[, \\[\\]]", "");
        
        for(int i = 0; i < s.length() ; i++){
            if(i == 0){
                sb.append("(");
            }
            sb.append(s.charAt(i));
            if(i == 2){
                sb.append(") ");
            }
            if(i == 5){
                sb.append("-");
            }
        }
      return sb.toString();
  }
}
