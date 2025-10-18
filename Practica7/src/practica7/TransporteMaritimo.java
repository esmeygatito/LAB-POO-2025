/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author esmeg
 */
public class TransporteMaritimo extends Transporte implements IOperable {

    public TransporteMaritimo(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Maritimo";
    }

    @Override
    public void mover() {
        System.out.println("Navegando por mar");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento marino: revision de casco y motores.");
    }
}