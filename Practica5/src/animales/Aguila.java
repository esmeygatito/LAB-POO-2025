/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public class Aguila extends Animal implements IVolar {
    
    public Aguila(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(this.getNombre() + " el aguila, hace un sonido de chillido.");
    }

    @Override
    public void volar() {
        System.out.println(this.getNombre() + " el aguila, vuela alto.");
    }
    
    @Override
    public String respirar() {
        return this.getNombre() + " el aguila, respira a traves de sus pulmones.";
    }

    
}
