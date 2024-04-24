import java.util.Scanner;
import java.util.Random;

public class Modulacion_2 {
    static Scanner scanner = new Scanner(System.in);
    static char[][] tablero = new char[3][3];
    static char jugador = 'X';

    public static void main(String[] args) {
        System.out.println("¡Bienvenido al juego de Tres en Raya!");

        int opcion;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Jugar contra otro jugador");
            System.out.println("2. Jugar contra la IA");
            System.out.println("0. Salir");
            System.out.print("Ingrese su eleccion: ");
            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2) {
                jugar(opcion);
            } else if (opcion != 0) {
                System.out.println("Opción invalida. Intente de nuevo.");
            }
        } while (opcion != 0);

        System.out.println("Gracias por jugar!");
        scanner.close();
    }

    static void jugar(int opcion) {
        inicializarTablero();
        int turnos = 0;
        boolean ganador = false;

        while (turnos < 9 && !ganador) {
            mostrartablero();
            realizarmovimiento(opcion == 1 ? scanner : null);
            ganador = verificarganador();
            cambiarturno();
            turnos++;
        }

        mostrartablero();
        if (!ganador) {
            System.out.println("\nEmpate!");
        }
    }

    static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    static void mostrartablero() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void realizarmovimiento(Scanner input) {
        int fila = -1, columna = -1;

        if (input != null) {
            System.out.print("Introduce la fila: ");
            fila = input.nextInt();
            System.out.print("Introduce la columna: ");
            columna = input.nextInt();
        } else {
            Random rand = new Random();
            while (!esmovimientovalido(fila, columna)) {
                fila = rand.nextInt(3);
                columna = rand.nextInt(3);
            }
        }

        if (esmovimientovalido(fila, columna)) {
            tablero[fila][columna] = jugador;
        }
    }

    static boolean esmovimientovalido(int fila, int columna) {
        return (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-');
    }

    static boolean verificarganador() {


        return false;
    }

    static void cambiarturno() {
        jugador = (jugador == 'X') ? 'O' : 'X';
    }
}




