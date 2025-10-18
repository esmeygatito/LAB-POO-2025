/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tipoDeMotor;

/**
 *
 * @author esmeg
 */
public interface IElectrico {
    void cargar(double kwh);
    double nivelBateria(); 
}