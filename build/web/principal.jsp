<%-- 
    Document   : principal
    Created on : 5/05/2020, 10:38:23 AM
    Author     : Humberto Manjarres
--%>
<%@page import="modelo.Empleado"%>
<%
    //Empleado empleado=new Empleado();
    //String nombreUsu=request.getParameter("mensaje");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="font-awesome-4.6.1/css/font-awesome.css" rel="stylesheet" media="screen"/>
        <title>Alquiler Vehiculos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="principal.jsp" style="color: white">
                <img src="imagenes/icon.svg" width="30" height="30" class="d-inline-block align-top" alt="logoCar" loading="lazy">
                YoUrbano
            </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <div class="navbar-nav">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ControladorVehiculo?menu=vehiculos&accion=listar" target="myFrame"><span class="fa fa-car"></span> Vehiculos <span class="sr-only">(current)</span></a>
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ControladorCliente?menu=clientes&accion=listar" target="myFrame"><span class="fa fa-users"></span> Clientes</a>
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#"><span class="fa fa-key"></span> Alquiler</a>
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=empleados&accion=listar" target="myFrame"><span class="fa fa-user"></span> Empleados</a>
                </div>
            </div>
            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario Ingresado    
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#"><img src="imagenes/hombre.png" alt="60" width="60"/></a>
                    <a class="dropdown-item" href="#">${emp.getNombre()}</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="<%= request.getContextPath()%>/ValidarUsuario?accion=salir">Salir</a>
                </div>
            </div>
        </nav>

        <div class="m-4" style="height: 650px">
            <iframe style="height: 100%;width: 100%;border: none"  name="myFrame"></iframe>
        </div>        

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
