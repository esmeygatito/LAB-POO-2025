/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public class Perro extends Animal {
    
    public Perro(String nombre) {
        super(nombre);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra: Guau guau!");
    }

    @Override
    public String comer() {
        return "Perro come croquetas";
    }
    
}
