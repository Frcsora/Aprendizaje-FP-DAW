package connect4;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
public class Connect4 {

    public static void main(String[] args) {
        String[][] board = new String[6][7];

        Scanner sc = new Scanner(System.in);
        boolean jugador1 = false;      //Esta variable se utiliza para cambiar de jugador
        HashMap<String, Integer> conversion = new HashMap <String, Integer>();
        
        int n = (int) 'A';
        for(Integer i = 0 ; i < 7 ; i++){
            char c = (char) n;                      //Con este HashMap creamos la relación
            String s = Character.toString(c);       //entre letras y números para que nuestro
            conversion.put(s, i);           //programar sepa encontrar el lugar en
            n++;                                    //el tablero donde situar la letra
        }
        
        for(int i = 0; i < board.length ; i++){
            Arrays.fill(board[i], " ");          //Llenamos el array vacio que hemos creado con espacios en blanco
        }
        
        String nombre1, nombre2;
        System.out.print("Jugador 1 elige tu nombre: ");     //Dejamos que los jugadores selecciones sus nombres
        nombre1 = sc.nextLine().trim();                        //Dejamos que utilizen caracteres alfanuméricos y espacios con almenos 3 letras
        while(!nombre1.matches("^[\\w\\s]{3,}$")){          
            System.out.println("No es un nombre valido elige otro");
            nombre1 = sc.nextLine().trim();
        }
        System.out.print("Jugador 2 elige tu nombre: ");
        nombre2 = sc.nextLine().trim();
        while(!nombre2.matches("^[\\w\\s]{3,}$")){
            System.out.println("No es un nombre valido elige otro");
            nombre2 = sc.nextLine().trim();
        }
        System.out.println(tablero(board));             //Dibujamos el tablero para empezar
        while(!ganador(board)){                           //Mientras no se cumplan las condiciones de empate o victoria seguira la partida
            
            jugador1 = jugador1 ? false : true;         //Se cambia de jugador, si es verdadero pasa a falso si es falso a verdadero
            System.out.println(jugador1 ? "Turno de " + nombre1 : "Turno de " + nombre2);                       //Imprimimos el jugador que tiene el turno
            System.out.println("Escribe la letra de la columna donde quieres colocar la letra:");             //Damos instrucciones sobre lo que hay que hacer
            String respuesta = sc.nextLine().toUpperCase().trim();                                              //El jugador nos indica en que columna quiere jugar
            while(!respuesta.matches("[A-G]")){
                System.out.println("Esa no es una opcion valida. Selecciona una opcion valida");
                respuesta = sc.nextLine().toUpperCase().trim();
            }
            int casilla = board.length - 1;                                                                     //Comprobamos si la columna existe, y en ese caso
            Integer res = conversion.get(respuesta);                                                         //si estuviera llena, en ese caso daremos un
            while(casillaOcupada(board, casilla, res)){                                                     //mensaje de error y pediremos que nos introduzca una columna valida
                casilla--;
                if(casilla < 0){
                    break;
                }
            }
            while(!respuesta.matches("[A-G]") || casilla < 0){                                               
                System.out.println("Esa no es una opcion valida. Selecciona una opcion valida");
                respuesta = sc.nextLine().toUpperCase().trim();
                casilla = board.length - 1;
                res = conversion.get(respuesta);
                if(respuesta.matches("[A-G]"))
                while(casillaOcupada(board, casilla, res)){
                    casilla--;
                    if(casilla < 0){
                        break;
                    }
                }
            }                                                                   //Sabemos en que casilla tenemos que situar la ficha del jugador gracias a la longitud del primer eje y al hashmap que nos permitira
            board[casilla][res] = jugador1 ? "X" : "O";                         //Convertir la letra en una posicion del segundo eje
            System.out.println(tablero(board));                               //Volveremos a dibujar el tablero ya modificado
        }   
        System.out.println(empate(board) ? "Todas las casillas estan llenas y no hay un ganado, EMPATE!" : jugador1 ? "GANADOR " + nombre1 + "!" : "GANADOR " + nombre2 + "!");
    }
    static boolean victoria(String a, String b, String c, String d){            // esta función nos servirá para comprobar si se cumplen
        if(a.equals(b) && a.equals(c) && a.equals(d)){     // las condiciones de victoria
            return true;
        }
        return false;
    }
    static boolean ganador(String board[][]){                                   //esta función nos servirá para determinar si se ha dado o no un ganador
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
    static boolean empate(String board[][]){
        for(int i = 0; i < board.length; i++){              //comprobamos la posibilidad de que alla un empate,
            for (int j = 0; j < board[i].length ; j++){     //si una casilla esta vacia retornara directamente falso, 
                if(!casillaOcupada(board, i, j)){           //en caso contrario verdadero
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
            a += "| " + board[i]+ " ";                  //A la hora de dibujar las columnas introduciremos en su medio el que luego sera el segundo eje que normalmente iteraremos con j
        }
        a += "|\n";
        return a;
    }
    static String tablero(String board[][]){  //Las 3 últimas funciones nos servirán para dibujar el tablero
        String a = "";
        for(int i = 0 ; i < 6 ; i ++){
            int n = 49 + i;
            char c = (char) n;
            a += fileresDibuix();
            a += c + " " + columnesDibuix(board[i]); //A cada columna iremos introduciendo el que sera el primer eje que iteraremos con i
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
    static boolean casillaOcupada(String board[][], int i, int j){  //comprobamos si la casilla esta ocupada ya o no
        if(!board[i][j].equals(" ")){
            return true;
        }
        return false;
    }
}
