/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica10;

/**
 *
 * @author esmeg
 */
public class Practica10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando la lectura concurrente de archivos...");

        // 1. Crear los 3 objetos LectorArchivo, uno para cada sucursal
        LectorArchivo hilo1 = new LectorArchivo("sucursal1.txt");
        LectorArchivo hilo2 = new LectorArchivo("sucursal2.txt");
        LectorArchivo hilo3 = new LectorArchivo("sucursal3.txt");
        hilo1.setName("Hilo-Sucursal-1");
        hilo2.setName("Hilo-Sucursal-2");
        hilo3.setName("Hilo-Sucursal-3");

        // 2. Iniciar la ejecución de los tres hilos simultáneamente
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Los 3 hilos han sido iniciados.");
        
    }
    
}
