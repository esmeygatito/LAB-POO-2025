/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportes;

/**
 *
 * @author esmeg
 */
public abstract class Vehiculo {

    private double velocidad;
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo, double velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        setVelocidad(velocidad);
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public final void setVelocidad(double v) {
        if (v < 0) {
            v = 0;
        }
        this.velocidad = v;
    }

    public void acelerar() {
        setVelocidad(getVelocidad() + 10);
        System.out.println("Acelerando a " + this.velocidad + " km/h");
    }

    public void acelerar(double incremento) {
        setVelocidad(getVelocidad() + Math.max(0, incremento));
         System.out.println("Acelerando a " + this.velocidad + " km/h");
    }
    
    
    public void frenar(double decremento) {
        System.out.println("Frenando...");
        setVelocidad(getVelocidad() - Math.max(0, decremento));
    }

    public abstract String tipo();
    
    public String describir() {
        return String.format("Vehiculo: %s %s | Tipo: %s | Velocidad: %.1f km/h", 
                this.marca, this.modelo, this.tipo(), this.velocidad);
    }
}