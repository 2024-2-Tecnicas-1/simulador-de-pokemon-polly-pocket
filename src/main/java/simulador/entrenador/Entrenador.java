package simulador.entrenador;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dfpar
 * @author
 * @author
// */
public class Entrenador {

    private String nombre;
    private List<String> pokemones;

    //Constructor
    public Entrenador(String nombre, List<String> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }
    Scanner scan = new Scanner(System.in);
    
    //Obtener nombre del entrenador
    String nombreentrenador = scan.next();
    public String getnombre() {
        return nombre = nombreentrenador;
    }

}
