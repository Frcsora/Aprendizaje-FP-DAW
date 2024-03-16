//https://www.codewars.com/kata/58663693b359c4a6560001d6
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
