/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica6;
import java.util.Arrays;
import java.util.List;
import transportes.Vehiculo;
import tipoDeMotor.*;

/**
 *
 * @author esmeg
 */
public class Practica6 {

    public static void main(String[] args) {
        // 1. Crear una instancia de cada tipo de transporte
        Auto autoCombustion = new Auto("Nissan", "Versa", 60);
        AutoElectrico autoElectrico = new AutoElectrico("Tesla", "Model 3", 80);
        Hibrido autoHibrido = new Hibrido("Toyota", "Prius", 70);

        System.out.println("=============================================");
        System.out.println(" DEMOSTRACION INDIVIDUAL (SIN CICLO)");
        System.out.println("=============================================");

        // Auto de Combustión 
        System.out.println("\n--- AUTO DE COMBUSTION ---");
        System.out.println(autoCombustion.describir());
        autoCombustion.acelerar(20);
        autoCombustion.frenar(10);
        autoCombustion.cargarGas(25);
        System.out.println("Tipo de combustible: " + autoCombustion.tipoCombustible());

        // Auto Eléctrico
        System.out.println("\n--- AUTO ELECTRICO ---");
        System.out.println(autoElectrico.describir());
        autoElectrico.acelerar();
        autoElectrico.frenar(30);
        autoElectrico.cargar(15);
        System.out.println("Nivel de bateria: " + autoElectrico.nivelBateria() + "%");
        
        // --- Operaciones con el Auto Híbrido ---
        System.out.println("\n--- AUTO HIBRIDO ---");
        System.out.println(autoHibrido.describir());
        autoHibrido.acelerar(15);
        autoHibrido.frenar(5);
        autoHibrido.cargar(10); // Método de IElectrico
        autoHibrido.cargarGas(5); // Método de ICombustion
        System.out.println("Nivel de bateria: " + autoHibrido.nivelBateria() + "%");
        System.out.println("Tipo de combustible: " + autoHibrido.tipoCombustible());

        System.out.println("\n\n=======================================================");
        System.out.println("DEMOSTRACION CON POLIMORFISMO (USANDO CICLO FOR)");
        System.out.println("=======================================================");

        // 2. Agregar los vehículos a una lista de tipo Vehiculo
        List<Vehiculo> flota = Arrays.asList(autoCombustion, autoElectrico, autoHibrido);

        // 3. Recorrer la flota y usar los métodos
        for (Vehiculo v : flota) {
            System.out.println("\n--- Procesando vehiculo de la flota ---");
            // A. Métodos de la clase base Vehiculo (Polimorfismo puro)
            // No necesitamos saber el tipo de objeto, todos responden a describir() y acelerar()
            System.out.println(v.describir());
            v.acelerar(25);
            v.frenar(10);

            // B. Métodos de las interfaces (requiere verificación de tipo)
            // Preguntamos si el vehículo tiene la "capacidad" de ser de combustión
            if (v instanceof ICombustion) {
                // Si sí, hacemos un "cast" para poder usar sus métodos específicos
                ICombustion combustion = (ICombustion) v;
                System.out.println("Tipo de combustible: " + combustion.tipoCombustible());
                combustion.cargarGas(10);
            }

            // Preguntamos si el vehículo tiene la "capacidad" de ser eléctrico
            if (v instanceof IElectrico) {
                // Si sí, hacemos el "cast" a eléctrico
                IElectrico electrico = (IElectrico) v;
                System.out.println("Nivel de Bateria: " + electrico.nivelBateria() + "%");
                electrico.cargar(5);
            }
        }


    }
}