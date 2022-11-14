/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.DBConnect;
import domain.Issue;
import domain.RepairIssue;
import domain.RepairService;
import domain.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RepairServiceDA {
    
    public static RepairService chooseService(int serviceID, int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        
        RepairService R = null;
        
        PreparedStatement st;
        st = conn.prepareStatement("INSERT INTO REPAIRSERVICE (REPAIRID,SERVICEID) VALUES (?,?)");
        st.setInt(1,repairID);
        st.setInt(2,serviceID);
        
        int i = st.executeUpdate();
        
        R = new RepairService(repairID,serviceID);
        return R;
    }
    
    public static ArrayList<RepairService> getRepairService(int repairID) throws SQLException {
        ArrayList<RepairService> arrayP = new ArrayList<RepairService>();
        RepairService RS = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIRSERVICE R, SERVICE S WHERE R.SERVICEID = S.SERVICEID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            int serviceID = rs.getInt("SERVICEID");
            
            
            RS = new RepairService(repairID,serviceID);
            arrayP.add(RS);
                   
        }
        
        return arrayP;
    }

    public static ArrayList<Service> getServiceDesc(int repairID) throws SQLException {
       
        ArrayList<Service> arrayP = new ArrayList<Service>();
        Service P = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIRSERVICE R, SERVICE P WHERE R.SERVICEID = P.SERVICEID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int serviceID = rs.getInt("SERVICEID");
            String serviceDesc = rs.getString("SERVICEDESC");
            double price = rs.getDouble("PRICE");
            
            P = new Service(serviceID,serviceDesc,price);
            arrayP.add(P);
                   
        }
        
        return arrayP;
        
    }


    
}
