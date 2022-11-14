/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Manager;
import domain.Issue;
import domain.SpareParts;
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
public class manageSparePartsInfoHandler extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            //display table
            if(request.getParameter("action").equals("viewSpareParts"))
            {
                
                SpareParts S = new SpareParts();
            
            String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<caption>SpareParts List</caption>";
            output += "<thead><tr><th> Parts ID </th><th> Parts Name </th><th> Price </th><th> Update </th> </tr></thead><tbody>";
            
            
            try{
                ArrayList<SpareParts> arraySP = S.selectSpareParts();
                
                for(int x =0; x<arraySP.size(); x++)
                {
                    output += "<tr><td><p>"+arraySP.get(x).getPartsID()+"</p></td>";
                    output += "<td><p>"+arraySP.get(x).getName()+"</p></td>";
                    output += "<td><p>"+arraySP.get(x).getPrice()+"</p></td>";
                    
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='update' data-id1='"+ arraySP.get(x).getPartsID() + "' >Update</button></td>";
                    
                    
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(manageSparePartsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //create spareparts
            if (request.getParameter("action").equals("createSpareParts"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                
                   
                
                try{
                    
                    SpareParts SP = new SpareParts();
                    SP = SP.createSpareParts(id,name,price);
                
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully create SpareParts');");
                    out.println("location='manageSpareParts.jsp';");
                    out.println("</script>");
                    
                }catch(SQLException ex){
                    
                }
                
            }
            
            if(request.getParameter("action").equals("updateSpareParts"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                
                try{
                    
                    SpareParts SP = new SpareParts();
                    SP = SP.updateSpareParts(id,name,price);
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully update SpareParts');");
                    out.println("location='manageSpareParts.jsp';");
                    out.println("</script>");
                }catch(SQLException ex){
                    
                }
            }
            
            if(request.getParameter("action").equals("getPartsID"))
            {
                int partsID = Integer.parseInt(request.getParameter("partsID"));
                out.print(partsID);
                SpareParts SP = new SpareParts();
                
                SP = SP.getSpareParts(partsID);
                
                 request.getSession().setAttribute("partsObj",SP);
                
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(manageSparePartsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(manageSparePartsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
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
