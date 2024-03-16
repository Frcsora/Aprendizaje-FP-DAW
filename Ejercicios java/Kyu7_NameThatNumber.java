//https://www.codewars.com/kata/579ba41ce298a73aaa000255

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
