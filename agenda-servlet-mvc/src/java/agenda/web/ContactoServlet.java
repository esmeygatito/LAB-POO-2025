package agenda.web;

import agenda.dao.ContactoDAO;
import agenda.model.Contacto;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador (Servlet) que gestiona las peticiones para el CRUD de Contactos.
 */
public class ContactoServlet extends HttpServlet {

    private ContactoDAO contactoDAO;

    @Override
    public void init() throws ServletException {
        contactoDAO = new ContactoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar"; // Acción por defecto
        }

        try {
            switch (accion) {
                case "nuevo":
                    mostrarFormulario(request, response, true); // true = nuevo
                    break;
                case "editar":
                    mostrarFormulario(request, response, false); // false = editar
                    break;
                case "eliminar":
                    eliminarContacto(request, response);
                    break;
                case "listar":
                default:
                    listarContactos(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // POST se usa para insertar o actualizar
        String accion = request.getParameter("accion");

        try {
            switch (accion) {
                case "insertar":
                    insertarContacto(request, response);
                    break;
                case "actualizar":
                    actualizarContacto(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listarContactos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contacto> listaContactos = contactoDAO.listarTodos();
        request.setAttribute("listaContactos", listaContactos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response, boolean esNuevo)
            throws ServletException, IOException {
        
        if (!esNuevo) {
            // Es editar, necesitamos cargar el contacto
            int id = Integer.parseInt(request.getParameter("id"));
            Contacto contacto = contactoDAO.buscarPorId(id);
            request.setAttribute("contacto", contacto);
        }
        // Si es nuevo, simplemente se reenvía al form sin el atributo "contacto"
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Leer parámetros del formulario
        Contacto contacto = leerDatosFormulario(request);
        contactoDAO.insertar(contacto);
        
        // Redirigir a la lista (para evitar re-envío del formulario con F5)
        response.sendRedirect("ContactoServlet?accion=listar");
    }

    private void actualizarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Leer parámetros del formulario, incluido el ID
        int id = Integer.parseInt(request.getParameter("id"));
        Contacto contacto = leerDatosFormulario(request);
        contacto.setId(id); // Asignar el ID para la actualización
        
        contactoDAO.actualizar(contacto);
        
        // Redirigir a la lista
        response.sendRedirect("ContactoServlet?accion=listar");
    }

    private void eliminarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        contactoDAO.eliminar(id);
        
        // Redirigir a la lista
        response.sendRedirect("ContactoServlet?accion=listar");
    }


    private Contacto leerDatosFormulario(HttpServletRequest request) {
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String tipoContacto = request.getParameter("tipoContacto");
        
        return new Contacto(nombre, apellidoPaterno, apellidoMaterno, sexo, telefono, direccion, tipoContacto);
    }
}