/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public class Delfin extends Animal implements IAcuatico{
    
    public Delfin(String nombre){
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(this.getNombre() + " el delfin, hace un sonido de silbido.");
    }

    @Override
    public void nadar() {
        System.out.println(this.getNombre() + " nadando");
    }
    
     @Override
    public String respirar() {
        return this.getNombre() + " el delfin, respira usando sus pulmones.";
    }

}

