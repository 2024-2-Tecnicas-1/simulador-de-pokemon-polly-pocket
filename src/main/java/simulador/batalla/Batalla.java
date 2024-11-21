package simulador.batalla;

import java.util.Scanner;
import simulador.entrenador.Entrenador;
import simulador.gestionarEntrenadores;
import simulador.gestionarPokemon;
import simulador.pokemon.Pokemon;

/**
 *
 * @author dfpar
 * @author Ksrenn
 * @author
 */
public class Batalla {

    Scanner scan = new Scanner(System.in);
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    int opcionbatalla;

    public Batalla() {

    }
    // Método para seleccionar el primer entrenador (se llama dentro del flujo de la batalla)

    private void seleccionarEntrenador1() {
        System.out.println("Seleccionando entrenador 1...");

        // Verificar que haya entrenadores registrados
        if (gestionarEntrenadores.getEntrenadores().size() == 0) {
            System.out.println("No hay entrenadores registrados. Registra algunos primero.");
            gestionarEntrenadores.registrarEntrenador(scan);
        }
        gestionarEntrenadores.seleccionarEntrenador(scan);
        entrenador1 = gestionarEntrenadores.getEntrenadorSeleccionado();
        if (entrenador1 != null) {
            System.out.println("Entrenador 1 seleccionado: " + entrenador1.getNombre());
        } else {
            System.out.println("No se pudo seleccionar un entrenador.");
        }
    }

    // Método para seleccionar el segundo entrenador (si es necesario)
    private void seleccionarEntrenador2() {
        System.out.println("Seleccionando entrenador 2...");

        // Verificar que haya entrenadores registrados
        if (gestionarEntrenadores.getEntrenadores().size() == 0) {
            System.out.println("No hay entrenadores registrados. Registra algunos primero.");
            gestionarEntrenadores.registrarEntrenador(scan);
        }
        // Llamamos a gestionarEntrenadores para seleccionar un entrenador
        gestionarEntrenadores.seleccionarEntrenador(scan);

        // Asignamos el entrenador seleccionado a entrenador2
        entrenador2 = gestionarEntrenadores.getEntrenadorSeleccionado();

        // Mostramos mensaje de éxito
        if (entrenador2 != null) {
            System.out.println("Entrenador 2 seleccionado: " + entrenador2.getNombre());
        } else {
            System.out.println("No se pudo seleccionar un entrenador.");
        }
    }

    // Método para seleccionar Pokémon de cada entrenador
    private void seleccionarPokemonEntrenador1() {
        if (entrenador1 != null) {
            gestionarEntrenadores gestionarEntrenadores = new gestionarEntrenadores();
            gestionarEntrenadores.seleccionarPokemon(scan);
            //gestionarPokemon.seleccionarPokemon(scan); // Selecciona un Pokémon
            pokemon1 = gestionarPokemon.getPokemonSeleccionado(); // Obtiene el seleccionado
            if (pokemon1 != null) {
                System.out.println("Pokémon seleccionado para Entrenador 1: " + pokemon1.getNombre());
            }
        } else {
            System.out.println("Primero debes seleccionar al entrenador 1.");
        }
    }

    private void seleccionarPokemonEntrenador2() {
        if (entrenador2 != null) {
            gestionarEntrenadores gestionarEntrenadores = new gestionarEntrenadores();
            gestionarEntrenadores.seleccionarPokemon(scan);
            if (pokemon2 != null) {
                System.out.println("Pokémon seleccionado para Entrenador 2: " + pokemon2.getNombre());
            }
        } else {
            System.out.println("Primero debes seleccionar al entrenador 2.");
        }
    }
    // Método para comenzar la batalla entre los dos Pokémon seleccionados

    private void comenzarBatalla() {
        System.out.println("La batalla ha comenzado entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre());

        // Menú de batalla
        int opcion;
        do {
            System.out.println("\n--- Durante la Batalla ---");
            System.out.println("1. " + pokemon1.getNombre() + " Atacar");
            System.out.println("2. " + pokemon2.getNombre() + " Atacar");
            System.out.println("3. Finalizar la batalla");
            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    pokemon1.ataca(pokemon2); // El Pokémon 1 ataca
                    break;
                case 2:
                    pokemon2.ataca(pokemon1); // El Pokémon 2 ataca
                    break;
                case 3:
                    System.out.println("La batalla ha terminado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            // Mostrar estado de la batalla
            System.out.println(pokemon1.getNombre() + " - Salud: " + pokemon1.getSalud());
            System.out.println(pokemon2.getNombre() + " - Salud: " + pokemon2.getSalud());

            // Comprobar si alguno de los Pokémon ha caído
            if (pokemon1.getSalud() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado.");
                break;
            } else if (pokemon2.getSalud() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado.");
                break;
            }

        } while (opcion != 3);
    }

    // Método para gestionar la batalla
    public void gestionarBatalla() {
        int opcion;
        do {
            System.out.println("\n=== Menú de Batalla ===");
            System.out.println("1. Elegir entrenador 1");
            System.out.println("2. Elegir entrenador 2");
            System.out.println("3. Seleccionar Pokémon de entrenador 1");
            System.out.println("4. Seleccionar Pokémon de entrenador 2");
            System.out.println("5. Comenzar batalla");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarEntrenador1();
                    break;
                case 2:
                    seleccionarEntrenador2();
                     gestionarPokemon gestionarPokemon2 = new gestionarPokemon();
                    gestionarPokemon.registrarPokemon(scan);
                    break;
                case 3:
                    seleccionarPokemonEntrenador1();
                     gestionarPokemon gestionarPokemon1 = new gestionarPokemon();
                    gestionarPokemon.registrarPokemon(scan);
                    break;
                case 4:
                    seleccionarPokemonEntrenador2();
                    break;
                case 5:
                    if (pokemon1 != null && pokemon2 != null) {
                        comenzarBatalla();
                    } else {
                        System.out.println("Ambos entrenadores deben tener un Pokémon seleccionado.");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
