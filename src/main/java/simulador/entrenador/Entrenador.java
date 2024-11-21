package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;
import simulador.pokemon.Pokemon;

/**
 *
 * @author dfpar // * @author Ksrenn
 * @author Laufranco
 */

public class Entrenador {

    private String nombre;
    private List<Pokemon> pokemones;

    //Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Obtener nombre del entrenador
    public String getNombre() {
        return nombre;
    }

    //Agregar un pokemon a la lista
    //void ya que este metodo no devuelve ningun valor
    public void agregarPokemonLista(Pokemon pokemon) {
        pokemones.add(pokemon);    
    }

    // Método para obtener la lista de Pokémones del entrenador
    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    //Metodo entrenar al pokemon
    public void entrenarPokemon(Pokemon pokemon) {
        //if para verificar que l pokemon este en la lista de pokemones del entrenador
        if (pokemones.contains(pokemon)) {
            //hacer condicion en clase pokemon en la que mejora las estadisticas del pokemon
            //System.out.println("El pokemon: "+pokemon.getNombre+" fue entrenado");
        } else {
            System.out.println("El pokemon no se encuentra en el equipo de: " + nombre);
        }
    }

    public void mostrarPokemones() {
        System.out.println("Pokémones de " + nombre + ":");
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon);
        }
    }

}
