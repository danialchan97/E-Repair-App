/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.CustomerDA;
import da.IssueDA;
import da.RepairDA;
import da.RepairIssueDA;
import da.Repair_SparePartsDA;
import da.SparePartsDA;
import da.StaffDA;
import da.TechnicianDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Technician extends Staff {
    
    int job;
    
    public Technician(String i, String p, String n, String po, int jo) {
        super(i, p, n, po);
        job = jo;
    }

    public Technician() {
      super();
      job = 0;
    }

    public int getJob()
    {
        return job;
    }
    

    
    public ArrayList<Technician> selectTechnician() throws SQLException {
        return TechnicianDA.selectTechnician();
    }

    

}
