package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean[][] table = {{false, false, false, false},
                             {true , true , true , true },
                             {false, false, false, false},
                             {false, false, false, false }};
        int posicionInicial[] = {3, 0};
        int posicionFinal[] = {0, 0};
        System.out.println(lava(table, posicionInicial, posicionFinal));
    }
    static int lava(boolean[][] table, int[]posicionInicial, int[] posicionFinal) {
        /*Convertimos el tablero de booleanos en un tablero de int, esto nos permite poner diferentes valores para posiciones
        * por las que hemos pasado, muros y posiciones por las que no hemos pasado*/
        int[][] array = new int[table.length][table[0].length];
        for(int i = 0; i < table.length; i++) {
            //Damos valor de 1 a los muros y 0 a lo no ocupado
            for(int j = 0; j < table[i].length; j++) {
                if(table[i][j]) {
                    array[i][j] = 1;
                }else{
                    array[i][j] = 0;
                }
            }
        }
        //Inicializamos la posicion por la que entramos en el tablero en -1
        if(limites(array, posicionInicial[0], posicionInicial[1])){
            array[posicionInicial[0]][posicionInicial[1]] = -1;
        }
        //Contador nos permite contar los movimientos
        int contador = 0;

        //Las condiciones de final del bucle principal(que esta a continuacion) son que la posicionFinal este ocupada
        while(array[posicionFinal[0]][posicionFinal[1]] != -1){
            // Vamos usando un tablero
            //Utilizaremos movimientos para ver cuantas casillas hemos ocupado en este turno, si es 0 pero
            int movimientos = 0;
            for(int i = 0; i < array.length; i++) {
                for(int j = 0; j < array[i].length; j++) {
                    //Para evitar que haya problemas y que en un mismo turno se conviertan varias casillas en lugar
                    //de solo las de al lado, convertirmos todas las casillas que son 0 que hay junto a las que son -1
                    //a -2(mirad los 2 metodos que hay al final)
                    if(array[i][j] == -1){
                        if(comprobarLados(array, i, j - 1)){
                            array[i][j - 1] = -2;
                            movimientos++;
                        }
                        if(comprobarLados(array, i, j + 1)){
                            array[i][j + 1] = -2;
                            movimientos++;
                        }
                        if(comprobarLados(array, i + 1, j)){
                            array[i + 1][j] = -2;
                            movimientos++;
                        }
                        if(comprobarLados(array, i - 1, j)){
                            array[i - 1][j] = -2;
                            movimientos++;
                        }
                    }
                }
            }
            //Acto seguido, una vez termino de hacer la primera parte de la conversion convierto los -2 a -1, esta
            // parte es algo complicada de entender, pero lo que nos evitar es que un -1 que se ha convertido DURANTE
            //ESTE TURNO convierta las que tenia al lado tambien a -1, haciendo quen os saltemos turnos
            for(int i = 0; i < array.length; i++) {
                for(int j = 0; j < array[i].length; j++) {
                    if(array[i][j] == -2){
                        array[i][j] = -1;
                    }
                }
            }
            //en el caso de que movimientos sea 0 significara que NO ha ocupado la casillaFinal y no es capaz de hacer
            //mas movimientos, por tanto no habra camino posible
            if(movimientos == 0){
                System.out.println("No hay camino posible");
                return 0;
            }
            //al final de cada iteracion sumamos 1 al contador y finalmente lo retornamos
            contador++;
        }
        return contador;
    }
    static boolean comprobarLados(int[][] table, int x, int y){
        return limites(table, x, y) && (table[x][y] == 0); //lo de antes del and comprueba que este en los limites y la otra parte comprueba que sea 0, para evitar convertir los 1 que son muros
    }
    static boolean limites(int[][] table, int x, int y) {//comprueba que no haya out of bounds mirando los limites
        return x >= 0 && x < table.length && y >= 0 && y < table.length;
    }
}
