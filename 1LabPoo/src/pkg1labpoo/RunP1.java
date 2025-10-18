/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1labpoo;

import Calculator.*;

/**
 *
 * @author esmeg
 */
public class RunP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Calculadora casio = new Calculadora();
   
        System.out.println("El resultado de la suma de 98 + 109.6 = " + casio.suma(98,109.6));
        System.out.println("El resultado de la resta de 201.7 - 109.6 = " + casio.suma(201.7,109.6));
        System.out.println("El resultado de la multiplicacion de 7 + 15 = " + casio.suma(7,15));
        System.out.println("El resultado de la divisin de 436 / 20 = " + casio.suma(436,20));
    }
    
}
