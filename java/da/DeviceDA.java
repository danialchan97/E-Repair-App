/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.CustomerDA.conn;
import db.DBConnect;
import domain.Customer;
import domain.Device;
import domain.Repair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class DeviceDA {
    
    static Connection conn;

    public static ArrayList<Device> getCustomerDevice(String custID) throws SQLException {
        
        conn = DBConnect.getConnection();
        ArrayList <Device> arrayD = new ArrayList<Device>();
        
        Device D = null;
        try{
            
            PreparedStatement st = conn.prepareStatement("SELECT * FROM DEVICE WHERE CUSTID = ? ");
            st.setString(1,custID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                String deviceID = rs.getString("DEVICEID");
                String model = rs.getString("DEVICEMODEL");
                String brand = rs.getString("DEVICEBRAND");
                String passcode = rs.getString("DEVICEPASSCODE");
                String custID1 = rs.getString("CUSTID");
                
                D = new Device(deviceID,model,brand,passcode);
                arrayD.add(D);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return arrayD;
    }
    
    public static Device createDevice(String id, String model, String brand, String pass, String custID) throws SQLException
    {
        conn = DBConnect.getConnection();
        
        Device D = null;
        
        
        try{
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO DEVICE (DEVICEID,DEVICEMODEL,DEVICEBRAND,DEVICEPASSCODE,CUSTID) VALUES (?,?,?,?,?)");
            st.setString(1,id);
            st.setString(2,model);
            st.setString(3, brand);
            st.setString(4, pass);
            st.setString(5,custID);
            
            int i = st.executeUpdate();
            
            if(i == 1)
            {
                D = new Device(id,model,brand,pass);
            }
            
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return D;
    }

    public static int checkDevice(String deviceID) throws SQLException {
        
        Connection conn = DBConnect.getConnection();
        
        PreparedStatement st;
        
        st = conn.prepareStatement("SELECT * FROM REPAIR WHERE DEVICEID = ? AND REPAIRSTATUS = 'REPAIRING'");
        st.setString(1,deviceID);
        
        ResultSet rs = st.executeQuery();
        
        int row=0;
        
       while(rs.next())
       {
           row++;
       }
       
       return row;
           
    }
    
    public static Device selectAllDeviceID(int repairID) throws SQLException
    {
        Device D = new Device();
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR R, DEVICE D WHERE R.DEVICEID = D.DEVICEID AND REPAIRID = ?");
        st.setInt(1,repairID);
    
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {

                 String deviceID = rs.getString("DEVICEID");
                String model = rs.getString("DEVICEMODEL");
                String brand = rs.getString("DEVICEBRAND");
                String passcode = rs.getString("DEVICEPASSCODE");

                
                D = new Device(deviceID,model,brand,passcode);

        }
        
        return D;
        
    }


    
    
    
}
