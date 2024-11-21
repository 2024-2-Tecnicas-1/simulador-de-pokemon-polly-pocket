package simulador;

import simulador.entrenador.Entrenador;
import java.util.*;
import static simulador.gestionarPokemon.registrarPokemon;
import simulador.pokemon.Pokemon;

public class gestionarEntrenadores {

    private static List<Entrenador> entrenadores;
    private static Entrenador entrenadorSeleccionado;
    private static List<Pokemon> pokemones;
    private static Pokemon pokemonSeleccionado;

    //Constructor para iniciar la lista
    public gestionarEntrenadores() {
        entrenadores = new ArrayList<>();
    }

    public static List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    //Metodo para registrar un nuevo entrenador 
    public static void registrarEntrenador(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        Entrenador nuevoEntrenador = new Entrenador(nombre);
        entrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador " + nombre + " registrado.");
    }

    //Metodo ver lista de los entrenadores
    public static void verListaEntrenadores() {
        if (entrenadores.size() == 0) { //entrenadores.size devueve el numero de elementos que hay en la lista entrenadores
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Entrenadores registrados:");
            for (int i = 0; i < entrenadores.size(); i++) {
                Entrenador entrenador = entrenadores.get(i);//Obteniendo el entrenador en la posición
                System.out.println(entrenador.getNombre());//Imprime el nombre del entrenador
            }
        }
    }

    public static void seleccionarEntrenador(Scanner scanner) {
        if (entrenadores.size() == 0) { //entrenadores.size devueve el numero de elementos que hay en la lista entrenadores
            System.out.println("No hay entrenadores registrados.");
            registrarEntrenador(scanner);
        }

        System.out.println("Selecciona un entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }
        System.out.print("Elige un entrenador (número): ");
        int opcion = scanner.nextInt() - 1;// Se resta 1 pues as litas comienzan desde 0
        entrenadorSeleccionado = entrenadores.get(opcion);
        // Mostrar el nombre del entrenador seleccionado
        System.out.println("Entrenador seleccionado: " + entrenadorSeleccionado.getNombre());

        gestionarEntrenador(scanner);
    }

    // Método para gestionar un entrenador (submenú con las opciones)
    public static void gestionarEntrenador(Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("\nGestionar " + entrenadorSeleccionado.getNombre());
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a gestionar entrenadores");
            System.out.print("Elige una opción: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
                    // Ver el equipo de Pokémones
                    entrenadorSeleccionado.mostrarPokemones();
                    break;
                case 2:

                    // Agregar un Pokémon al equipo
                   gestionarPokemon.registrarPokemon(scanner);
                

                    gestionarPokemon gestionarPokemon = new gestionarPokemon();
                    gestionarPokemon.registrarPokemon(scanner);

                    break;
                case 3:
                    // Entrenar un Pokémon
                    entrenarPokemon(scanner);
                    break;
                case 4:
                    System.out.println("Volviendo a gestionar entrenadores.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }

    // Método para entrenar un Pokémon
    private static void entrenarPokemon(Scanner scanner) {
        if (entrenadorSeleccionado.getPokemones().size() == 0) {
            System.out.println("El entrenador no tiene Pokémones en su equipo.");
            return;
        }

        // Mostrar lista de Pokémones del entrenador
        System.out.println("Selecciona un Pokémon para entrenar:");
        for (int i = 0; i < entrenadorSeleccionado.getPokemones().size(); i++) {
            System.out.println((i + 1) + ". " + entrenadorSeleccionado.getPokemones().get(i).getNombre());
        }

        System.out.print("Elige un Pokémon (número): ");
        int opcion = scanner.nextInt() - 1;

        if (opcion >= 0 && opcion < entrenadorSeleccionado.getPokemones().size()) {
            Pokemon pokemon = entrenadorSeleccionado.getPokemones().get(opcion);
            entrenadorSeleccionado.entrenarPokemon(pokemon);  // Entrenar al Pokémon
        } else {
            System.out.println("Opción no válida.");
        }
    }
    // Método para obtener el entrenador seleccionado

    public static Entrenador getEntrenadorSeleccionado() {
        return entrenadorSeleccionado;
    }

    // Método para ver la lista de Pokémones del entrenador seleccionado
    public static void verListaPokemones() {
        if (entrenadorSeleccionado == null) {
            System.out.println("No se ha seleccionado ningún entrenador.");
        } else {
            List<Pokemon> pokemonesEntrenador = entrenadorSeleccionado.getPokemones(); // Obtener los Pokémon del entrenador
            if (pokemonesEntrenador.size() == 0) {
                System.out.println(entrenadorSeleccionado.getNombre() + " no tiene Pokémones registrados.");
            } else {
                System.out.println("Pokémones de " + entrenadorSeleccionado.getNombre() + ":");
                for (Pokemon pokemon : pokemonesEntrenador) {
                    System.out.println(pokemon.getNombre());  // Imprimir el nombre del Pokémon
                }
            }
        }
    }

    // Método para seleccionar un Pokémon de la lista
    public static void seleccionarPokemon(Scanner scanner) {
        if (pokemones.size() == 0) {
            System.out.println("No hay Pokémones registrados.");
            return;
        }
        System.out.println("Selecciona un Pokémon:");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }
        System.out.print("Elige un Pokémon (número de 1 a " + pokemones.size() + "): ");
        int opcion = scanner.nextInt() - 1;  // Restar 1 ya que las listas comienzan en 0
        Pokemon pokemonSeleccionado = pokemones.get(opcion);  // Obtener el Pokémon seleccionado

        // Mostrar el nombre del Pokémon seleccionado
        System.out.println("Pokémon seleccionado: " + pokemonSeleccionado.getNombre());
    }

    //METODO PUBLIC VOID IMPRIME ALGO NO DEVUELVE NINGUN DATO
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
                    //Lleva el scanner ya que necesita leer respuestas del usuario, necesita leer información que da el usuario.
                    break;
                case 2:
                    verListaEntrenadores(); // Llamada al método de ver lista
                    break;
                case 3:
                    seleccionarEntrenador(scanner); // Llamada al método de seleccionar
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }
}
