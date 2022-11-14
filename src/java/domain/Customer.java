/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.CustomerDA;
import da.RepairDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Customer {
    
    String custID;
    String custName;
    String custEmail;
    String custPhone;
    String custAddress;
    
    public Customer(String cid, String cn, String ce, String cp, String ca)
    {
        custID = cid;
        custName = cn;
        custEmail = ce;
        custPhone = cp;
        custAddress = ca;
    }

    
    public Customer()
    {
        custID = "";
        custName = "";
        custEmail = "";
        custPhone = "";
        custAddress = "";
    }
    
    public Customer(String custID)
    {
        this.custID = custID;
    }
    
    public String getCustID()
    {
        return custID;
    }
    public String getName()
    {
        return custName;
    }
    public String getEmail()
    {
        return custEmail;
    }
    public String getPhone()
    {
        return custPhone;
    }
    public String getAddress()
    {
        return custAddress;
    }
    
    
    public ArrayList<Customer> selectCustomer() throws SQLException {
        return CustomerDA.selectCustomer();
    }
    
    public Customer createCustomer(String id, String n, String e, String p, String add) throws SQLException
    {
        return CustomerDA.createCustomer(id,n,e,p,add);
    }
    
    public ArrayList<Customer> selectAllCustID() throws SQLException
    {
        return CustomerDA.selectAllCustID();
    }
    
    public String selectCustID(int repairID) throws SQLException
    {
        return RepairDA.selectCustID(repairID);
    }

    
}
