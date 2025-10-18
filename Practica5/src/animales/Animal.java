/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public abstract class Animal {
    
    private String nombre;
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Animal(String nombre){
        this.nombre = nombre;
    }
    
    public abstract void hacerSonido();
    
    public void comer(){
        System.out.println(this.nombre + " come rico");
    }
    
    public void despertar(){
        System.out.println(this.nombre + " despertando");
    }
    
    public abstract String respirar(); 
    
}
