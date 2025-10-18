/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica4;
import animales.*;
/**
 *
 * @author esmeg
 */
public class Practica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Animal a = new Perro("Perro"); // Se puede declarar así si se necesita polimorfismo
        Gato g = new Gato("Miki");
        Pajaro p = new Pajaro("Cuki");
        Perro d = new Perro("Firulais");

        System.out.println( "Gato");
        g.mostrarNombre();
        g.hacerSonido();
        System.out.println(g.comer());
        g.dormir();
        g.jugar();

        System.out.println( "\nPerro");
        d.mostrarNombre();
        d.hacerSonido();
        System.out.println(d.comer());
        d.dormir();
        d.jugar();
        
        System.out.println( "\nPajaro");
        p.mostrarNombre();
        p.hacerSonido();
        System.out.println(p.comer());
        p.dormir();
        p.jugar();
    }
    
}

