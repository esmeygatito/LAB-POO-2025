/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica6;

import transportes.*;
import tipoDeMotor.*;


/**
 *
 * @author esmeg
 */
public class Hibrido extends Vehiculo implements IElectrico, ICombustion {

    private double nivelBateria;
    private double nivelTanque;

    public Hibrido(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
        this.nivelBateria = 60.0;
        this.nivelTanque = 15.0;
    }

    @Override
    public void cargar(double kwh) {
        this.nivelBateria += kwh;
        if (this.nivelBateria > 100) this.nivelBateria = 100;
        System.out.println("Modo electrico: Cargando bateria. Nivel: " + this.nivelBateria + "%");
    }

    @Override
    public void cargarGas(double litrosGas) {
        this.nivelTanque += litrosGas;
        System.out.println("Modo gasolina: Cargando tanque. Nivel: " + this.nivelTanque + " L");
    }

    @Override
    public String tipo() {
        return "Auto Hibrido";
    }

    @Override
    public double nivelBateria() {
        return this.nivelBateria;
    }

    @Override
    public String tipoCombustible() {
        return "Gasolina Premium";
    }
}
