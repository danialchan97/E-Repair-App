/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import db.DBConnect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class testnig {
    
    public static void main(String [] args) throws SQLException, NoSuchAlgorithmException
    {
        
        Connection conn = DBConnect.getConnection();
        ArrayList<Service> arraySP = new ArrayList<Service>();
        
        Service S = null;
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM SERVICE WHERE SERVICEID = ?");
        st.setInt(1,1);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            int serviceID = rs.getInt("SERVICEID");
            String name = rs.getString("SERVICEDESC");
            double price = rs.getDouble("PRICE");
            S = new Service(serviceID, name, price);
        }
        
        System.out.print(S.getServiceID());
        System.out.print(S.getServiceDesc());
        System.out.print(S.getPrice());
        
        
        
    }
}
        
        
        
    
    

