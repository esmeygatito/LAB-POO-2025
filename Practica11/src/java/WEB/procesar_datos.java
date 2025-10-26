/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template

 */

package WEB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**

 *

 * @author esmeg

 */

public class procesar_datos extends HttpServlet {


    /**

     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>

     * methods.

     *

     * @param request servlet request

     * @param response servlet response

     * @throws ServletException if a servlet-specific error occurs

     * @throws IOException if an I/O error occurs

     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String genero = request.getParameter("genero");
        String direccion = request.getParameter("direccion");
        
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Datos Recibidos | Procesar Datos</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 30px; background-color: #e9ebee; }");
            out.println(".container { background: white; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 600px; margin: auto; }");
            out.println("h1 { color: #3b5998; border-bottom: 2px solid #3b5998; padding-bottom: 10px; }");
            out.println("h2 { color: #5cb85c; }");
            out.println("strong { display: inline-block; width: 140px; font-weight: bold; color: #444; }");
            out.println(".dato-recibido { background-color: #f7f7f7; padding: 10px; border-left: 5px solid #5cb85c; margin-bottom: 5px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='container'>");
            
            out.println("<h1>Datos de Registro Procesados</h1>");
            
            out.println("<h2>Bienvenido(a): " + nombre + "</h2>"); 
            out.println("<p>Se han recibido los siguientes datos personales:</p>");

            out.println("<div class='dato-recibido'><p><strong>Email:</strong> " + email + "</p></div>");
            out.println("<div class='dato-recibido'><p><strong>Teléfono:</strong> " + telefono + "</p></div>");
            out.println("<div class='dato-recibido'><p><strong>Fecha Nacimiento:</strong> " + fechaNacimiento + "</p></div>");
            out.println("<div class='dato-recibido'><p><strong>Género:</strong> " + genero + "</p></div>");
            out.println("<div class='dato-recibido'><p><strong>Dirección:</strong> " + direccion + "</p></div>");
            
            out.println("<p style='margin-top: 20px;'><a href='./index.html'>&#8592; Volver al Formulario</a></p>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        }

    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Debe asegurarse de llamar al método que contiene su lógica
    processRequest(request, response);
}

}