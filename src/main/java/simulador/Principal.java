package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

/**
 *
 * @author dfpar
 * @author Ksrenn
 * @author Laufranco
 */
public class Principal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Pokemon(String nombre, int salud, int ataque, TipoPokemon tipo, String estado)
        Pokemon charmander = new Pokemon("Charmander", 39, 52, TipoPokemon.FUEGO, "Normal") {
        };
        Pokemon shellder = new Pokemon("Shellder", 30, 65, TipoPokemon.AGUA, "Normal") {
        };
        Pokemon caterpie = new Pokemon("Caterpie", 45, 30, TipoPokemon.BICHO, "Normal") {
        };
        Pokemon jolteon = new Pokemon("Jolteon", 65, 65, TipoPokemon.ELECTRICO, "Normal") {
        };
        Pokemon drowzee = new Pokemon("Drowzee", 60, 48, TipoPokemon.PSIQUICO, "Normal") {
        };
        Pokemon diglett = new Pokemon("Diglett", 10, 55, TipoPokemon.TIERRA, "Normal") {
        };
        //Aparece que es (Hielo/Volador) preguntar como hacerlo
        
        Pokemon articuno = new Pokemon("Articuno", 90, 85, TipoPokemon.HIELO, "Normal") {
        };
        Pokemon snorlax = new Pokemon("Snorlax", 160, 110, TipoPokemon.NORMAL, "Normal") {
        };
        Pokemon hitmonlee = new Pokemon("Hitmonlee", 50, 120, TipoPokemon.LUCHA, "Normal") {
        };
        //Aparece que es (Agua/Veneno) preguntar como hacerlo
        Pokemon tentacool = new Pokemon("Tentacool", 40, 40, TipoPokemon.AGUA, "Normal") {
        };
        
        int opcion = scan.nextInt();
        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            scan.nextLine();
            switch (opcion) {
                case 1:
                    gestionarEntrenadores.gestionarEntrenadores(scan);
                    break;
                case 2:
                    gestionarPokemon.gestionarPokemon(scan);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del Juego...");

            }
        } while (opcion != 4);
    }
}
