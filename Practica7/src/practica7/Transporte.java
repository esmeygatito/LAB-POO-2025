/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author esmeg
 */
public abstract class Transporte {
    
    // Atributos privados -> ENCAPSULAMIENTO
    private String id;
    private int capacidad;

    // Constructor
    public Transporte(String id, int capacidad) {
        this.id = id;
        // La validación se hace a través del setter
        setCapacidad(capacidad);
    }

    // Getters y Setters -> ENCAPSULAMIENTO
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Setter validado
    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        // validación para IllegalArgumentException*
        if (capacidad > 500) {
            throw new IllegalArgumentException("Capacidad maxima permitida es 500.");
        }
        this.capacidad = capacidad;
    }

    // Método con manejo de EXCEPCIONES
    public void transportar(int pasajeros) throws CapacidadExcedidaException {
        if (pasajeros > this.capacidad) {
            String mensaje = String.format(
                "Pasajeros (%d) exceden capacidad (%d) en %s [%s]",
                pasajeros, this.capacidad, this.tipo(), this.id
            );
            throw new CapacidadExcedidaException(mensaje);
        } else {
            System.out.printf("Transportando %d pasajeros en %s [%s]\n",
                pasajeros, this.tipo(), this.id);
        }
    }

    // Métodos abstractos -> HERENCIA
    public abstract String tipo();
    public abstract void mover();
    
}
