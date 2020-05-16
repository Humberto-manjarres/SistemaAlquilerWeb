<%-- 
    Document   : clientes
    Created on : 15/05/2020, 10:18:25 AM
    Author     : Humberto Manjarres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="ControladorCliente?menu=clientes" method="POST" name="formCliente">
                        <div class="form-group">
                            <label>Prestamo: </label>
                            <input type="text" value="" name="txtPrestamo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Porcentaje: </label>
                            <input type="text" value="" name="txtPorcentaje" class="form-control">%
                        </div>
                        <div class="form-group">
                            <label>Nro Cuotas: </label>
                            <input type="text" value="" name="txtNcuotas" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Tiempo pago: </label>
                            <select name="opTiempoPago" class="form-control">
                                <option value="0" disable>Seleccione</option> 
                                <option value="1">Quincenal</option> 
                                <option value="2">Mensual</option>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Calcular" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
