package practica9;
import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;

/**
 *
 * @author esmeg
 */
public class Practica9 {
    
    private static final String NOMBRE_CARPETA = "datos";
    private static final String NOMBRE_ARCHIVO = "productos.txt";
    private static final String RUTA_COMPLETA = NOMBRE_CARPETA + File.separator + NOMBRE_ARCHIVO;
    private static final String NOMBRE_CATEGORIAS_ARCHIVO = "categorias.txt";
    
    public static void main(String[] args) {

        crearCarpeta();
        Scanner scanner = new Scanner(System.in);
        
        agregarYGuardarProductos(scanner);
        leerYMostrarArchivo();
        listarArchivos();
        
        // PRUEBA DE RETOS OPCIONALES
        System.out.println("\n=== PRUEBA DE RETOS OPCIONALES ===");
        
        System.out.println("Numero total de productos guardados: " + contarProductos());
        
        System.out.print("Introduce el nombre del producto a buscar: ");
        String nombreBuscado = scanner.nextLine();
        buscarProductoPorNombre(nombreBuscado);

        crearArchivoCategoriasUnicas();
        
        hacerRespaldo();
        
        borrarArchivo(scanner);
        
        scanner.close();
    }

    // =================================================================
    // FUNCIONES PRINCIPALES Y AUXILIARES
    // =================================================================
    
    private static void crearCarpeta() {
        File carpeta = new File(NOMBRE_CARPETA);
        if (carpeta.exists()) {
            System.out.println("Carpeta '" + NOMBRE_CARPETA + "' ya existe.");
        } else {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta '" + NOMBRE_CARPETA + "' creada.");
            } else {
                System.err.println("Error al crear la carpeta '" + NOMBRE_CARPETA + "'.");
            }
        }
    }

    private static Set<String> cargarIDsExistentes() {
        Set<String> ids = new HashSet<>();
        File archivo = new File(RUTA_COMPLETA);
        if (!archivo.exists()) {
             return ids; 
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_COMPLETA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0) {
                    ids.add(partes[0].trim());  
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.err.println("Error al cargar IDs: " + e.getMessage());
        }
        return ids;
    }
    
    /**
     * Pide al usuario el numero de productos y sus detalles, luego los guarda en el archivo.
     */
    private static void agregarYGuardarProductos(Scanner scanner) {
        Set<String> idsExistentes = cargarIDsExistentes();
        
        System.out.println("\n=== Registro de productos ===");
        int numProductos = 0;
        
        while (numProductos <= 0) {
            System.out.print("Cuantos productos quieres agregar?: ");
            if (scanner.hasNextInt()) {
                numProductos = scanner.nextInt();
                scanner.nextLine(); 
                if (numProductos <= 0) {
                    System.out.println("Por favor, ingresa un numero positivo.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, ingresa un numero entero.");
                scanner.nextLine(); 
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_COMPLETA, true))) {

            for (int i = 1; i <= numProductos; i++) {
                System.out.println("\nProducto #" + i);

                // Validacion ID (entero y unico)
                String id = "";
                boolean idValido = false;
                while (!idValido) {
                    System.out.print("ID (debe ser entero y unico): ");
                    if (scanner.hasNextInt()) {
                        String nuevoId = String.valueOf(scanner.nextInt());
                        scanner.nextLine();
                        if (idsExistentes.contains(nuevoId)) {
                            System.out.println("ID ya existe. Por favor, ingresa un ID diferente.");
                        } else {
                            id = nuevoId;
                            idsExistentes.add(id);  
                            idValido = true;
                        }
                    } else {
                        System.out.println("ID invalido. Por favor, ingresa un numero entero.");
                        scanner.nextLine();
                    }
                }
            
                String nombre = "";
                boolean nombreValido = false;
                while(!nombreValido){
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine().trim();
                    if(nombre.isEmpty()){
                        System.out.println("El nombre no puede estar vacio. Intenta de nuevo.");
                    } else {
                        nombreValido = true;
                    }
                }
                
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                
                String lineaProducto = id + "," + nombre + "," + categoria;
                
                writer.write(lineaProducto); 
                writer.newLine(); 
            }
            System.out.println("\nProductos guardados correctamente."); 
        } catch (IOException e) {
            System.err.println("Error de escritura en el archivo: " + e.getMessage());
        }
    }

    private static void leerYMostrarArchivo() {
        System.out.println("\n=== Lectura del archivo ===");
        
        File archivo = new File(RUTA_COMPLETA);
        if (!archivo.exists()) {
             System.out.println("El archivo no se encontro: " + RUTA_COMPLETA);
             return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_COMPLETA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo: " + e.getMessage());
        }
    }

    private static void listarArchivos() {
        System.out.println("\n=== Archivos en la carpeta '" + NOMBRE_CARPETA + "' ===");
        File carpeta = new File(NOMBRE_CARPETA);
        String[] archivos = carpeta.list();

        if (archivos != null && archivos.length > 0) {
            for (String archivo : archivos) {
                System.out.println(" * " + archivo);
            }
        } else {
            System.out.println("No hay archivos en la carpeta.");
        }
    }
    
    // =================================================================
    // RETOS OPCIONALES
    // =================================================================
    
    private static int contarProductos() {
        int contador = 0;
        File archivo = new File(RUTA_COMPLETA);
        if (!archivo.exists()) {
             return 0;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_COMPLETA))) {
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al contar productos: " + e.getMessage());
        }
        return contador;
    }
    
    private static void buscarProductoPorNombre(String nombre) {
        System.out.println("\n--- Buscando producto: " + nombre + " ---");
        boolean encontrado = false;
        
        File archivo = new File(RUTA_COMPLETA);
        if (!archivo.exists()) {
            System.err.println("No se puede buscar. El archivo de productos no existe.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_COMPLETA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Se usa toLowerCase para hacer la busqueda insensible a mayusculas/minusculas
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            
            if (!encontrado) {
                System.out.println("No se encontraron productos con el nombre: " + nombre);
            }
            
        } catch (IOException e) {
            System.err.println("Error de lectura al buscar: " + e.getMessage());
        }
    }

    private static void crearArchivoCategoriasUnicas() {
        Set<String> categoriasUnicas = new HashSet<>();
        final String RUTA_CATEGORIAS = NOMBRE_CARPETA + File.separator + NOMBRE_CATEGORIAS_ARCHIVO;
        
        File archivoProductos = new File(RUTA_COMPLETA);
        if (!archivoProductos.exists()) {
             System.out.println("\nNo se puede generar categorias.txt. El archivo de productos no existe.");
             return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_COMPLETA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 2) { 
                    categoriasUnicas.add(partes[2].trim()); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer categorias: " + e.getMessage());
            return;
        }

        System.out.println("\n--- Generando archivo categorias.txt ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_CATEGORIAS))) {
            for (String categoria : categoriasUnicas) {
                writer.write(categoria);
                writer.newLine();
            }
            System.out.println("Archivo '" + NOMBRE_CATEGORIAS_ARCHIVO + "' generado con " + categoriasUnicas.size() + " categorias unicas.");
        } catch (IOException e) {
            System.err.println("Error al escribir categorias.txt: " + e.getMessage());
        }
    }
    
    private static void hacerRespaldo() {
        final String NOMBRE_RESPALDO = "productos_backup.txt";
        Path origen = Paths.get(RUTA_COMPLETA);
        Path destino = Paths.get(NOMBRE_CARPETA + File.separator + NOMBRE_RESPALDO);
        
        File archivoOrigen = new File(RUTA_COMPLETA);
        if (!archivoOrigen.exists()) {
             System.out.println("\nNo se puede crear el respaldo. El archivo de productos no existe.");
             return;
        }

        System.out.println("\n--- Creando Respaldo ---");
        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Respaldo '" + NOMBRE_RESPALDO + "' creado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el respaldo: " + e.getMessage());
        }
    }

    private static void borrarArchivo(Scanner scanner) {
        File archivo = new File(RUTA_COMPLETA);
        
        if (archivo.exists()) {
            System.out.print("\nEstas seguro de que deseas eliminar " + NOMBRE_ARCHIVO + "? (si/no): ");
            String confirmacion = scanner.nextLine().trim().toLowerCase();
            
            if (confirmacion.equals("si")) {
                if (archivo.delete()) {
                    System.out.println("El archivo " + NOMBRE_ARCHIVO + " ha sido eliminado correctamente.");
                } else {
                    System.err.println("No se pudo eliminar el archivo " + NOMBRE_ARCHIVO + ". Puede estar siendo usado.");
                }
            } else {
                System.out.println("Eliminacion cancelada por el usuario.");
            }
        } else {
            System.out.println("\nEl archivo " + NOMBRE_ARCHIVO + " ya no existe o nunca fue creado.");
        }
    }
}