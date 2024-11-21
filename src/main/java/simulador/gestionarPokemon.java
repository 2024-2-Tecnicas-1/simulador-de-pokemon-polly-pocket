package simulador;

import simulador.pokemon.Pokemon;
import java.util.*;
import simulador.entrenador.Entrenador;
import static simulador.gestionarEntrenadores.gestionarEntrenadores;
import static simulador.gestionarEntrenadores.verListaPokemones;
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
        // Verificar que un entrenador ha sido seleccionado
        if (gestionarEntrenadores.getEntrenadorSeleccionado() == null) {
            System.out.println("No has seleccionado un entrenador para registrar el Pokémon.");
            //gestionarEntrenadores gestionarEntrenadores = new gestionarEntrenadores();
            //gestionarEntrenadores.registrarEntrenador(scanner);
            return;
        }

        System.out.println("Selecciona un Pokémon para registrar:");
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }
        System.out.print("Elige un Pokémon (número): ");
        int opcionPokemonARegistrar = scanner.nextInt() - 1;

        if (opcionPokemonARegistrar >= 0 && opcionPokemonARegistrar < 6) {
            // Obtener el Pokémon seleccionado
            Pokemon pokemonARegistrar = pokemones.get(opcionPokemonARegistrar);

            // Registrar el Pokémon en el equipo del entrenador seleccionado
            Entrenador entrenador = gestionarEntrenadores.getEntrenadorSeleccionado();
            entrenador.agregarPokemonLista(pokemonARegistrar);  // Agregar el Pokémon al equipo del entrenador
            System.out.println("Pokémon " + pokemonARegistrar.getNombre() + " registrado para el entrenador " + entrenador.getNombre() + ".");
        } else {
            System.out.println("Opción no válida.");
        }
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
            System.out.println("1. Ver Pokemones Registrados");
            System.out.println("2. Registrar nuevo Pokemon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcionSubMenu = scanner.nextInt();

            switch (opcionSubMenu) {
                case 1:
                    gestionarEntrenadores.verListaPokemones();  // Llamar al método para ver lista de Pokémones
                    break;
                case 2:
                    // Si no hay entrenadores registrados
                    if (gestionarEntrenadores.getEntrenadores() == null || gestionarEntrenadores.getEntrenadores().size() == 0) {
                        System.out.println("No hay entrenadores registrados.");
                        gestionarEntrenadores gestionarEntrenadores = new gestionarEntrenadores();
                        gestionarEntrenadores.registrarEntrenador(scanner);  // Registrar un entrenador
                        // Verificar si se seleccionó un entrenador después de registrarlo
                        if (gestionarEntrenadores.getEntrenadorSeleccionado() != null) {
                            // Después de registrar un entrenador, registrar un Pokémon para ese entrenador
                            registrarPokemon(scanner);
                        }
                    } else {
                        // Si ya hay entrenadores registrados, simplemente registrar un Pokémon
                        registrarPokemon(scanner);
                    }
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }
}
