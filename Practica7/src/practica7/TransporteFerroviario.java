/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author esmeg
 */
public class TransporteFerroviario extends Transporte implements IOperable {

    public TransporteFerroviario(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Ferroviario";
    }

    @Override
    public void mover() {
        System.out.println("Viajando sobre rieles");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento ferroviario: revision de vias y locomotoras.");
    }
}
