
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

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

import domain.Manager;
import domain.Issue;
import domain.Repair;
import domain.RepairIssue;
import domain.Repair_SpareParts;
import domain.SpareParts;
import domain.Staff;
import domain.Technician;

import static da.RepairDA.selectRepairDetails;
import domain.Customer;
import domain.Device;
import domain.RepairService;
import domain.Service;

/**
 *
 * @author user
 */
public class viewRepairDetailsHandler extends HttpServlet {

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
            Logger.getLogger(viewRepairDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(viewRepairDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            
            if (request.getParameter("action").equals("viewJob")) {
                Repair     R      = new Repair();
                Device D = new Device();
                Customer C = new Customer();
                String     output = "";

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<jsp:include page=\"table.jsp\"/>");
                
                output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
                output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
                output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
                output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
                output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"90%\">";
                output += "<caption>Job List</caption>";
                output +=
                    "<thead><tr><th> Repair ID </th><th> Date Receive </th><th> Date Return </th><th>Total Price (RM)</th><th>Repair Status</th>"
                    + "<th>Payment Status</th><th>Customer ID</th><th>Device ID</th><th>Update Repair Status</th><th>Update Payment Status</th><th>View Detailed Repair</th></tr></thead><tbody>";

                String            staffID = (String) request.getSession(false).getAttribute("staffid");
                
                
                ArrayList<Repair> arrayR  = R.viewRepairTechnician(staffID);
                //ArrayList<String> arrayN = D.selectDeviceID(staffID);
                String deviceID;
                String custID;
                String nani = "-";

                for (int x = 0; x < arrayR.size(); x++) {
                    

                    output += "<tr><td><p>" + arrayR.get(x).getRepairID() + "</p></td>";
                    
                    deviceID = D.selectDeviceID(arrayR.get(x).getRepairID());
                    custID = C.selectCustID(arrayR.get(x).getRepairID());
                    
                    output += "<td><p>" + arrayR.get(x).getDateReceive() + "</p></td>";
                    
                    if(arrayR.get(x).getDateReturn() != null)
                        output += "<td><p>" + arrayR.get(x).getDateReturn() + "</p></td>";
                    else
                        output += "<td><p>" + nani + "</p></td>";

                    output += "<td><p>" + arrayR.get(x).getTotalPrice() + "</p></td>";
                    output += "<td><p>" + arrayR.get(x).getRepairStatus() + "</p></td>";
                    output += "<td><p>" + arrayR.get(x).getPaymentStatus() + "</p></td>";
                    output += "<td><p>" + custID + "</p></td>";
                    output += "<td><p>" + deviceID + "</p></td>";

                    if (arrayR.get(x).getRepairStatus().equalsIgnoreCase("repaired")) {
                        output +=
                            "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='btn_update' data-id1='"
                            + arrayR.get(x).getRepairID() + "' disabled>Update</button>";
                    } else {
                        output +=
                            "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='btn_update' data-id1='"
                            + arrayR.get(x).getRepairID() + "'>Update</button>";
                    }

                    if (arrayR.get(x).getPaymentStatus().equalsIgnoreCase("Paid")
                            || arrayR.get(x).getRepairStatus().equalsIgnoreCase("repairing")) {
                        output +=
                            "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='btn_update1' data-id1='"
                            + arrayR.get(x).getRepairID() + "' disabled>Update</button>";
                    } else {
                        output +=
                            "<td><button type='submit' class='w3-button w3-custom' name = 'update' id='btn_update1' data-id1='"
                            + arrayR.get(x).getRepairID() + "' >Update</button>";
                    }

                    output +=
                        "<td><button type='submit' class='w3-button w3-custom' name = 'viewDetailedRepair' id='btn_view' data-id1='"
                        + arrayR.get(x).getRepairID() + "' >View</button>";
                    output += "</tr>";
                }

                output += "</tbody></table>";
                out.println(output);
            }
            
            //display repair details

            if (request.getParameter("action").equals("viewRepairDetails")) {
                Repair  R      = new Repair();
                Manager M      = new Manager();
                Staff   S      = new Staff();
                Customer C = new Customer();
                String  output = "";

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<jsp:include page=\"table.jsp\"/>");
                output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
                output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
                output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
                output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
                output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"90%\">";
                output += "<caption>All Repair List</caption>";
                output +=
                    "<thead><tr><th> Repair ID </th><th>Device ID</th><th>Cust ID</th><th> Date Receive </th><th> Date Return </th><th>Total Price (RM)</th><th>Repair Status</th>"
                    + "<th>Payment Status</th><th>Staff Name</th></tr></thead><tbody>";

                ArrayList<Repair> arrayR = R.selectRepairDetails();
                ArrayList<Staff>  arrayS = S.selectStaff();
                //ArrayList<Device> arrayN = M.selectAllDeviceID();
                ArrayList<Customer> arrayC = C.selectAllCustID();
               
                Device D = new Device();
                String dReturn = "   -    ";
     
                
                for (int x = 0; x < arrayR.size(); x++) {
                    
                    D = D.selectAllDeviceID(arrayR.get(x).getRepairID());
                    
                    
                    
                    output += "<tr><td><p>" + arrayR.get(x).getRepairID() + "</p></td>";
                    output += "<td><p>" + D.getDeviceID() + "</p></td>";
                    output += "<td><p>" + arrayC.get(x).getCustID() + "</p></td>";
                    output += "<td><p>" + arrayR.get(x).getDateReceive() + "</p></td>";
                    
                    if(arrayR.get(x).getDateReturn() != null)
                    {
                        output += "<td><p>" + arrayR.get(x).getDateReturn() + "</p></td>";
                    }
                    else
                        output += "<td><p>" + dReturn + "</p></td>";
                    
                    
                    output += "<td><p>" + arrayR.get(x).getTotalPrice() + "</p></td>";
                    output += "<td><p>" + arrayR.get(x).getRepairStatus() + "</p></td>";
                    output += "<td><p>" + arrayR.get(x).getPaymentStatus() + "</p></td>";
                    output += "<td><p>" + arrayS.get(x).getName() + "</p></td>";
                    output += "</tr>";
                }

                output += "</tbody></table>";
                out.println(output);
            }
            

            // view detailed repair
            if (request.getParameter("action").equals("viewDetailedRepair")) {
                
                int x;
                Repair_SpareParts R      = new Repair_SpareParts();
                RepairIssue RP = new RepairIssue();
                RepairService rs = new RepairService();
                
                
                Issue P = new Issue();
                SpareParts S = new SpareParts();
                Service ss = new Service();
                
                
                int  repairID = (int) request.getSession(false).getAttribute("repairID");
                
                //int repairID = 63;
                
                ArrayList<Repair_SpareParts> arrayR   = R.getRepairSpareParts(repairID);
                ArrayList<SpareParts>        arrayS   = S.getPartsName(repairID);
                
                ArrayList<RepairIssue> arrayP = RP.getRepairIssue(repairID);
                ArrayList<Issue>       arrayN = P.getIssueDesc(repairID);
                
                ArrayList<RepairService> arrayRS = rs.getRepairService(repairID);
                ArrayList<Service> arraySS = ss.getServiceDesc(repairID);
                
                String output = "";
                String nani = "nani";
  
                output += "<table id = 'asd' class = 'display' align= 'center' border='1' width='65%'>";
                output += "<caption>View Detailed Repair</caption>";
                output += "<tbody> <tr> <th>RepairID</th> <td><p>"+ repairID +"</p></td></tr>";
 
                output += "<tr> <th>Device Issue</th> <td>";
                
                for(x=0; x<arrayP.size(); x++)
                {
                    output += "<p> •    "+arrayN.get(x).getDetails()+"</p>";
                }
                output +="</td></tr>";
                
                output += "<tr> <th>SpareParts Used</th> <td>";
                for(x=0; x<arrayR.size(); x++)
                {
                    output += "<p> •    "+arrayS.get(x).getName()+"</p>";
                }

                output +="</td></tr>";
                
                output += "<tr> <th>Service</th> <td>";
                for(x=0; x<arrayRS.size(); x++)
                {
                    output += "<p> •    "+arraySS.get(x).getServiceDesc()+"</p>";
                }

                output +="</td></tr>";


                output += "</tbody></table>";
                out.println(output);
            }

            if (request.getParameter("action").equals("viewProblem")) {
                
                
                RepairIssue RP = new RepairIssue();
                Issue P = new Issue();


                String            output = "";

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<jsp:include page=\"table.jsp\"/>");
                output += "<script> $(document).ready( function () {$('#example').DataTable();} ); </script>";
                output += "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>";
                output += "<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>";
                output += "<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>";
                output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"70%\">";
                output += "<thead><tr><th> Repair ID </th><th> Problem ID</th>" + "</tr></thead><tbody>";

                int                      repairID = (int) request.getSession(false).getAttribute("repairID");
                ArrayList<RepairIssue> arrayP   = RP.getRepairIssue(repairID);
                ArrayList<Issue>       arrayN   = P.getIssueDesc(repairID);

                for (int x = 0; x < arrayP.size(); x++) {
                    output += "<tr><td><p>" + arrayP.get(x).getRepairID() + "</p></td>";
                    output += "<td><p>" + arrayP.get(x).getIssueID() + "</p></td>";
                    output += "<td><p>" + arrayN.get(x).getDetails() + "</p></td>";
                    output += "</tr>";
                }

                output += "</tbody></table>";
                out.println(output);
            }
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
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
