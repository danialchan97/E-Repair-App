/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.SparePartsDA.conn;
import db.DBConnect;
import domain.Service;
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
public class ServiceDA {
    
    static Connection conn;
    
    public static ArrayList<Service> selectService() throws SQLException
    {
        conn = DBConnect.getConnection();
        ArrayList<Service> arraySP = new ArrayList<Service>();
        
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM SERVICE");
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int serviceID = rs.getInt("SERVICEID");
            String serviceDesc = rs.getString("SERVICEDESC");
            double price = rs.getDouble("PRICE");
            
            Service SP = new Service(serviceID, serviceDesc, price);
            arraySP.add(SP);
            
        }
        
        
          
        }catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return arraySP;
        
    }

    public static Service createService(int id, String name, double price) throws SQLException {
        
       conn = DBConnect.getConnection();
        Service S = null;
        
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO SERVICE (SERVICEID,SERVICEDESC,PRICE) VALUES (?,?,?)");
            st.setInt(1,id);
            st.setString(2,name);
            st.setDouble(3, price);
       
        int i = st.executeUpdate();
        
        if(i == 1)
            S = new Service(id,name,price);
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        

        return S;
    }

    public static Service getService(int serviceID) throws SQLException {
       
        Service S = null;
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM SERVICE WHERE SERVICEID = ?");
        st.setInt(1,serviceID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            serviceID = rs.getInt("SERVICEID");
            String name = rs.getString("SERVICEDESC");
            double price = rs.getDouble("PRICE");
            S = new Service(serviceID, name, price);
        }
              
        return S;
    }

    public static Service updateService(int serviceID, String desc, double price) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("UPDATE SERVICE SET SERVICEDESC = ?, PRICE = ? WHERE SERVICEID = ?");
        
        st.setString(1,desc);
        st.setDouble(2, price);
        st.setInt(3,serviceID);
 
        
        st.executeUpdate();
        conn.commit();
        
        Service S = new Service(serviceID, desc, price);
        return S;
        
    }


}
