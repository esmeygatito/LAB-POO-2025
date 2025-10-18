/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;
import java.util.*;


/**
 *
 * @author esmeg
 */
public class Practica8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // =========================================================================
        // A. ArrayList: Lista de Exhibición (Orden de llegada)
        // =========================================================================
        System.out.println("== A. ArrayList: Exhibicion (Orden de llegada) ==");
        
        List<ProductoFarmacia> listaExhibicion = new ArrayList<>();
        
        listaExhibicion.add(new ProductoFarmacia(101, "Aspirina", "Analgesico"));
        listaExhibicion.add(new ProductoFarmacia(102, "Vitamina C", "Suplemento"));
        listaExhibicion.add(new ProductoFarmacia(103, "Curitas (Caja)", "Primeros Auxilios"));
        listaExhibicion.add(new ProductoFarmacia(104, "Mascarillas (Pack)", "Oferta")); // Categoría para eliminar
        
        // Recorrido con for-each
        for (ProductoFarmacia p : listaExhibicion) {
            System.out.println(p);
        }

        // =========================================================================
        // B. LinkedList: Cola para Reabastecer
        // =========================================================================
        System.out.println("\n== B. LinkedList: Cola para Reabastecer ==");
        
        LinkedList<ProductoFarmacia> colaReabastecer = new LinkedList<>();
        
        colaReabastecer.addLast(new ProductoFarmacia(105, "Ibuprofeno", "Analgesico"));
        colaReabastecer.addLast(new ProductoFarmacia(106, "Protector Solar", "Dermocosmetica"));
        colaReabastecer.addFirst(new ProductoFarmacia(107, "Alcohol en Gel", "Higiene")); // Se añade al inicio

        // Recorrido con for-each
        for (ProductoFarmacia p : colaReabastecer) {
            System.out.println(p);
        }

        // =========================================================================
        // C. HashSet: Conjunto de Categorías Únicas
        // =========================================================================
        System.out.println("\n== C. HashSet: Categorias unicas ==");
        
        Set<String> categorias = new HashSet<>();
        
        // Agregando categorías (algunas repetidas)
        categorias.add("Analgesico");
        categorias.add("Suplemento");
        categorias.add("Analgesico"); // duplicado es ignorado por HashSet
        categorias.add("Primeros Auxilios");
        categorias.add("Dermocosmetica");
        categorias.add("Higiene");
        
        System.out.println(categorias); 

        // =========================================================================
        // D. HashMap: Consulta de Producto por ID
        // =========================================================================
        System.out.println("\n== D. HashMap: Consulta por ID ==");
        
        Map<Integer, ProductoFarmacia> mapaPorId = new HashMap<>();
        
        // Inserto todos los productos creados en las listas (se usan los IDs como clave)
        listaExhibicion.forEach(p -> mapaPorId.put(p.getId(), p));
        colaReabastecer.forEach(p -> mapaPorId.put(p.getId(), p));

        // Consulta get(id)
        int idConsulta = 103;
        ProductoFarmacia productoConsultado = mapaPorId.get(idConsulta);
        System.out.println("id=" + idConsulta + " -> " + productoConsultado);

        // Recorrido de HashMap por entrySet()
        System.out.println("\nRecorriendo HashMap (entrySet):");
        for (Map.Entry<Integer, ProductoFarmacia> entrada : mapaPorId.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        // =========================================================================
        // E. Iterator: Eliminación Segura
        // =========================================================================
        System.out.println("\n== E. Iterator: eliminar categoria 'Oferta' en listaExhibicion ==");
        
        Iterator<ProductoFarmacia> iterador = listaExhibicion.iterator();
        
        while (iterador.hasNext()) {
            ProductoFarmacia p = iterador.next();
            // Se eliminan los productos cuya categoría sea "Oferta"
            if (p.getCategoria().equals("Oferta")) {
                iterador.remove(); // ¡Uso seguro del Iterator para eliminar!
                System.out.println("Eliminado: " + p.getNombre());
            }
        }
        
        System.out.println("\nDespues de eliminar, listaExhibicion:");
        // Recorrido final para confirmar
        for (ProductoFarmacia p : listaExhibicion) {
            System.out.println(p);
        }

    }
    
}
