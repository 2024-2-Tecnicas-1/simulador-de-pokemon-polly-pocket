package simulador.pokemon;
/**
 *
 * @author dfpar
 * @author Ksrenn
 * @author 
 */
public class Pokemon {
    //atributos de los pokemon
    private String nombre;
    private int salud;
    private int ataque;
    private TipoPokemon  tipo;
    //constructor de los atributos
    
    public Pokemon(String nombre, int salud, int ataque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.tipo = tipo;
    }
    //getter de los atributos
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }
    
    //setter de los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }
    
    
}
