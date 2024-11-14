package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;

public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
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
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del Juego...");

            }
        } while (opcion != 4);
    }
}
