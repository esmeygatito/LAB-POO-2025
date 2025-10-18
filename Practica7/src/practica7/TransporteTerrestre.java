/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica7;

/**
 *
 * @author esmeg
 */
public class TransporteTerrestre extends Transporte implements IOperable {

    public TransporteTerrestre(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Terrestre";
    }

    @Override
    public void mover() {
        System.out.println("Rodando en carretera");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento terrestre: llantas y frenos.");
    }
}