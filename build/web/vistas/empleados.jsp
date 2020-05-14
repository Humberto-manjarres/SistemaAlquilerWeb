<%-- 
    Document   : empleados
    Created on : 6/05/2020, 03:03:36 PM
    Author     : Humberto Manjarres
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="font-awesome-4.6.1/css/font-awesome.css" rel="stylesheet" media="screen"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <div class="row">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=empleados" method="POST" name="formEmpleado">
                        <div class="form-group">
                            <label>Identificacion: </label>
                            <input type="text" value="${e.getIdentificacion()}" name="txtIdentificacion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre: </label>
                            <input type="text" value="${e.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña: </label>
                            <input type="password" value="${e.getPass()}" name="txtPass" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Cargo: </label>
                            <input type="text" value="${e.getCargo()}" name="txtCargo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Salario: </label>
                            <input type="text" value="${e.getSalario()}" name="txtSalario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado: </label>
                             <input type="text" value="${e.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <input type="submit"  ${botonDisabledAdd} name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" ${botonDisabledUpdate} name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Identificacion</th>
                            <th>Nombre</th>
                            <th>Cargo</th>
                            <th>Salario</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleados" items="${lista_empleados}">
                            <tr>
                                <td>${empleados.getIdentificacion()}</td>
                                <td>${empleados.getNombre()}</td>
                                <td>${empleados.getCargo()}</td>
                                <td>${empleados.getSalario()}</td>
                                <td>${empleados.getEstado()}</td>
                                <td>
                                    <a href="Controlador?menu=empleados&accion=editar&id=${empleados.getIdentificacion()}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=empleados&accion=eliminar&id=${empleados.getIdentificacion()}" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>

            </div>
        </div>
        
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
