/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.DBConnect;
import domain.Manager;
import domain.Repair;
import domain.Staff;
import domain.Technician;
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
public class StaffDA {
    
    static Connection conn;
    private static ArrayList<Staff> S;
    
    public StaffDA() throws SQLException{
        conn = DBConnect.getConnection();
    }
    
    public static Staff authenticateStaff(String id, String pass) throws SQLException, NoSuchAlgorithmException{
        
        conn = DBConnect.getConnection();
        Staff S = null;
        
        String id1 = null, pass1 = null, name = null, pos = null;
  
        
        try {
            
            String original = pass;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM STAFF S, MANAGER M, TECHNICIAN T WHERE S.STAFFID = ? AND S.STAFFPWD = ? AND ((S.STAFFID = M.STAFFID) OR (S.STAFFID = T.STAFFID))");
            statement.setString(1, id);
            statement.setString(2, sb.toString());
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
 
            name = rs.getString("STAFFNAME");
            pos = rs.getString("STAFFPOSITION");
            
                if(pos.equalsIgnoreCase("manager")){
                    String office = rs.getString("OFFICENUM");
                    S = new Manager (id, pass, name, pos,office);
                
                }else if(pos.equalsIgnoreCase("technician")){
                    int job = rs.getInt("JOB");
                    S = new Technician (id,pass,name,pos,job);
                }
            
            }
    

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return S;
    }
    
    
    public static ArrayList<Staff> selectStaff() throws SQLException{
        
        ArrayList<Staff> arrayS = new ArrayList<Staff>();
        Staff S = null;
        Connection conn = DBConnect.getConnection();
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR R, STAFF S WHERE R.STAFFID = S.STAFFID");
       
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            String id = rs.getString("STAFFID");
            String pass = rs.getString("STAFFPWD");
            String name = rs.getString("STAFFNAME");
            String pos = rs.getString("STAFFPOSITION");
            
            
            S = new Staff(id,pass,name,pos);
            arrayS.add(S);
            
        }
        
        return arrayS;
    }
    


}

