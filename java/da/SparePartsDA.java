/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.DBConnect;
import domain.SpareParts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class SparePartsDA {
    
    static Connection conn;

    public static ArrayList<SpareParts> selectSpareParts() throws SQLException{
        
        conn = DBConnect.getConnection();
        ArrayList<SpareParts> arraySP = new ArrayList<SpareParts>();
        
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM SPAREPARTS");
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int partsID = rs.getInt("PARTSID");
            String partsName = rs.getString("PARTSNAME");
            double price = rs.getDouble("PRICE");
            
            SpareParts SP = new SpareParts(partsID, partsName, price);
            arraySP.add(SP);
            
        }
        
        
          
        }catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return arraySP;
    }
    
    public static SpareParts updateSpareParts(int id, String name, double price) throws SQLException{
        
        PreparedStatement st = conn.prepareStatement("UPDATE SPAREPARTS SET PARTSNAME = ?, PRICE = ? WHERE PARTSID = ?");
        
        st.setString(1,name);
        st.setDouble(2, price);
        st.setInt(3,id);
 
        
        st.executeUpdate();
        conn.commit();
        
        SpareParts SP = new SpareParts(id, name, price);
        return SP;
        
        
    }
    
    public static SpareParts getSpareParts(int partsID) throws SQLException
    {
        SpareParts SP = null;
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM SPAREPARTS WHERE PARTSID = ?");
        st.setInt(1,partsID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            partsID = rs.getInt("PARTSID");
            String name = rs.getString("PARTSNAME");
            double price = rs.getDouble("PRICE");
            SP = new SpareParts(partsID, name, price);
        }
              
        return SP;
        
    }
    
    
    //complete
    public static SpareParts createSpareParts(int id,String name, double price) throws SQLException{
        
        conn = DBConnect.getConnection();
        SpareParts SP = null;
        
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO SPAREPARTS (PARTSID,PARTSNAME,PRICE) VALUES (?,?,?)");
            st.setInt(1,id);
            st.setString(2,name);
            st.setDouble(3, price);
       
        int i = st.executeUpdate();
        
        if(i == 1)
            SP = new SpareParts(id,name,price);
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        

        return SP;
     
    }
    
    public static ArrayList<SpareParts> viewSpareParts() throws SQLException
    {
        ArrayList<SpareParts> arrayS = new ArrayList<SpareParts>();
        SpareParts S = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM SPAREPARTS");

        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int partsID = rs.getInt("PARTSID");
            String partsName = rs.getString("PARTSNAME");
            double price = rs.getDouble("PRICE");
            
            S = new SpareParts(partsID,partsName,price);
            arrayS.add(S);
                   
        }
        
        return arrayS;
    }
}
