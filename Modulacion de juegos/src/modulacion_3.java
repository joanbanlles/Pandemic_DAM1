import java.util.Scanner;
public class modulacion_3{
        public static void main(String[] args) {
            char[][] tablero = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
            char jugadorActual = 'X';
            Scanner scanner = new Scanner(System.in);

            while (true) {
                mostrartablero(tablero);
                System.out.print("Turno del jugador " + jugadorActual + ". Ingrese la fila y columna (ej. 0 1): ");

                int fila = scanner.nextInt();
                int columna = scanner.nextInt();

                if (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ') {
                    System.out.println("Movimiento invalido. Intente de nuevo.");
                    continue;
                }

                tablero[fila][columna] = jugadorActual;

                if (hayganador(tablero, jugadorActual)) {
                    mostrartablero(tablero);
                    System.out.println("El jugador " + jugadorActual + " ha ganado!");
                    break;
                }

                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';

                if (tablerolleno(tablero)) {
                    mostrartablero(tablero);
                    System.out.println("El juego ha terminado en empate!");
                    break;
                }
            }

            scanner.close();
        }

        static void mostrartablero(char[][] tablero) {
            for (char[] fila : tablero) {
                for (char casilla : fila) {
                    System.out.print(casilla + " ");
                }
                System.out.println();
            }
        }

        static boolean hayganador(char[][] tablero, char jugador) {
            for (int i = 0; i < 3; i++) {
                if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                        (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                    return true;
                }
            }
            return (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
                    (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador);
        }

        static boolean tablerolleno(char[][] tablero) {
            for (char[] fila : tablero) {
                for (char casilla : fila) {
                    if (casilla == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
}

