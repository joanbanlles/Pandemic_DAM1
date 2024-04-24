import java.util.Scanner;
public class Practica2 {
    public static void main(String[] args) {
        int[] array = new int[30];
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 5) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 1) {
                introducirUnElemento(array, scanner);
            } else if (opcion == 2) {
                mostrarVector(array);
            } else if (opcion == 3) {
                sacarElemento(array);
            } else if (opcion == 4) {
                buscarElemento(array, scanner);
            } else if (opcion == 5) {
                System.out.println("¡Buen viaje :)!");
            } else {
                System.out.println("Opción no valida. Prueba otra vez");
            }
        }

        scanner.close();
    }

    private static boolean estaVacio(int[] array) {
        for (int elemento : array) {
            if (elemento != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean estaLleno(int[] array) {
        for (int elemento : array) {
            if (elemento == 0) {
                return false;
            }
        }
        return true;
    }

    private static void introducirUnElemento(int[] array, Scanner scanner) {
        if (!estaLleno(array)) {
            System.out.print("Ingrese el nuevo elemento (distinto de 0): ");
            int nuevoElemento = scanner.nextInt();

            if (nuevoElemento != 0) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 0) {
                        array[i] = nuevoElemento;
                        System.out.println("Elemento insertado correctamente.");
                        break;
                    }
                }
            } else {
                System.out.println("Error: El elemento a introducir no puede ser igual a 0.");
            }
        } else {
            System.out.println("Error: El array está lleno. No se puede insertar más elementos.");
        }
    }

    private static void sacarElemento(int[] array) {
        if (!estaVacio(array)) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] != 0) {
                    System.out.println("Elemento sacado: " + array[i]);
                    array[i] = 0;
                    break;
                }
            }
        } else {
            System.out.println("Error: El array esta vacio. No hay elementos para sacar.");
        }
    }

    private static void mostrarVector(int[] array) {
        System.out.println("Contenido del array:");
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    private static void buscarElemento(int[] array, Scanner scanner) {
        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscar = scanner.nextInt();

        if (buscarElemento(array, numeroBuscar)) {
            System.out.println("El número " + numeroBuscar + " se encuentra en el array.");
        } else {
            System.out.println("El número " + numeroBuscar + " no se encuentra en el array.");
        }
    }

    private static boolean buscarElemento(int[] array, int numeroBuscar) {
        for (int elemento : array) {
            if (elemento == numeroBuscar) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Introducir un elemento en el array.");
        System.out.println("2. Mostrar array.");
        System.out.println("3. Sacar elemento.");
        System.out.println("4. Buscar elemento.");
        System.out.println("5. Salir");
        System.out.print("Ingrese la opción: ");
    }
}

