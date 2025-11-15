<%--
    Este archivo redirige al usuario desde la raíz del proyecto
    directamente al servlet controlador para mostrar la lista.
--%>
<%
    response.sendRedirect("ContactoServlet?accion=listar");
%>