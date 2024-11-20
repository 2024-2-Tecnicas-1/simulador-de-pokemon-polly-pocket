package simulador;

import simulador.pokemon.Pokemon;
import java.util.*;
import simulador.entrenador.Entrenador;
import static simulador.gestionarEntrenadores.gestionarEntrenadores;
import simulador.pokemon.TipoPokemon;

public class gestionarPokemon {

    private static List<Pokemon> pokemones;
    private static Pokemon pokemonSeleccionado;
    private static Entrenador entrenadorSeleccionado;

    // Constructor para iniciar la lista de Pokémon
    public gestionarPokemon() {
        pokemones = new ArrayList<>();

        // Inicialización de los Pokémon predefinidos con sus respectivas subclases
        pokemones.add(new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO, "Normal"));
        pokemones.add(new Shellder("Shellder", 30, 65, TipoPokemon.AGUA, "Normal"));
        pokemones.add(new Caterpie("Caterpie", 45, 30, TipoPokemon.BICHO, "Normal"));
        pokemones.add(new Jolteon("Jolteon", 65, 65, TipoPokemon.ELECTRICO, "Normal"));
        pokemones.add(new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO, "Normal"));
        pokemones.add(new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA, "Normal"));
        pokemones.add(new Articuno("Articuno", 90, 85, TipoPokemon.HIELO, "Normal"));
        pokemones.add(new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL, "Normal"));
        pokemones.add(new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA, "Normal"));
        pokemones.add(new Tentacool("Tentacool", 40, 40, TipoPokemon.AGUA, "Normal"));
    }

    // Método para registrar un nuevo Pokémon
    public static void registrarPokemon(Scanner scanner) {
        System.out.println("Selecciona un Pokémon para registrar:");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }
        System.out.print("Elige un Pokémon (número): ");
        int opcion = scanner.nextInt() - 1;  // Restar 1 ya que las listas comienzan en 0

        if (opcion >= 0 && opcion < pokemones.size()) {
            Pokemon pokemonARegistrar = pokemones.get(opcion);  // Obtener el Pokémon seleccionado

            // Verificar si se ha seleccionado un entrenador
            if (entrenadorSeleccionado != null) {
                // Agregar el Pokémon seleccionado al entrenador
                entrenadorSeleccionado.agregarPokemonLista(pokemonARegistrar);
                System.out.println("Pokémon " + pokemonARegistrar.getNombre() + " registrado para el entrenador " + entrenadorSeleccionado.getNombre() + ".");
            } else {
                System.out.println("No has seleccionado un entrenador para registrar el Pokémon.");
            }
        } else {
            System.out.println("Opción no válida. Debes elegir un número entre 1 y " + pokemones.size() + ".");
            gestionarEntrenadores(scanner);
        }
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
    
    // Método para obtener el Pokémon seleccionado
    public static Pokemon getPokemonSeleccionado() {
        return pokemonSeleccionado;
    }

    // Método público void para gestionar Pokémones
    public static void gestionarPokemon(Scanner scanner) {
        int opcionSubMenu;

        do {
            System.out.println("\nGestionar Pokémones");
            System.out.println("1. Registrar nuevo Pokémon");
            System.out.println("2. Ver lista de Pokémones");
            System.out.println("3. Seleccionar un Pokémon");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
                    registrarPokemon(scanner);  // Llamar al método para registrar Pokémon
                    break;
                case 2:
                    verListaPokemones();  // Llamar al método para ver lista de Pokémones
                    break;
                case 3:
                    seleccionarPokemon(scanner);  // Llamar al método para seleccionar un Pokémon
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
