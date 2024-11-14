package simulador;

import simulador.entrenador.Entrenador;
import java.util.*;

public class gestionarEntrenadores {
    private List<Entrenador> entrenadores;
    
    //Constructor para iniciar la lista
    
    public gestionarEntrenadores(){
        entrenadores =new ArrayList<>();
    }
    
    //Metodo para registrar un nuevo entrenador 
    public void registrarEntrenador(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        Entrenador nuevoEntrenador = new Entrenador(nombre);
        entrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador " + nombre + " registrado.");
    }
    
    //Metodo ver lista de los entrenadores
    public void verListaEntrenadores() {
        if (entrenadores.size()==0) { //entrenadores.size devueve el numero de elementos que hay en la lista entrenadores
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("Entrenadores registrados:");
            for (int i=0; i<entrenadores.size();i++) {
                Entrenador entrenador = entrenadores.get(i);//Obteniendo el entrenador en la posición
                System.out.println(entrenador.getNombre());//Imprime el nombre del entrenador
            }
        }
    }

    public void seleccionarEntrenador(Scanner scanner) {
        if (entrenadores.size()== 0) { //entrenadores.size devueve el numero de elementos que hay en la lista entrenadores
            System.out.println("No hay entrenadores registrados.");
            return;
        }

        System.out.println("Selecciona un entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).nombre);
        }
        System.out.print("Elige un entrenador (número): ");
        int opcion = scanner.nextInt() - 1;// Se resta 1 pues as litas comienzan desde 0
        Entrenador entrenadorSeleccionado = entrenadores.get(opcion);//muestra el entrenador seleccionado en la opcion anterior

        // Mostrar el nombre del entrenador seleccionado
        System.out.println("Entrenador seleccionado: " + entrenadorSeleccionado.nombre);
    }
    //METODO PUBLIC VOID IMPRIME ALGO NO DEVUELVE NINGUN DATO
    public void gestionarEntrenadores(Scanner scanner) {
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
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSubMenu != 4);
    }
}