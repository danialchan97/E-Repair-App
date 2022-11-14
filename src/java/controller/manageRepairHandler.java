/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Device;
import domain.Manager;
import domain.Issue;
import domain.Repair;
import domain.RepairIssue;
import domain.RepairService;
import domain.Repair_SpareParts;
import domain.Service;
import domain.SpareParts;
import domain.Staff;
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
public class manageRepairHandler extends HttpServlet {

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
            
            if(request.getParameter("action").equals("updateRepairStatus"))
            {
                int repairID = Integer.parseInt(request.getParameter("repairID"));
                
               // Technician T = new Technician();
                Repair R = new Repair();
                R = R.updateRepairStatus(repairID);
                
                if(R.getRepairStatus().equalsIgnoreCase("repaired")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully updated repair status!');");
                    out.println("location='viewRepairDetails.jsp';");
                    out.println("</script>");
                }
                else
                {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Fail updating repair status!');");
                    out.println("location='viewRepairDetails.jsp';");
                    out.println("</script>");
                }
                
            }
            
            
            if(request.getParameter("action").equals("updatePaymentStatus")){
                
                int repairID = Integer.parseInt(request.getParameter("repairID"));
                
                //out.print(repairID);
                
                //Technician T = new Technician();
                Repair R = new Repair();
                R = R.updatePaymentStatus(repairID);
                
                if(R.getPaymentStatus().equalsIgnoreCase("paid")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Successfully updated repair status!');");
                    out.println("location='viewRepairDetails.jsp';");
                    out.println("</script>");
                }
                else
                {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Fail updating repair status!');");
                    out.println("location='viewRepairDetails.jsp';");
                    out.println("</script>");
                }
                
            }
            
            
            
            //create device
            if(request.getParameter("action").equals("createDevice"))
            {
                String id = request.getParameter("id");
                String model = request.getParameter("model");
                String brand = request.getParameter("brand");
                String pass = request.getParameter("pass");
                String custID = request.getParameter("custID");
                
                
                Device D = new Device();
                D = D.createDevice(id,model,brand,pass,custID);
    
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully create device');");
                out.println("location='dashboard.jsp';");
                out.println("</script>");
               
            }
            
            // view technician details
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
            output += "<thead><tr><th> Staff ID </th><th> Staff Name </th><th> Job </th><th>Assign Job</th></thead><tbody>";
                
            try{
                ArrayList<Technician> arrayT = T.selectTechnician();
                
                for(int x =0; x<arrayT.size(); x++)
                {
                    output += "<tr><td><p>"+arrayT.get(x).getID()+"</p></td>";
                    output += "<td><p>"+arrayT.get(x).getName()+"</p></td>";
                    output += "<td><p>"+arrayT.get(x).getJob()+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'assignJob' id='btn_view' data-id1='"+ arrayT.get(x).getID() + "' >Assign</button></td>";
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(viewTechnicianDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
            
            //get deviceID
            if (request.getParameter("action").equals("getDeviceID")) {
                
                String deviceID = request.getParameter("deviceID");
                //String custID = (String) request.getSession().getAttribute("custID");

                request.getSession().setAttribute("deviceID", deviceID);
                //out.println("<script type=\"text/javascript\">");
                //out.println("alert('"+custID+"'");
                //out.println("location='dashboard.jsp';");
                //out.println("</script>");
                
            }
            

            
            //create repair
            if(request.getParameter("action").equals("createRepair"))
            {
                String deviceID = (String) request.getSession().getAttribute("deviceID");
                String techID = request.getParameter("techID");
                String custID = (String) request.getSession().getAttribute("custID");
                
                //out.println("deviceID ="+deviceID);
                //out.println("techID ="+techID);
                //out.print("custID = "+custID);
                
                //Manager M = new Manager();
                Repair R = new Repair();
                R = R.createRepair(deviceID, techID, custID);
               
            }
            
            // get repair id
              if (request.getParameter("action").equals("getRepairID")) {
                
                int repairID = Integer.parseInt(request.getParameter("repairID"));
                //String custID = (String) request.getSession().getAttribute("custID");

                request.getSession().setAttribute("repairID", repairID);
            }
            
            
            if (request.getParameter("action").equals("chooseSpareParts")) {
                int partsID = Integer.parseInt(request.getParameter("partsID"));

                int repairID = (int) request.getSession().getAttribute("repairID");
                
               
                Repair_SpareParts R = new Repair_SpareParts();
                R = R.chooseSpareParts(partsID,repairID);
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully choose spareparts');");
                out.println("location='viewRepairDetails.jsp';");
                out.println("</script>");
                
                
            }
            
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
            output += "<caption>Choose SpareParts</caption>";
            output += "<thead><tr><th> Parts ID </th><th> Parts Name </th><th>Price</th><th>Select</th></thead><tbody>";
            
            try{
                 ArrayList<SpareParts> arrayS = S.viewSpareParts();
                
                 //out.println(arrayS.size());
                 
                for(int x =0; x<arrayS.size(); x++)
                {
                    output += "<tr><td><p>"+arrayS.get(x).getPartsID()+"</p></td>";
                    output += "<td><p>"+arrayS.get(x).getName()+"</p></td>";
                    output += "<td><p>"+arrayS.get(x).getPrice()+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'assignJob' id='btn_select' data-id1='"+ arrayS.get(x).getPartsID() + "' >Select</button></td>";
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(viewTechnicianDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            if (request.getParameter("action").equals("chooseIssue")) {
                int issueID = Integer.parseInt(request.getParameter("issueID"));

                int repairID = (int) request.getSession().getAttribute("repairID");
                
                //out.print(problemID);
                
               
                RepairIssue R = new RepairIssue();
                R = R.chooseIssue(issueID,repairID);
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully choose issueID');");
                out.println("location='viewRepairDetails.jsp';");
                out.println("</script>");
                
                
            }
      
            
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
            output += "<caption>Choose Device Issue</caption>";
            output += "<thead><tr><th> Issue ID </th><th> Issue Details </th><th> Price </th><th>Choose</th></thead><tbody>";
            
            try{
                 ArrayList<Issue> arrayP = P.viewIssue();
                
                 //out.println(arrayP.size());
                 
                for(int x =0; x<arrayP.size(); x++)
                {
                    output += "<tr><td><p>"+arrayP.get(x).getIssueID()+"</p></td>";
                    output += "<td><p>"+arrayP.get(x).getDetails()+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'assignJob' id='btn_select1' data-id1='"+ arrayP.get(x).getIssueID() + "' >Select</button></td>";
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(viewTechnicianDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            if (request.getParameter("action").equals("chooseService")) {
                int serviceID = Integer.parseInt(request.getParameter("serviceID"));

                int repairID = (int) request.getSession().getAttribute("repairID");
                
                //out.print(problemID);
                
               
                RepairService R = new RepairService();
                R = R.chooseService(serviceID,repairID);
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Successfully choose Service');");
                out.println("location='viewRepairDetails.jsp';");
                out.println("</script>");
                
                
            }
            
            if(request.getParameter("action").equals("viewService"))
            {
               
               Service S = new Service();
                
               String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<caption>Choose Repair Service</caption>";
            output += "<thead><tr><th> Service ID </th><th> Service Description </th><th> Price </th><th>Choose</th></thead><tbody>";
            
            ArrayList<Service> arrayP = S.viewService();
            //out.println(arrayP.size());
            
            for(int x =0; x<arrayP.size(); x++)
            {
                output += "<tr><td><p>"+arrayP.get(x).getServiceID()+"</p></td>";
                output += "<td><p>"+arrayP.get(x).getServiceDesc()+"</p></td>";
                output += "<td><p>"+arrayP.get(x).getPrice()+"</p></td>";
                output += "<td><button type='submit' class='w3-button w3-custom' name = 'assignJob' id='btn_select1' data-id1='"+ arrayP.get(x).getServiceID() + "' >Select</button></td>";
                output += "</tr>";
            }
            output+= "</tbody></table>";
            out.println(output);
                
                
            }
            
            if(request.getParameter("action").equals("updatePrice"))
            {
                int repairID = (int) request.getSession().getAttribute("repairID");
                Repair R = new Repair();
                //out.print(repairID);
                
                R = R.updatePrice(repairID);
                
                out.println("Successfully update price!");
                
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
            Logger.getLogger(manageRepairHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(manageRepairHandler.class.getName()).log(Level.SEVERE, null, ex);
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
