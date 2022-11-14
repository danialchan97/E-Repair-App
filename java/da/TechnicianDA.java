/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.DBConnect;
import domain.Technician;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TechnicianDA {
    
    static Connection conn;

    public static ArrayList<Technician> selectTechnician() throws SQLException
    {
        conn = DBConnect.getConnection();
        ArrayList <Technician> arrayT = new ArrayList<Technician>();
        
        Technician T = new Technician();
        
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM STAFF S, TECHNICIAN T WHERE S.STAFFID = T.STAFFID AND T.JOB < 5");
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                String id = rs.getString("STAFFID");
                String pass = rs.getString("STAFFPWD");
                String name = rs.getString("STAFFNAME");
                String pos = rs.getString("STAFFPOSITION");
                int job = rs.getInt("JOB");
                
                T = new Technician(id,pass,name,pos,job);
                arrayT.add(T);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return arrayT;
    }
    
    
    
    
    
    
    
    
    
    
    
}
