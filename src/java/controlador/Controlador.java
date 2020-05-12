/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Empleado;
import modelo.EmpleadoDao;

/**
 *
 * @author Humberto Manjarres
 */
public class Controlador extends HttpServlet {

    HttpSession sesion;
    Empleado emp;
    EmpleadoDao daoEmpleados;
    List<Empleado> listaEmpleados = new ArrayList<>();
    String identificacion = "";

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
        response.setContentType("text/html;charset=UTF-8");
        daoEmpleados = new EmpleadoDao();

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        //Sistema de Ventas en Java Web - Patron MVC y MySQL - Modulo Mantenimiento MINUTO 16:40
        if (menu.equals("empleados")) {
            switch (accion) {
                case "listar":
                    try {
                        listaEmpleados = daoEmpleados.listar();
                        request.setAttribute("lista_empleados", listaEmpleados);
                        //request.setAttribute("nombreBoton", "Guardar");
                        //request.setAttribute("botonDisabledUpdate", "disabled");
                    } catch (SQLException ex) {
                        System.out.println("Error al Listar Empleados-->" + ex);
                    }
                    break;
                case "Agregar":
                    System.out.println("agregar");
                    try {
                        datosRegistrar(request, response, "agregar");
                        request.getRequestDispatcher("Controlador?menu=empleados&accion=listar").forward(request, response);
                        //request.setAttribute("botonDisabledUpdate", "disabled");
                    } catch (Exception e) {
                        System.out.println("Error al Agregar-->" + e);
                    }
                    break;
                case "editar":

                    try {
                        identificacion = request.getParameter("id");
                        Empleado e = daoEmpleados.consultar(identificacion);
                        request.setAttribute("e", e);
                    } catch (Exception ex) {
                        System.out.println("Manejar error consultar desde editar-->"+ex);
                    }
                    
                    request.setAttribute("botonDisabledAdd", "disabled");
                    System.out.println("deshabilitar boton actualizar");
                    request.setAttribute("botonDisabledUpdate", "");
                    request.getRequestDispatcher("Controlador?menu=empleados&accion=listar").forward(request, response);//para que aparezca la tabla con datos

                    break;
                case "Actualizar":
                    try {
                        datosRegistrar(request, response, "editar");
                        request.setAttribute("botonDisabledAdd", "");
                        request.getRequestDispatcher("Controlador?menu=empleados&accion=listar").forward(request, response);
                    } catch (Exception ex) {
                        System.out.println("Error al Actualizar--->" + ex);
                    }
                    break;
                case "eliminar":
                    try {
                        identificacion = request.getParameter("id");
                        System.out.println("empleado a eliminar-->" + identificacion);
                        String respuesta = daoEmpleados.eliminar(identificacion);
                        request.getRequestDispatcher("Controlador?menu=empleados&accion=listar").forward(request, response);
                    } catch (Exception ex) {
                        System.out.println("error a eliminar-->" + ex);
                    }
                    break;

            }
            request.getRequestDispatcher("vistas/empleados.jsp").forward(request, response);
        }
        if (menu.equals("vehiculos")) {
            System.out.println("ventana vehiculos");
            request.getRequestDispatcher("vistas/vehiculos.jsp").forward(request, response);
        }
        
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }

    }

    public void datosRegistrar(HttpServletRequest request, HttpServletResponse response, String accion) {
        String respuesta = "";
        String identificacion = request.getParameter("txtIdentificacion");
        String nombre = request.getParameter("txtNombre");
        String password = request.getParameter("txtPass");
        String cargo = request.getParameter("txtCargo");
        int salario = Integer.parseInt(request.getParameter("txtSalario"));
        String estado = request.getParameter("txtEstado");
        emp = new Empleado();
        emp.setIdentificacion(identificacion);
        emp.setNombre(nombre);
        emp.setPass(password);
        emp.setCargo(cargo);
        emp.setSalario(salario);
        emp.setEstado(estado);
        daoEmpleados = new EmpleadoDao();
        try {
            if (accion.equals("agregar")) {
                respuesta = daoEmpleados.agregar(emp);
            } else if (accion.equals("editar")) {
                respuesta = daoEmpleados.editar(emp);
            }
            if (respuesta.equals("ok")) {
                //manejar mensajes agregado con exito 
            }

        } catch (SQLException e) {
            System.out.println("Error datos Registrar-->" + e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
