/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica6;
import transportes.Vehiculo;
import tipoDeMotor.IElectrico;
/**
 *
 * @author esmeg
 */
public class AutoElectrico extends Vehiculo implements IElectrico {

    private double nivelBateria;

    public AutoElectrico(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
        this.nivelBateria = 80.0; // Batería inicial en %
    }

    @Override
    public String tipo() {
        return "Auto Electrico";
    }

    @Override
    public void cargar(double kwh) {
        this.nivelBateria += kwh;
        if (this.nivelBateria > 100) this.nivelBateria = 100;
        System.out.println("Cargando bateria. Nivel actual: " + this.nivelBateria + "%");
    }

    @Override
    public double nivelBateria() {
        return this.nivelBateria;
    }
}