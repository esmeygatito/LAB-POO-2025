/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public class Animal {
    
    String nombre;
    public Animal(String nombre){
        this.nombre = nombre;
    }
    
    public void mostrarNombre(){
        System.out.println("    Me llamo: "+ nombre);
    }
    
    public void hacerSonido(){
        System.out.println("El animal hace un sonido");
    }
    
    public String comer(){
        
        return "Animal comiendo nom";
    }
    
    public void dormir() {
        System.out.println(nombre + " esta durmiendo.");
    }

    public void jugar() {
        System.out.println(nombre + " esta jugando.");
    }
    
}

//Hacer más métodos aquí
