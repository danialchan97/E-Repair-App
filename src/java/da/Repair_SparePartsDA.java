/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.DeviceDA.conn;
import db.DBConnect;
import domain.Repair;
import domain.Repair_SpareParts;
import domain.SpareParts;
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
public class Repair_SparePartsDA {
    

    
    public static ArrayList<Repair_SpareParts> getRepairSpareParts(int repairID) throws SQLException
    {
        ArrayList<Repair_SpareParts> arrayR = new ArrayList<Repair_SpareParts>();
        Repair_SpareParts R = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR_SPAREPARTS R, SPAREPARTS S WHERE R.PARTSID = S.PARTSID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int repairPartsID = rs.getInt("REPAIRPARTSID");
            repairID = rs.getInt("REPAIRID");
            int sparePartsID = rs.getInt("PARTSID");
           
            
            R = new Repair_SpareParts(repairPartsID,repairID,sparePartsID);
            arrayR.add(R);
                   
        }
        
        return arrayR;
    }

    public static ArrayList<SpareParts> getPartsName(int repairID) throws SQLException {
        ArrayList<SpareParts> arrayN = new ArrayList<SpareParts>();
        SpareParts S = null;
        
        Connection conn = DBConnect.getConnection();
        
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR_SPAREPARTS R, SPAREPARTS S WHERE R.PARTSID = S.PARTSID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int partsID = rs.getInt("PARTSID");
            String partsName = rs.getString("PARTSNAME");
            double price = rs.getDouble("PRICE");
            
            S = new SpareParts(partsID,partsName,price);
            arrayN.add(S);
                   
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        
        return arrayN;
    }
    
    public static Repair_SpareParts chooseSpareParts(int partsID, int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        
        Repair_SpareParts R = null;
        
        PreparedStatement st;
        ResultSet rs;
        long id = 0;
        int repairpartsid;
        
        st = conn.prepareStatement("SELECT REPAIRPARTSSEQ.NEXTVAL FROM DUAL");
            rs = st.executeQuery();
            //get repairID
            while(rs.next()){
                id = rs.getLong(1);
            }
            
            repairpartsid = (int) id;
        st = conn.prepareStatement("INSERT INTO REPAIR_SPAREPARTS (REPAIRPARTSID,REPAIRID,PARTSID) VALUES (?,?,?)");
        st.setInt(1,repairpartsid);
        st.setInt(2,repairID);
        st.setInt(3,partsID);
        
        int i = st.executeUpdate();
        
        R = new Repair_SpareParts(repairpartsid,repairID,partsID);
      
         
                return R;
    }
    
    
    
    
}
