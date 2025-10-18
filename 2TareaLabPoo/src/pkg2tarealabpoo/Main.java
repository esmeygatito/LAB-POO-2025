/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2tarealabpoo;

/**
 *
 * @author esmeg
 */
import Transporte.*;

public class Main {
    public static void main(String[] args) {
        // Usando constructor vacío y setters
        Carro miCarro = new Carro();
        miCarro.setMarca("Ford");
        miCarro.setModelo("Focus");
        miCarro.setAño(2020);
        miCarro.setColor("Rojo");

        // Usando constructor con parámetros
        Carro otroCarro = new Carro("Toyota", "Corolla", 2021, "Blanco");

        // Output lógico
        miCarro.displayInfo();
        miCarro.iniciarMotor();
        miCarro.acelerar(60);
        miCarro.darVuelta("derecha");
        miCarro.frenar();

        System.out.println();

        otroCarro.displayInfo();
        otroCarro.iniciarMotor();
        otroCarro.acelerar(80);
        otroCarro.darVuelta("izquierda");
        otroCarro.frenar();
    }
}