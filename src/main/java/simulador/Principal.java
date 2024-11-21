package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.batalla.Batalla;
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
        int opcion;
        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scan.nextInt();
            scan.nextLine(); 

            scan.nextInt();
            switch (opcion) {
                case 1:
                    gestionarEntrenadores gestor = new gestionarEntrenadores();
                    gestor.gestionarEntrenadores(scan);
                    break;
                case 2:
                    gestionarPokemon gestorPokemon = new gestionarPokemon();
                    gestorPokemon.gestionarPokemon(scan);
                    break;
                case 3:
                    System.out.println("Iniciando la batalla...");
                    Batalla batalla = new Batalla();
                    batalla.gestionarBatalla();
                    break;
                case 4:
                    System.out.println("Saliendo del Juego...");

            }
            
        } while (opcion != 4);
    }
}
