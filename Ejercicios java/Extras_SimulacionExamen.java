//Ejercicio1
static boolean sumaLista(int[] arrayNumeros, int k){
        //en el examen no hacia falta aclarar lo de static pero aqui si, porque esa en la misma clase que el main,
        //simplemente no le hagais mucho caso a eso
        for(int i = 0; i < arrayNumeros.length - 1; i++){
            //Primer bucle, va iterando toda la lista uno a uno. i es el numero que estamos comprobando las sumas con los demas
            //No nos interesa comprobar el ultimo porque queremos comprobar la suma de 2 numeros, y en el caso del ultimo estaria solo
            for(int j = i + 1; j < arrayNumeros.length ; j++){
                //Segundo bucle, itera toda la lista por delante de i, son todos los casos con los que se puede sumar i dentro de la lista
                
                if(arrayNumeros[i] + arrayNumeros[j] == k){
                    return true;//si encuentra un caso en que se de la condicion retorna true y sale de la funcion
                }
            }
        }
        return false;//si no encuentra ningun caso retorna false
  }
//Ejercicio2
static int productoLista(int[] arrayNumeros){
        //en este caso nos pedia que devolveriamos el mayor, asi que es int y no boolean
        //por lo demas es la misma logica que el anterior, solo que como son 3 numeros necesitamos 3 for
        //importante el punto desde donde he inicializado la variable mayor, porque si la inicializas
        //a 0 como hicieron otros, no dire nombres pero Bernat, puedes tener problemas si todas las 
        //combinaciones posibles dan numeros negativos, asi que, sea el mayor o el menor, lo mas 
        //sencillo es inicializar en el otro extremo
        int mayor = Integer.MIN_VALUE;//esto vale -2147483648, mas pequeño que esto no hay ningun int
        for(int i = 0 ; i < arrayNumeros.length - 2 ; i++){
            for(int j = i + 1 ; j < arrayNumeros.length - 1 ; j++)
                for(int k = j + 1 ; k < arrayNumeros.length ; k++){
                    int producto = arrayNumeros[i] * arrayNumeros[j] * arrayNumeros[k];
                    if(producto > mayor){
                        mayor = producto;
                    }
                }
        }
        return mayor;
    }
//Ejercicio 3
static boolean validarSopaLetras(char[][] tablero, String objetivo){
        //El stringBuilder es como un string que tiene ciertas herramientas para modificarlo que no tiene un string normal
        //.append(lo que quieras introducir) introduce cosas al fianl del stringbuilder
        //.insert(en que posicion quieres introducirlo, lo que quieras introducir)
        //hay mas funciones como replace y muchas otras
        StringBuilder diagonal1 = new StringBuilder();
        StringBuilder diagonal2 = new StringBuilder();
        //En el caso de las diagonales, nos interesa coger unicamente laas diagonales de 4, 
        //que iremos construyendo durante todo recorrido
        for(int i = tablero.length - 1 ; i >= 0 ; i-- ){
            StringBuilder filas = new StringBuilder();
            StringBuilder columnas = new StringBuilder();
            //las filas y columnas las construiremos a cada iteracion, asi que
            //las usaremos y reiniciaremos a cada iteracion
            for(int j = tablero[i].length - 1; j >= 0; j--){
                filas.append(tablero[i][j]);
                columnas.append(tablero[j][i]);
                //en cada iteracion del bucle tendremos que llenarlas con la palabra entera para poder comprobarla
                if(i == j){
                    //si i == j se dara en 0,0/1,1/2,2 i 3,3, es decir, la diagonal de izquierda a derecha
                    diagonal1.insert(0, tablero[i][j]);
                }
                if(j == tablero.length - 1 - i){
                    //si i es 0, solo entrara aqui cuando j sea 3(4 - 1 - 0)
                    //si i es 1, solo entrara aqui cuando j sea 2(4 - 1 - 1)
                    //de esta forma construiremos la segunda diagonal de derecha a izquierda
                    //a lo largo del recorrido
                    diagonal2.insert(0, tablero[i][j]);
                }
            }
            if(diagonal1.toString().equals(objetivo)
            || diagonal2.toString().equals(objetivo)
            || filas.toString().equals(objetivo)
            || columnas.toString().equals(objetivo)){
                //A la hora de comprobar, hay que convertir el StringBuilder a
                //String y luego comprobar si es igual al objetivo, en caso de
                //encontrarse una se retornara false
                return true;
            }
        }
        //En caso de que no se encuentre la palabra objetivo se retornara false
        return false;
    }
