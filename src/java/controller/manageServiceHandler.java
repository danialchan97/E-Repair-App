/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Service;
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
public class manageServiceHandler extends HttpServlet {

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
            
            if(request.getParameter("action").equals("viewService"))
            {
                Service S = new Service();
                String output = "";
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<jsp:include page=\"table.jsp\"/>");
                
                output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
                output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
                output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
                output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
                output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
                output += "<caption>Service List</caption>";
                output += "<thead><tr><th> Service ID </th><th> Service Description </th><th> Price </th><th> Update </th> </tr></thead><tbody>";
                
                try{
                ArrayList<Service> arraySP = S.selectService();
                
                for(int x =0; x<arraySP.size(); x++)
                {
                    output += "<tr><td><p>"+arraySP.get(x).getServiceID()+"</p></td>";
                    output += "<td><p>"+arraySP.get(x).getServiceDesc()+"</p></td>";
                    output += "<td><p>"+arraySP.get(x).getPrice()+"</p></td>";
                    
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='update' data-id1='"+ arraySP.get(x).getServiceID() + "' >Update</button></td>";
     
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(manageServiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if(request.getParameter("action").equals("createService"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                
                Service S = new Service();
                S = S.createService(id,name,price);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully create Service');");
                out.println("location='manageService.jsp';");
                out.println("</script>");
            }
            
            if(request.getParameter("action").equals("getServiceID"))
            {
                 int serviceID = Integer.parseInt(request.getParameter("serviceID"));
                
                Service S = new Service();
                
                S = S.getService(serviceID);
                
                out.print(S.getServiceDesc());
                
                 request.getSession().setAttribute("partsObj",S);
            }
            
            
            if(request.getParameter("action").equals("updateService"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                
                try{
                    
                    Service S = new Service();
                    S = S.updateService(id,name,price);
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully update Service!');");
                    out.println("location='manageService.jsp';");
                    out.println("</script>");
                }catch(SQLException ex){
                    
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(manageServiceHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(manageServiceHandler.class.getName()).log(Level.SEVERE, null, ex);
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
