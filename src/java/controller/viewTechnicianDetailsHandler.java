/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Manager;
import domain.SpareParts;
import domain.Technician;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class viewTechnicianDetailsHandler extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getParameter("action").equals("viewTechnicianDetails"))
            {
                Technician T = new Technician();

                
            String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<thead><tr><th> Staff ID </th><th> Staff Name </th><th> Job </th></thead><tbody>";
                
            try{
                ArrayList<Technician> arrayT = T.selectTechnician();
                
                for(int x =0; x<arrayT.size(); x++)
                {
                    output += "<tr><td><p>"+arrayT.get(x).getID()+"</p></td>";
                    output += "<td><p>"+arrayT.get(x).getName()+"</p></td>";
                    output += "<td><p>"+arrayT.get(x).getJob()+"</p></td>";
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(viewTechnicianDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }

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
