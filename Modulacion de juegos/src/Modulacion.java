import java.util.Scanner;
import java.util.Random;
public class Modulacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(25); // Genera un número aleatorio entre 0 y 24

        System.out.println("Bienvenido al juego para adivinar un número aleatorio");
        System.out.println("Elige una opción:");
        System.out.println("1. Jugar sin límite de intentos");
        System.out.println("2. Jugar con intentos limitados (1, 2 o 3)");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            juego(numeroSecreto);
        } else if (opcion == 2) {
            System.out.print("Elige el numero de oportunidades (1, 2 o 3): ");
            int oportunidades = scanner.nextInt();
            comprobarnumero(numeroSecreto, oportunidades);
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }

    public static void juego(int numeroSecreto) {
        Scanner scanner = new Scanner(System.in);
        int intento;

        while (true) {
            System.out.print("ingresa un numero: ");
            intento = scanner.nextInt();

            if (intento < numeroSecreto) {
                System.out.println("El numero secreto es mas grande");
            } else if (intento > numeroSecreto) {
                System.out.println("El numero secreto es mas pequeño");
            } else {
                System.out.println("Has acertado! ;)");
                break;
            }
        }

        scanner.close();
    }

    public static void comprobarnumero(int numeroSecreto, int oportunidades) {
        Scanner scanner = new Scanner(System.in);
        int intento;
        boolean acertado = false;

        System.out.println("Tienes " + oportunidades + " intentos para adivinar el número secreto.");

        for (int intentos = 1; intentos <= oportunidades; intentos++) {
            System.out.print("Intento #" + intentos + ": Ingresa un numero: ");
            intento = scanner.nextInt();

            if (intento < numeroSecreto) {
                System.out.println("El numero secreto es más grande");
            } else if (intento > numeroSecreto) {
                System.out.println("El numero secreto es más pequeño");
            } else {
                System.out.println("Has acertado! ;)");
                acertado = true;
                break;
            }
        }

        if (!acertado) {
            System.out.println("Se terminaron los intentos el numero era... " + numeroSecreto + ".");
        }

        scanner.close();
    }
}