/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.RepairDA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Repair {
    
    int repairID;
    Date dateReceive;
    Date dateReturn;
    String repairStatus;
    double totalPrice;
    String paymentStatus;
    String deviceID;
    String custID;

    
    public Repair(int r, Date d, Date dr, String rs, double tp, String ps)
    {
        repairID = r;
        dateReceive = d;
        dateReturn = dr;
        repairStatus = rs;
        totalPrice = tp;
        paymentStatus = ps;
    }
    
    public Repair()
    {
        repairID = 0;
        dateReceive = new Date();
        dateReturn = new Date();
        repairStatus = "";
        totalPrice = 0.0;
        paymentStatus = "";
    }
    
    public Repair(String did, String cid)
    {
        deviceID = did;
        custID = cid;
    }
    

    public String getDeviceID()
    {
        return deviceID;
    }
    
    public String getCustID()
    {
        return custID;
    }
    
    

    public int getRepairID() {
        return repairID;
    }

    public Date getDateReceive() {
        return dateReceive;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public Repair createRepair(String deviceID, String techID,String custID) throws SQLException{
        return RepairDA.createRepair(deviceID,techID,custID);
    }
    
    public ArrayList<Repair> selectRepairDetails() throws SQLException {
        return RepairDA.selectRepairDetails();
    }

    
    public Repair updatePrice(int repairID) throws SQLException
    {
        return RepairDA.updatePrice(repairID);
    }
    
    public Repair updateRepairStatus(int repairID) throws SQLException
    {
        return RepairDA.updateRepairStatus(repairID);
    }
    
    public Repair updatePaymentStatus(int repairID) throws SQLException
    {
        return RepairDA.updatePaymentStatus(repairID);
    }
    
    public Repair checkRepairStatus(int repairID) throws SQLException
    {
        return RepairDA.checkRepairStatus(repairID);
    }
    
    public ArrayList<Repair> checkRepairStatus(String deviceID) throws SQLException
    {
        return RepairDA.checkRepairStatus(deviceID);
    }
    
    public ArrayList<Repair> viewRepairTechnician(String staffID) throws SQLException
    {
        return RepairDA.viewRepairTechnician(staffID);
    }



    

}
