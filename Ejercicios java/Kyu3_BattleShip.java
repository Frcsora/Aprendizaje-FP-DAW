//https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7
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
