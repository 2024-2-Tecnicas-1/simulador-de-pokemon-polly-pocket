package simulador.batalla;
/**
 *
 * @author dfpar
 * @author Ksrenn
 * @author 
 */
public class Batalla {
/*/*
    // Constructor vacío
    public Batalla() {
        // Puedes inicializar aquí atributos si los añades en el futuro
    }

    // Método que gestiona el flujo de la batalla
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("¡La batalla entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre() + " comienza!");
        
        // Simula la batalla
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            // Pokémon 1 ataca a Pokémon 2
            int daño1 = calcularDaño(pokemon1, pokemon2);
            pokemon2.recibirDaño(daño1);
            System.out.println(pokemon1.getNombre() + " ataca a " + pokemon2.getNombre() + " causando " + daño1 + " puntos de daño.");
            
            // Verificar si Pokémon 2 ha sido derrotado
            if (pokemon2.getSalud() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado!");
                System.out.println(pokemon1.getNombre() + " gana la batalla.");
                break;
            }
            
            // Pokémon 2 ataca a Pokémon 1
            int daño2 = calcularDaño(pokemon2, pokemon1);
            pokemon1.recibirDaño(daño2);
            System.out.println(pokemon2.getNombre() + " ataca a " + pokemon1.getNombre() + " causando " + daño2 + " puntos de daño.");
            
            // Verificar si Pokémon 1 ha sido derrotado
            if (pokemon1.getSalud() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado!");
                System.out.println(pokemon2.getNombre() + " gana la batalla.");
                break;
            }
        }
    }

    // Método para calcular el daño que un Pokémon hace a otro
    //private int calcularDaño(Pokemon atacante, Pokemon defensor) {
        // Aquí puedes agregar una fórmula para calcular el daño, por ejemplo:
        //int daño = atacante.getAtaque() - defensor.getDefensa();
        return Math.max(daño, 0);  // El daño no puede ser negativo
    }
*/
}
