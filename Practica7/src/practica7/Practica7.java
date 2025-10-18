/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica7;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esmeg
 */
public class Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // =============================================================
        // DEMOSTRACIÓN DEL MANEJO DE IllegalArgumentException 
        // =============================================================
        System.out.println("--- PRUEBA DE setCapacidad CON VALOR INVALIDO ---");
        try {
            TransporteTerrestre busGigante = new TransporteTerrestre("BUS-GIGANTE", 600);
            System.out.println("ERROR LÓGICO: Bus creado con capacidad de " + busGigante.getCapacidad());
        } catch (IllegalArgumentException e) {
            // Si la validación falla, capturamos el error
            System.err.println(" ERROR DE VALIDACION DE CAPACIDAD: " + e.getMessage());
        }
        // =============================================================
        // 1. Uso de ArrayList<Transporte> 
        List<Transporte> flota = new ArrayList<>();

        // 2. Creación de objetos con diferentes capacidades
        // El Marítimo tiene capacidad para 100 -> NO LANZARÁ EXCEPCIÓN con 60
        flota.add(new TransporteMaritimo("BAR-01", 100));
        // El Terrestre tiene capacidad para 50 -> SÍ LANZARÁ EXCEPCIÓN con 60
        flota.add(new TransporteTerrestre("BUS-22", 50));
        // El Aéreo tiene capacidad para 80 -> NO LANZARÁ EXCEPCIÓN con 60
        flota.add(new TransporteAereo("AV-777", 80));
        // El Ferroviario tiene capacidad para 150 -> NO LANZARÁ EXCEPCIÓN con 60
        flota.add(new TransporteFerroviario("TR-101", 150)); 
        
        int pasajerosA_Transportar = 60;

        System.out.println("---------------------------------------------------------");

        // Bucle que demuestra POLIMORFISMO
        for (Transporte t : flota) {
            // Se llama a mover() -> Cada objeto ejecuta su propia versión (polimorfismo)
            t.mover();

            // Bloque try-catch para manejar la excepción personalizada
            try {
                // El método transportar puede lanzar CapacidadExcedidaException
                t.transportar(pasajerosA_Transportar);
            } catch (CapacidadExcedidaException e) {
                // Se captura y se imprime el error personalizado
                System.err.println("ERROR: " + e.getMessage());
            }

            // Se llama al método de la interfaz Operable (realizarMantenimiento)
            ((IOperable) t).realizarMantenimiento(); 

            System.out.println("---");
        }

        System.out.println("-----------------------------------------------------------");
    }
    
}




