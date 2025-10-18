/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author esmeg
 */
public class Calculadora {
    
     public double suma(double a, double b) {
        return a + b;
    }
    
    public double resta(double a, double b) {
        return a - b;
    }
    
    public double multiplicacion(double a, double b) {
        return a * b;
    }
    
    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero.");
        }
        return a / b;
    }
    
}
