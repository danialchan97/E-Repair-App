/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.CustomerDA;
import da.IssueDA;
import da.SparePartsDA;
import da.StaffDA;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Staff {
    
    String staffID;
    String staffPwd;
    String staffName, staffPosition;
    
    public Staff(String i, String p, String n, String po)
    {
        staffID = i;
        staffPwd = p;
        staffName = n;
        staffPosition = po;
    }

    public Staff() {
        staffID = "";
        staffPwd = "";
        staffName = "";
        staffPosition ="";
    }
    
    public String getID()
    {
        return staffID;
    }
    
    public String getPass()
    {
        return staffPwd;}
    
    public String getName()
    {
        return staffName;
    }
    
    public String getPosition()
    {
        return staffPosition;
    }
    
    public Staff authenticateStaff(String i, String p) throws SQLException, NoSuchAlgorithmException
    {
        return StaffDA.authenticateStaff(i,p);
    }
    
    public ArrayList<Staff> selectStaff() throws SQLException {
        return StaffDA.selectStaff();
    }
    
    


}
