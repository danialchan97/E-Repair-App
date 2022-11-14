/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.TechnicianDA.conn;
import db.DBConnect;
import domain.Customer;
import domain.Technician;
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
public class CustomerDA {
    
    static Connection conn;
    private static ArrayList <Customer> C;
    
    public static Customer createCustomer(String id, String n, String e, String p, String add) throws SQLException {
         
        conn = DBConnect.getConnection();
        
        Customer C = null;
        
        
        try{
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO CUSTOMER (CUSTID,CUSTNAME,CUSTEMAIL,CUSTPHONE,CUSTADDRESS) VALUES (?,?,?,?,?)");
            st.setString(1,id);
            st.setString(2,n);
            st.setString(3, e);
            st.setString(4, p);
            st.setString(5,add);
            
            int i = st.executeUpdate();
            
            if(i == 1)
            {
                C = new Customer(id,n,e,p,add);
            }
            
            
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        return C;
    }

    public static ArrayList<Customer> selectCustomer() throws SQLException {
        conn = DBConnect.getConnection();
        ArrayList <Customer> arrayC = new ArrayList<Customer>();
        
        Customer C = null;
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM CUSTOMER");
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                String id = rs.getString("CUSTID");
                String name = rs.getString("CUSTNAME");
                String email = rs.getString("CUSTEMAIL");
                String phone = rs.getString("CUSTPHONE");
                String add = rs.getString("CUSTADDRESS");
                
                C = new Customer(id,name,email,phone,add);
                arrayC.add(C);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return arrayC;
    }
    
    public static ArrayList<Customer> selectAllCustID() throws SQLException
    {
        ArrayList<Customer> arrayC = new ArrayList<Customer>();
        Connection conn = DBConnect.getConnection();
        Customer C = null;
        
        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIR R, STAFF S WHERE R.STAFFID = S.STAFFID");
       
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {

            String custID = rs.getString("CUSTID");
            C = new Customer(custID);

            arrayC.add(C);
            
        }
        
        return arrayC;
        
    }




    
}
