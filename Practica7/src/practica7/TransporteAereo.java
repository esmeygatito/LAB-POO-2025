/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author esmeg
 */
public class TransporteAereo extends Transporte implements IOperable {

    public TransporteAereo(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Aereo";
    }

    @Override
    public void mover() {
        System.out.println("Volando en el aire️");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento aereo: inspeccion de turbinas y sistemas.");
    }
}