/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5;

import animales.*;
/**
 *
 * @author esmeg
 */
public class Practica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Delfin d = new Delfin("Pinky");
        Aguila a = new Aguila("Falco");


        
       // Información del Delfín
       System.out.println("Informacion de " + d.getNombre()+ " el Delfin");
       d.despertar();
       d.hacerSonido();
       d.nadar();
       d.comer();
       System.out.println(d.respirar());
       System.out.println("---------");
       //Informacion del Aguila
       System.out.println("Informacion de " + a.getNombre()+ " el Aguila");
       a.despertar();
       a.hacerSonido();
       a.volar();
       a.comer();
       System.out.println(a.respirar());
       System.out.println("---------");
        
    }
    
}
