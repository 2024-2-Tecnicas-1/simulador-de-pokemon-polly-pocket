/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulador;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

/**
 *
 * @author User
 */
public class Shellder extends Pokemon {
    
    public Shellder(String nombre, int salud, int ataque, TipoPokemon tipo, String estado) {
        super(nombre, salud, ataque, tipo, estado);
    }
    public void atacar() {
        System.out.println(getNombre() + " usa Pistola Agua!");
        
    }
}
