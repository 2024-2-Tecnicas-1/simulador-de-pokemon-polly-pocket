package simulador;

import java.util.Scanner;

/**
 *
 * @author dfpar
 * @author
 * @author
 */
public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar Pokémon");
        System.out.println("2. Mostrar lista de Pokémon");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion= scan.nextInt();

        switch(opcion) {
        case 1:
        break;
        case 2:
        break;
        case 3:
        break;
        case 4:
        System.out.println("Ingrese el nombre del entrenador");
        String nombreentrenador=scan.nextLine();
        Entrenador nombre = new Entrenador (nombre);
        
        break;
        
        
    }
        
    }
}
