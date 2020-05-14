<%-- 
    Document   : vehiculos
    Created on : 6/05/2020, 02:55:25 PM
    Author     : Humberto Manjarres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="font-awesome-4.6.1/css/font-awesome.css" rel="stylesheet" media="screen"/>
        <title>Vehiculos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="ControladorVehiculo" method="" name="formVehiculos">
                        <div class="form-group">
                            <label>Placa: </label>
                            <input type="text" value="" name="txtPlaca" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Modelo: </label>
                            <input type="date" value="" name="txtModelo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Color: </label>
                            <input type="text" value="" name="txtColor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tipo: </label>
                            <select class="form-control">
                                <option value="0">Seleccionar</option>
                                <option value="1">AUTOMOVIL</option>
                                <option value="2">CAMIONETA</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Marca: </label>
                            <input type="text" value="" name="txtMarca" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Serie: </label>
                            <input type="text" value="" name="txtSerie" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Placa</th>
                            <th>Modelo</th>
                            <th>Color</th>
                            <th>Tipo</th>
                            <th>Serie</th>
                            <th>Marca</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vehiculos" items="${lista_vehiculos}">
                        <tr>
                            <td>${vehiculos.getPlaca()}</td>
                            <td>${vehiculos.getModelo()}</td>
                            <td>${vehiculos.getColor()}</td>
                            <td>${vehiculos.getTipo()}</td>
                            <td>${vehiculos.getSerie()}</td>
                            <td>${vehiculos.getMarca()}</td>
                            <td>
                                <a href="ControladorVehiculo?menu=vehiculo&accion=editar&id=${vehiculo.getPlaca()}" class="btn btn-warning">Editar</a>
                                <a href="ControladorVehiculo?menu=vehiculo&accion=eliminar&id=${vehiculo.getPlaca()}" class="btn btn-danger">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </div>

        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
