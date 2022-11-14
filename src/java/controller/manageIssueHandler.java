/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Manager;
import domain.Issue;
import domain.SpareParts;
import domain.Staff;
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
public class manageIssueHandler extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            if(request.getParameter("action").equals("viewIssue"))
            {
                Issue P = new Issue();
            
            String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<caption>Issue List</caption>";
            output += "<thead><tr><th> Issue ID </th><th> Issue Details </th><th> Update </th> </tr></thead><tbody>";
            
            
            try{
                ArrayList<Issue> arrayP = P.viewIssue();
                
                for(int x =0; x<arrayP.size(); x++)
                {
                    output += "<tr><td><p>"+arrayP.get(x).getIssueID()+"</p></td>";
                    output += "<td><p>"+arrayP.get(x).getDetails()+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='update' data-id1='"+ arrayP.get(x).getIssueID() + "' >Update</button></td>";
                    

                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(manageIssueHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (request.getParameter("action").equals("createIssue"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String details = request.getParameter("details");
                
         
                try{

                    Issue P = new Issue();
                    P = P.createIssue(id,details);

                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Successfully create issue!');");
                        out.println("location='dashboard.jsp';");
                        out.println("</script>");
     
                    
                    
                }catch(SQLException ex){
                    
                }
                
            }
            
            if(request.getParameter("action").equals("getIssueID"))
            {
                int issueID = Integer.parseInt(request.getParameter("issueID"));
                //out.print(problemID);
                Issue P = new Issue();
                
                P = P.getIssue(issueID);
                
                 request.getSession().setAttribute("problemObj",P);
                
            }
            
            if(request.getParameter("action").equals("updateIssue"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String issueDetails = request.getParameter("details");

                
                try{
                   
                    Issue P = new Issue();
                    P = P.updateIssue(id,issueDetails);
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully update Issue!');");
                    out.println("location='manageIssue.jsp';");
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
            Logger.getLogger(manageIssueHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(manageIssueHandler.class.getName()).log(Level.SEVERE, null, ex);
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
