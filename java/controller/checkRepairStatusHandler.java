
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.Device;
import domain.Issue;
import domain.Repair;
import domain.RepairIssue;
import domain.Repair_SpareParts;
import domain.SpareParts;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class checkRepairStatusHandler extends HttpServlet {

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
            Logger.getLogger(checkRepairStatusHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(checkRepairStatusHandler.class.getName()).log(Level.SEVERE, null, ex);
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

            
            //get deviceID
            if (request.getParameter("action").equals("getDeviceID")) {
                
                String deviceID = request.getParameter("deviceID");
                String output = "";
                
                int x;
                     ArrayList<Repair> R = new ArrayList<Repair>();
                     Repair rr = new Repair();
                     Repair_SpareParts RS      = new Repair_SpareParts();
                     RepairIssue RP = new RepairIssue();
                     Issue P = new Issue();
                     SpareParts S = new SpareParts();

                    R = rr.checkRepairStatus(deviceID);
                    

                
                    output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"80%\">";
                    output += "<thead><tr><th> Repair ID </th><th>  Device ID </th><th> Repair Status </th><th> Payment Status </th><th> Total Price </th></thead></tr><tbody>";
                    
                    for(x=0; x<R.size(); x++)
                    {
                        output += "<tr><td><p>"+R.get(x).getRepairID()+"</p></td>";
                        output += "<td><p>"+ deviceID +"</p></td>";
                        output += "<td><p>"+R.get(x).getRepairStatus()+"</p></td>";
                        output += "<td><p>"+R.get(x).getPaymentStatus()+"</p></td>";
                        output += "<td><p>"+R.get(x).getTotalPrice()+"</p></td>";
 
                        output += "</tr>";
                    }
                    
                    output += "</tbody></table>";

                out.print(output);
                
            }
            
            if (request.getParameter("action").equals("searchResult")) 
             {
                 String output = "";
                 String nani = "nani";
                 String search = request.getParameter("searchInput");
                 int length = search.length();
                 
                 if(length == 12)
                 {
                     int x;
                     
                     String custID = request.getParameter("searchInput");
                     
                     Device D = new Device();            
                    ArrayList<Device> arrayD = new ArrayList<Device>();
                    
                    arrayD = D.getCustomerDevice(custID);

                    
                   
            output += "<table id = \"example\" class = \"display\" align=\"center\" border=\"2\" width=\"80%\">";
            output += "<thead><tr><th> Device ID </th><th>  Model </th><th> Brand </th><th> Passcode </th><th> Customer ID </th><th> View </th></thead><tbody>";
                    
            for(x =0; x<arrayD.size(); x++)
                {
                    output += "<tr><td><p>"+arrayD.get(x).getDeviceID()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDeviceModel()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDeviceBrand()+"</p></td>";
                    output += "<td><p>"+arrayD.get(x).getDevicePasscode()+"</p></td>";
                    output += "<td><p>"+custID+"</p></td>";
                    output += "<td><button type='submit' class='w3-button w3-custom' name = 'createRepair' id='btn_device' data-id1='"+ arrayD.get(x).getDeviceID() + "' >View</button>";

                    
                    output += "</tr>";
                }
                output+= "</tbody></table>";
            
            
            
            
                 }
                 else
                 {
                     
                     int x;
                     Repair R = new Repair();
                     Repair_SpareParts RS      = new Repair_SpareParts();
                     RepairIssue RP = new RepairIssue();
                     Issue P = new Issue();
                     SpareParts S = new SpareParts();

                     int repairID = Integer.parseInt(request.getParameter("searchInput"));

                    R = R.checkRepairStatus(repairID);
                    ArrayList<Repair_SpareParts> arrayR   = RS.getRepairSpareParts(repairID);
                    ArrayList<SpareParts>        arrayS   = S.getPartsName(repairID);
                    ArrayList<RepairIssue> arrayP = RP.getRepairIssue(repairID);
                    ArrayList<Issue>       arrayN = P.getIssueDesc(repairID);
                
                    output += "<jsp:include page=\"verticleTable.jsp\"/>";
                    output += "<br><br>"; 
                    output += "<table id = 'asd' class = 'display' align= 'center' border='1' width='65%'>";
                    output += "<caption>View Detailed Repair</caption>";
                    output += "<tr> <th>Repair ID</th> <td><p>"+ R.getRepairID() + "</p></td></tr>";
                    output += "<tr> <th>Device Problem</th> <td>";
                    
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
                output += "<tr> <th>Total Price </th> <td><p>"+ R.getTotalPrice() +"</p></td></tr>";
                output += "<tr> <th>Repair Status </th> <td><p>"+ R.getRepairStatus() +"</p></td></tr>";
                output += "<tr> <th>Payment Status </th> <td><p>"+ R.getPaymentStatus() +"</p></td></tr>";
     
                output += "</tbody></table>";
                    
                 }
                 
                

                
                out.print(output);

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
