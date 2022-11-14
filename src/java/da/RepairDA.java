/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.DeviceDA.conn;
import db.DBConnect;
import domain.Device;
import domain.Manager;
import domain.Repair;
import domain.Staff;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class RepairDA {
    
    


    
    public static Repair checkRepairStatus(int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        Repair R = null;
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR WHERE REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
            
          
        }
        else
        {
            repairID = 0;
            Date dateReceive = null;
            Date dateReturn = null;
            String repairStatus = null;
            double price = 0.0;
            String paymentStatus = null;

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
        }
        return R;
        
    }
    
    public static ArrayList<Repair> checkRepairStatus(String deviceID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        Repair R = null;
        ArrayList<Repair> rr = new ArrayList<Repair>();
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR WHERE DEVICEID = ?");
        st.setString(1,deviceID);
        
         ResultSet rs = st.executeQuery();
        
        if(rs.next())
        {
            int repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
            rr.add(R);
          
        }
        else
        {
            int repairID = 0;
            Date dateReceive = null;
            Date dateReturn = null;
            String repairStatus = null;
            double price = 0.0;
            String paymentStatus = null;

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
            rr.add(R);
        }
        
        return rr;
    }
    
    public static String selectDeviceID(int repairID) throws SQLException
    {
         Connection conn = DBConnect.getConnection();
        String deviceID = null;
        String nani = "nani";
        String id = String.valueOf(repairID);
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR WHERE REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
         while(rs.next())
        {
            deviceID = rs.getString("DEVICEID");           
        }
        
        return deviceID;
        

        
    }
    
    public static ArrayList<Repair> viewRepairTechnician(String staffID) throws SQLException
    {
        ArrayList<Repair> arrayR = new ArrayList<Repair>();
        Repair R = null;
        Connection conn = DBConnect.getConnection();
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR WHERE STAFFID = ?");
        st.setString(1,staffID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
            arrayR.add(R);
            
        }
        
        return arrayR;
        
    }

    
   public static ArrayList<Repair> selectRepairDetails() throws SQLException
    {
        ArrayList<Repair> arrayR = new ArrayList<Repair>();
        Repair R = null;
        Connection conn = DBConnect.getConnection();
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR R, STAFF S WHERE R.STAFFID = S.STAFFID");
       
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);
            arrayR.add(R);
            
        }
        
        return arrayR;

        
    }
    
    
    public static Repair updateRepairStatus(int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        String techID ="";
        
        Repair R = null;
        PreparedStatement st = conn.prepareStatement("UPDATE REPAIR SET REPAIRSTATUS = 'REPAIRED' WHERE REPAIRID = ?");
        st.setInt(1,repairID);
        

        
        PreparedStatement st2;
        st2 = conn.prepareStatement("SELECT * FROM REPAIR WHERE REPAIRID = ?");
        st2.setInt(1,repairID);
             
        ResultSet rs2;
        rs2 = st2.executeQuery();
             
         while(rs2.next())
         {
            techID = rs2.getString("STAFFID");
         }
         
         st2 = conn.prepareStatement("UPDATE TECHNICIAN SET JOB = JOB-1 WHERE STAFFID = ?");
         st2.setString(1,techID);
         
         int a = st2.executeUpdate();
             
        
        int i = st.executeUpdate();
        
        if(i == 1){
             
             
             
             ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");
            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);

        }
        
        }
        
        return R;
    }
    public static Repair updatePaymentStatus(int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        
        Repair R = null;
        PreparedStatement st = conn.prepareStatement("UPDATE REPAIR SET PAYMENTSTATUS = 'PAID', DATERETURN = SYSDATE WHERE REPAIRID = ?");
        st.setInt(1,repairID);
        
        int i = st.executeUpdate();
        
        if(i == 1){
             PreparedStatement st1 = conn.prepareStatement("SELECT * FROM REPAIR WHERE REPAIRID = ?");
             st1.setInt(1,repairID);
             
             ResultSet rs = st1.executeQuery();
        
        while(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);

        }
        
        }
        
        return R;
    }
    
    public static Repair createRepair(String deviceID, String techID, String custID) throws SQLException
    {
        conn = DBConnect.getConnection();
        
        Repair R = null;
        String paymentStatus = "";
        int repairID = 0;
        long id = 0;
        
        java.util.Date date = new java.util.Date();
        java.sql.Date now = new java.sql.Date(date.getTime());

        
        try{
            PreparedStatement st;
            st = conn.prepareStatement("SELECT * FROM PAYMENTSTATUS WHERE PAYMENTID = 1");
            
            ResultSet rs;
            rs = st.executeQuery();
            
            //get paymentdetails
            while(rs.next()){
                paymentStatus = rs.getString("PAYMENTDETAILS");
            }
            
            
            st = conn.prepareStatement("SELECT REPAIRSEQ.NEXTVAL FROM DUAL");
            rs = st.executeQuery();
            //get repairID
            while(rs.next()){
                id = rs.getLong(1);
            }
            
            repairID = (int) id;
            
            st = conn.prepareStatement("INSERT INTO REPAIR (REPAIRID,DATERECEIVE,DATERETURN,REPAIRSTATUS,TOTALPRICE,PAYMENTSTATUS,DEVICEID,CUSTID,STAFFID) VALUES (?,SYSDATE,NULL,?,?,?,?,?,?) ");
            st.setInt(1,repairID);
            st.setString(2,"REPAIRING");
            st.setDouble(3, 0.0);
            st.setString(4, paymentStatus);
            st.setString(5,deviceID);
            st.setString(6,custID);
            st.setString(7,techID);
            int a = st.executeUpdate();
            
            st = conn.prepareStatement("UPDATE TECHNICIAN SET JOB = JOB+1 WHERE STAFFID = ?");
            st.setString(1,techID);
            
            
            int i = st.executeUpdate();
            
            if(i == 1)
            {
                R = new Repair(repairID,now,null,"REPAIRING",0.0,paymentStatus);
            }
            
            return R;
       
            
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return R;
    }
    
    public static Repair updatePrice(int repairID) throws SQLException
    {
        
        Connection conn = DBConnect.getConnection();
        
        Repair R = new Repair();
        double totalPriceS = 0;
        double totalPriceP = 0;
        double total;
        
        try{
            
        
        PreparedStatement st;
        st = conn.prepareStatement("SELECT SUM(S.PRICE) AS TOTALPRICES FROM SPAREPARTS S, REPAIR_SPAREPARTS R WHERE S.PARTSID = R.PARTSID AND REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs;
        
        rs = st.executeQuery();
        
        while(rs.next())
        {
            totalPriceS = rs.getDouble("TOTALPRICES");   //total price for spareparts
        }
        
        st = conn.prepareStatement("SELECT SUM(P.PRICE) AS TOTALPRICEP FROM SERVICE P, REPAIRSERVICE R WHERE P.SERVICEID = R.SERVICEID AND REPAIRID = ?");
        st.setInt(1,repairID);
        
        rs = st.executeQuery();
        
        while(rs.next())
        {
            totalPriceP = rs.getDouble("TOTALPRICEP"); // total price for service
        }
        
        
        total = totalPriceS + totalPriceP;
        
        st = conn.prepareStatement("UPDATE REPAIR SET TOTALPRICE = ? WHERE REPAIRID = ?");
        st.setDouble(1,total);
        st.setInt(2,repairID);
        
        int a = st.executeUpdate();
        
        st = conn.prepareStatement("SELECT * FROM REPAIR WHERE REPAIRID = ?");
        st.setInt(1,repairID);
        
        rs = st.executeQuery();
        
        while(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            Date dateReceive = rs.getDate("DATERECEIVE");
            Date dateReturn = rs.getDate("DATERETURN");
            String repairStatus = rs.getString("REPAIRSTATUS");
            double price = rs.getDouble("TOTALPRICE");
            String paymentStatus = rs.getString("PAYMENTSTATUS");

            
            R = new Repair(repairID,dateReceive,dateReturn,repairStatus,price,paymentStatus);

        }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return R;
        
    }
    
    public static String selectCustID(int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        String custID ="";
        PreparedStatement st;
        st = conn.prepareStatement("SELECT CUSTID FROM REPAIR WHERE REPAIRID = ?");
        
        st.setInt(1,repairID);
        ResultSet rs;
        
        rs = st.executeQuery();
        
        while(rs.next())
        {
            custID = rs.getString("CUSTID");
        }
        
        return custID;
    }
    
    


}
