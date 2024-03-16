//https://www.codewars.com/kata/549ee8b47111a81214000941
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
