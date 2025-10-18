/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica8;
import java.util.Objects;

/**
 *
 * @author esmeg
 */
public class ProductoFarmacia {
    
    private final int id; // final ya que el ID no debería cambiar
    private String nombre;
    private String categoria;

    // Constructor
    public ProductoFarmacia(int id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    
    // Método toString() para impresión
    @Override
    public String toString() {
        return "ProductoFarmacia{id=" + id + 
               ", nombre='" + nombre + '\'' + 
               ", categoria='" + categoria + '\'' + 
               '}';
    }

    // Implementación de equals() y hashCode() basándose SOLO en el ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoFarmacia that = (ProductoFarmacia) o;
        return id == that.id; // Solo compara por ID!
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // ¡Solo genera el hash por ID!
    }
    
    
}
