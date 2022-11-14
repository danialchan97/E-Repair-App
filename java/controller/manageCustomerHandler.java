/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Brand;
import domain.Customer;
import domain.Device;
import domain.Manager;
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
public class manageCustomerHandler extends HttpServlet {

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
            
            //display all customer
            if(request.getParameter("action").equals("viewCustomer"))
            {
                Customer C = new Customer();
                
            String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<caption>Registered Customer</caption>";
            output += "<thead><tr><th> Customer ID </th><th>  Name </th><th> Email </th><th> Phone </th><th> Address </th><th>Create Device</th><th> View Detailed Customer </th></thead><tbody>";
                
            try{
                ArrayList<Customer> arrayC = C.selectCustomer();
                
                for(int x =0; x<arrayC.size(); x++)
                {
                    output += "<tr><td><p>"+arrayC.get(x).getCustID()+"</p></td>";
                    output += "<td><p>"+arrayC.get(x).getName()+"</p></td>";
                    output += "<td><p>"+arrayC.get(x).getEmail()+"</p></td>";
                    output += "<td><p>"+arrayC.get(x).getPhone()+"</p></td>";
                    output += "<td><p>"+arrayC.get(x).getAddress()+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'createDevice' id='btn_view1' data-id1='"+ arrayC.get(x).getCustID() + "' >Create</button>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'viewDetailedRepair' id='btn_view' data-id1='"+ arrayC.get(x).getCustID() + "' >View </button>";
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
                
                
            }catch (SQLException ex) {
                    Logger.getLogger(viewTechnicianDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
            //get customerID
            if (request.getParameter("action").equals("getCustID")) {
                String custID = request.getParameter("custID");

                request.getSession().setAttribute("custID", custID);
            }
            
            //view a customer's devices
            if(request.getParameter("action").equals("viewDetailedCustomer"))
            {
                
                //out.println("jksndn");
                String id = (String) request.getSession(false).getAttribute("custID");

                Device D = new Device();
                
                ArrayList<Device> arrayD = new ArrayList<Device>();
                
                arrayD = D.getCustomerDevice(id);
                
                String output ="";
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<jsp:include page=\"table.jsp\"/>");
            output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
            output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
            output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
            output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
            output += "<thead><tr><th> Device ID </th><th>  Model </th><th> Brand </th><th> Passcode </th><th> Customer ID </th><th> Repair </th></thead><tbody>";
            
            for(int x =0; x<arrayD.size(); x++)
                {
                    output += "<tr><td><p>"+arrayD.get(x).getDeviceID()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDeviceModel()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDeviceBrand()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDevicePasscode()+"</p></td>";
                    output += "<td><p>"+id+"</p></td>";
                    
                    String deviceID = arrayD.get(x).getDeviceID();
                    Device D1 = new Device();
                    
                    int a = D1.checkDevice(deviceID);
                    
                    if(a == 0){
                        output += "<td><button type='submit' class='w3-button w3-custom' name = 'createRepair' id='btn_device' data-id1='"+ arrayD.get(x).getDeviceID() + "' >Create</button>";
                    }
                    else if(a == 1)
                    {
                        output += "<td><button type='submit' class='w3-button w3-custom' name = 'createRepair' id='btn_device' data-id1='"+ arrayD.get(x).getDeviceID() + "' disabled>Create</button>";
                    }
                    
                    
                    output += "</tr>";
                }
                output+= "</tbody></table>";
                out.println(output);
            
                
                
            }
            
            
            // create customer
            if(request.getParameter("action").equals("createCustomer")){
                
                String custID = request.getParameter("id");
                String custName = request.getParameter("name");
                String custEmail = request.getParameter("email");
                String custPhone = request.getParameter("phone");
                String custAdd = request.getParameter("add");
                
                //String pos = (String) request.getSession().getAttribute("position");
                
                //Staff S = new Staff();
                Customer C = new Customer();
                
                
                    try{
                        C = C.createCustomer(custID,custName,custEmail,custPhone,custAdd);
                    
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Successfully create customer');");
                        out.println("location='dashboard.jsp';");
                        out.println("</script>");
                    
                        // out.println(C.getName());
                    
                    }catch (SQLException ex) {
                        Logger.getLogger(manageCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
            }
            
            // for display when creating device
            if(request.getParameter("action").equals("getBrand"))
            {
                ArrayList<Brand> arrayB= new ArrayList<Brand>();

                Brand B = new Brand();
                arrayB = B.getBrand();
                
                String output ="";
                output += " <select name='brand' style ='width: 100%; height: 50px;' required>";
                output +="<option value=''>Select Brand</option>";
                
                for(int x=0; x<arrayB.size(); x++)
                {
                    output+= "<option value'"+arrayB.get(x).getName()+"'> "+arrayB.get(x).getName()+" </option>";
                }
                
                output += " </select>";
                out.println(output);
    
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
            Logger.getLogger(manageCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(manageCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
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
