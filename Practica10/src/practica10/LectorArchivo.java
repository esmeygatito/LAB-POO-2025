/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica10;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author esmeg
 */
public class LectorArchivo extends Thread{
    private String nombreArchivo;

    public LectorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void run() {
        ClassLoader classLoader = getClass().getClassLoader();
        
        InputStream inputStream = classLoader.getResourceAsStream("practica10/" + nombreArchivo);

        if (inputStream == null) {
            System.err.println("Error: No se pudo encontrar el archivo en el paquete: " + nombreArchivo);
            return; // Termina la ejecución del hilo si no se encuentra el archivo
        }

        // try-with-resources para asegurar que todo se cierre automáticamente
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " leyendo: " + linea);
                Thread.sleep(500);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
