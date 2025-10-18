/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica6;
import transportes.Vehiculo;
import tipoDeMotor.ICombustion;
/**
 *
 * @author esmeg
 */
public class Auto extends Vehiculo implements ICombustion {

    private double nivelTanque;

    public Auto(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
        this.nivelTanque = 20.0; // Tanque inicial
    }

    @Override
    public String tipo() {
        return "Auto de Combustion";
    }

    @Override
    public void cargarGas(double litrosGas) {
        this.nivelTanque += litrosGas;
        System.out.println("Cargando gasolina. Nivel del tanque: " + this.nivelTanque + " L");
    }

    @Override
    public String tipoCombustible() {
        return "Gasolina Magna";
    }
}