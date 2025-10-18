/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public class Pajaro extends Animal{  //puedo agregar más cosas con implements Volar (interfaz)  
    
    public Pajaro(String nombre) {
        super(nombre);
    }
    
    /*public void volar(){  //este lo elimina en p5
        System.out.println("Pajaro volando");
    }*/
    
    @Override
    public void hacerSonido(){
        System.out.println("El pajaro canta");
    }
    
     @Override
    public String comer(){
        
        return "Pajaro come semillas";
    }
    

}
