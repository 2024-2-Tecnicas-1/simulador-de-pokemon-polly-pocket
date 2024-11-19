package simulador.pokemon;
/**
 *
 * @author dfpar
 * @author Ksrenn
 * @author Laufranco
 */
public abstract class Pokemon {
    //atributos de los pokemon
    private String nombre;
    private int salud;
    private int ataque;
    private TipoPokemon  tipo;
    private  String estado;
   
    //constructor de los atributos
    
    public Pokemon(String nombre, int salud, int ataque, TipoPokemon tipo, String estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.tipo = tipo;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
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
// metodos solicitados 
    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
// metodos solicitados
    // metodo de ataque 

    public  void ataca(Pokemon oponente){
            double multiplicador = this.tipo.factorMultiplicador(this.tipo, oponente.getTipo());

    }
    public void Dano(int dano) {
        this.salud -= dano;
        if (salud <= 0) {
            System.out.println("murio");
        }
   
      if (dano<0){
          dano =0;
      }
   
    }

   

    // metodo de entrenar
    public void entrenar() {
        this.ataque += 2;
        this.salud += 4;
    }
}
