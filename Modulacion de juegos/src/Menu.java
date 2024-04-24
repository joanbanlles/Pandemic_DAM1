import java.util.Scanner;
public class Menu {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido a la selección de juegos:");
        System.out.println("1. Tres en raya");
        System.out.println("2. Piedra, papel o tijera");
        System.out.println("3. Numeros aleatorios");
        System.out.println("4. Salir");
        System.out.print("Ingrese el número del juego que desea jugar: ");
        opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.println("Estás jugando a la Tres en raya.");
            modulacion_3.main(args);
        } else if (opcion == 2) {
            System.out.println("Estás jugando a Piedra, papel o tijera.");
            Modulacion_2.main(args);
        } else if (opcion == 3) {
            System.out.println("Estás jugando a numeros aleatorios");
            Modulacion.main(args);
        } else if (opcion == 4) {
            System.out.println("Saliendo del menú. ¡Hasta luego!");
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}








