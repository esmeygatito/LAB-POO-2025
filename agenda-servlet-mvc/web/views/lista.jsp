<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agenda de Contactos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 4px; color: white; margin-right: 5px; }
        .btn-nuevo { background-color: #007bff; }
        .btn-editar { background-color: #ffc107; color: black; }
        .btn-eliminar { background-color: #dc3545; }
    </style>
</head>
<body>

    <h1>Agenda de Contactos</h1>
    
    <p>
        <a href="ContactoServlet?accion=nuevo" class="btn btn-nuevo">Nuevo Contacto</a>
    </p>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Sexo</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Tipo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="contacto" items="${listaContactos}">
                <tr>
                    <td><c:out value="${contacto.id}" /></td>
                    <td>
                        <c:out value="${contacto.nombre}" />
                        <c:out value="${contacto.apellidoPaterno}" />
                        <c:out value="${contacto.apellidoMaterno}" />
                    </td>
                    <td><c:out value="${contacto.sexo}" /></td>
                    <td><c:out value="${contacto.telefono}" /></td>
                    <td><c:out value="${contacto.direccion}" /></td>
                    <td><c:out value="${contacto.tipoContacto}" /></td>
                    <td>
                        <a href="ContactoServlet?accion=editar&id=${contacto.id}" class="btn btn-editar">Editar</a>
                        <a href="ContactoServlet?accion=eliminar&id=${contacto.id}" 
                           class="btn btn-eliminar"
                           onclick="return confirm('¿Estás seguro de que deseas eliminar este contacto?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>