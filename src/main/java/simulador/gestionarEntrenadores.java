package simulador;

import simulador.entrenador.Entrenador;
import java.util.*;

public class gestionarEntrenadores {
    static List<Entrenador> entrenadores = new ArrayList<>();

    public static void registrarEntrenador(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        Entrenador nuevoEntrenador = new Entrenador(nombre);
        entrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador " + nombre + " registrado.");
    }

    public static void verListaEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Entrenadores registrados:");
            for (Entrenador entrenador : entrenadores) {
                System.out.println(entrenador.nombre);
            }
        }
    }

    public static void seleccionarEntrenador(Scanner scanner) {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }

        System.out.println("Selecciona un entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).nombre);
        }
        System.out.print("Elige un entrenador (número): ");
        int opcion = scanner.nextInt() - 1;
        Entrenador entrenadorSeleccionado = entrenadores.get(opcion);

        // Mostrar el nombre del entrenador seleccionado
        System.out.println("Entrenador seleccionado: " + entrenadorSeleccionado.nombre);
    }

    public static void gestionarEntrenadores(Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("\nGestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
                    registrarEntrenador(scanner); // Llamada al método de registrar
                    break;
                case 2:
                    verListaEntrenadores(); // Llamada al método de ver lista
                    break;
                case 3:
                    seleccionarEntrenador(scanner); // Llamada al método de seleccionar
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }
}