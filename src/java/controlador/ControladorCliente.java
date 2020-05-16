/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Humberto Manjarres
 */
public class ControladorCliente extends HttpServlet {

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
        
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        
        if (menu.equals("clientes")) {
            switch (accion){
            
                case "listar":
                    
                    break;
                    
                case "Calcular":
                    
                    int prestamo=Integer.parseInt(request.getParameter("txtPrestamo"));
                    float cuota=Float.parseFloat(request.getParameter("txtNcuotas"));
                    float porcentaje=Float.parseFloat(request.getParameter("txtPorcentaje"));
                    //String tiempo=request.getParameter("txtTiempo");
                    String opcionPago=request.getParameter("opTiempoPago");
                    System.out.println("op->"+opcionPago);
                    double valorProcentaje=prestamo*porcentaje/100;
                    
                    double t = 0,redondeo;
                    if (opcionPago.equals("1")) {
                        redondeo=Math.round(cuota/2);
                        t=redondeo;
                    }else if(opcionPago.equals("2")){
                        t=cuota;
                    }
                    //System.out.println("tiempo ->"+t);
                    
                    double totalIntereses=valorProcentaje * t;//valor total intereses
                    
                    double capitalCompleto=prestamo+totalIntereses;//capitalización
                    double cuotasPagar=capitalCompleto/cuota;//valor cuota
//                    
////                    LocalDateTime toDateTime = LocalDateTime.now();
////                    
//                    System.out.println("prestamo -> "+prestamo);
                    System.out.println("porcentaje -> "+ valorProcentaje+" pesos");
                    System.out.println("total intereses -> "+totalIntereses);
                    System.out.println(cuota+" cuotas "+cuotasPagar);
                    System.out.println("total a pagar -> "+capitalCompleto);
//                    //System.out.println("LocalDateTime -> "+toDateTime);
                    break;
            }
            request.getRequestDispatcher("vistas/clientes.jsp").forward(request, response);
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
