
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package domain;

import java.sql.SQLException;

import java.util.ArrayList;

import da.BrandDA;
import da.CustomerDA;
import da.DeviceDA;
import da.IssueDA;
import da.RepairDA;
import da.SparePartsDA;
import da.StaffDA;
import da.TechnicianDA;

/**
 *
 * @author user
 */
public class Manager extends Staff {
    String                   officeNum;
    public ArrayList<Repair> arrayR;
    public ArrayList<String> name;

    public Manager() {
        super();
        officeNum = "";
    }

    public Manager(ArrayList<Repair> arrayR, ArrayList<String> name) {
        this.arrayR = arrayR;
        this.name   = name;
    }

    public Manager(String i, String p, String n, String po, String o) {
        super(i, p, n, po);
        officeNum = o;
    }
    
    public String getOfficeNum() {
        return officeNum;
    }

    
}


//~ Formatted by Jindent --- http://www.jindent.com
