package simulador;

import simulador.pokemon.Pokemon;  
import java.util.*;

public class gestionarPokemon {
    private static List<Pokemon> pokemones;  
    private static Pokemon pokemonSeleccionado;

    // Constructor para iniciar la lista de Pokémon
    public gestionarPokemon() {
        pokemones = new ArrayList<>();
    }

    // Método para registrar un nuevo Pokémon
    public static void registrarPokemon(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el nombre del Pokémon: ");
        String nombre = scanner.nextLine();
        //Pokemon nuevoPokemon = new Pokemon(nombre) {};  // Crear un nuevo Pokémon
        //pokemones.add(nuevoPokemon);  // Agregar a la lista de Pokémones
        System.out.println("Pokémon " + nombre + " registrado.");
    }

    // Método para ver la lista de Pokémones
    public static void verListaPokemones() {
        if (pokemones.size() == 0) {
            System.out.println("No hay Pokémones registrados.");
        } else {
            System.out.println("Pokémones registrados:");
            for (int i = 0; i < pokemones.size(); i++) {
                Pokemon pokemon = pokemones.get(i);  // Obtener el Pokémon en la posición
                System.out.println(pokemon.getNombre());  // Imprimir el nombre del Pokémon
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
        System.out.print("Elige un Pokémon (número): ");
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
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }
}