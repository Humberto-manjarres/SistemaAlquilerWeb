/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.xml.internal.ws.client.RequestContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ValidarUsuario extends HttpServlet {

    EmpleadoDao empleadoDao;
    Empleado empleado;
    HttpSession sesion;

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        validar(request, response);
    }

    public void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        empleadoDao = new EmpleadoDao();
        empleado = new Empleado();

        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {

            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            empleado = empleadoDao.validar(user, pass);
            if (empleado.getNombre() != null) {
                sesion = request.getSession(true);
                sesion.setAttribute("empleado", empleado);
                request.setAttribute("emp", empleado);

                request.getRequestDispatcher("Controlador?menu=principal").forward(request, response);
            } else {
                System.out.println("usuario no existe ");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        } else if (accion.equals("Salir")) {

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValidarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValidarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
