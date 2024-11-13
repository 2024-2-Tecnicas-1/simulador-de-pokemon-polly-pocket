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
    //constructor de los atributos
    public Pokemon(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
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
    
    
}
