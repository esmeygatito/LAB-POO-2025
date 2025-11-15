<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulario de Contacto</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }
        .container { max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input[type="text"],
        .form-group select { width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; }
        .form-group .radio-group { margin-top: 5px; }
        .form-group .radio-group label { margin-right: 15px; font-weight: normal; }
        .btn-submit { background-color: #28a745; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        .btn-cancel { background-color: #6c757d; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; text-decoration: none; display: inline-block; }
    </style>
</head>
<body>

    <div class="container">
        
        <!-- Título dinámico -->
        <c:if test="${contacto == null}">
            <h2>Nuevo Contacto</h2>
        </c:if>
        <c:if test="${contacto != null}">
            <h2>Editar Contacto</h2>
        </c:if>

        <form action="ContactoServlet" method="post">
            
            <!-- Acción (Insertar o Actualizar) -->
            <c:if test="${contacto == null}">
                <input type="hidden" name="accion" value="insertar" />
            </c:if>
            <c:if test="${contacto != null}">
                <input type="hidden" name="accion" value="actualizar" />
                <input type="hidden" name="id" value="<c:out value='${contacto.id}' />" />
            </c:if>

            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="<c:out value='${contacto.nombre}' />" required>
            </div>

            <div class="form-group">
                <label for="apellidoPaterno">Apellido Paterno:</label>
                <input type="text" id="apellidoPaterno" name="apellidoPaterno" value="<c:out value='${contacto.apellidoPaterno}' />">
            </div>

            <div class="form-group">
                <label for="apellidoMaterno">Apellido Materno:</label>
                <input type="text" id="apellidoMaterno" name="apellidoMaterno" value="<c:out value='${contacto.apellidoMaterno}' />">
            </div>

            <div class="form-group">
                <label>Sexo:</label>
                <div class="radio-group">
                    <input type="radio" id="sexoM" name="sexo" value="M" ${contacto.sexo == 'M' ? 'checked' : ''}>
                    <label for="sexoM">Masculino</label>
                    <input type="radio" id="sexoF" name="sexo" value="F" ${contacto.sexo == 'F' ? 'checked' : ''}>
                    <label for="sexoF">Femenino</label>
                    <input type="radio" id="sexoO" name="sexo" value="O" ${contacto.sexo == 'O' ? 'checked' : ''}>
                    <label for="sexoO">Otro</label>
                </div>
            </div>

            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="<c:out value='${contacto.telefono}' />">
            </div>

            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="<c:out value='${contacto.direccion}' />">
            </div>

            <div class="form-group">
                <label for="tipoContacto">Tipo de Contacto:</label>
                <select id="tipoContacto" name="tipoContacto">
                    <option value="CASA" ${contacto.tipoContacto == 'CASA' ? 'selected' : ''}>Casa</option>
                    <option value="TRABAJO" ${contacto.tipoContacto == 'TRABAJO' ? 'selected' : ''}>Trabajo</option>
                </select>
            </div>

            <button type="submit" class="btn-submit">Guardar</button>
            <a href="ContactoServlet?accion=listar" class="btn-cancel">Cancelar</a>

        </form>
    </div>

</body>
</html>