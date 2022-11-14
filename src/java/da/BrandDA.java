/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.DeviceDA.conn;
import db.DBConnect;
import domain.Brand;
import domain.Device;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class BrandDA {
    
    static Connection conn;
    
    public static ArrayList<Brand> getBrand() throws SQLException
    {
        
        
         conn = DBConnect.getConnection();
        ArrayList <Brand> arrayB = new ArrayList<Brand>();
        
        Brand B = null;
        
         try{
            
            PreparedStatement st = conn.prepareStatement("SELECT * FROM BRAND");

            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                int brandID = rs.getInt("BRANDID");
                String name = rs.getString("BRANDNAME");

                
                B = new Brand(brandID,name);
                arrayB.add(B);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return arrayB;    
    }
    
    
}
