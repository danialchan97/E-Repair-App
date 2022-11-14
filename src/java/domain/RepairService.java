/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.RepairIssueDA;
import da.RepairServiceDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RepairService {
    
    int repairID;
    int serviceID;
    
    public RepairService()
    {
        repairID = 0;
        serviceID = 0;
    }
    
    public RepairService(int repairID, int serviceID) {
        this.repairID = repairID;
        this.serviceID = serviceID;
    }

    public int getRepairID() {
        return repairID;
    }

    public int getServiceID() {
        return serviceID;
    }
    
    public RepairService chooseService(int serviceID,int repairID) throws SQLException
    {
            return RepairServiceDA.chooseService(serviceID,repairID);
    }
    
    public ArrayList<RepairService> getRepairService(int repairID) throws SQLException
    {
        return RepairServiceDA.getRepairService(repairID);
    }


    
    
}
