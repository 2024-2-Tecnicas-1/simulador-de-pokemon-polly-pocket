package simulador.pokemon;
/**
 *
 * @author dfpar
 * @author 
 * @author 
 */


/**public enum TipoPokemon {
    FUEGO,
    AGUA,
    PLANTA,
    VENENO,
    ELECTRICO,
    PSIQUICO,
    ROCA,
    TIERRA,
    NORMAL,
    VOLADOR,
    HADA,
    LUCHA,
    ACERO,
    BICHO,
    HIELO,
    FANTASMA;
    
   public double factorMultiplicador(TipoPokemon atacante, TipoPokemon defensor){
        switch (atacante) {
            case FUEGO:
                switch (defensor) {
                    case AGUA:
                    case ROCA:
                    case ACERO:
                        return 0.5;
                    case PLANTA:
                    case BICHO:
                    case HIELO:
                        return 2;
                    default:
                        return 1;
                }
                break;
            default:
                break;
        }
        return 1;
    }
}
*/