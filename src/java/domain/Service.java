/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.RepairServiceDA;
import da.ServiceDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Service {
    
    int serviceID;
    String serviceDesc;
    double price;
    
    public Service()
    {
        serviceID = 0;
        serviceDesc = "";
        price = 0.0;
    }

    public Service(int serviceID, String serviceDesc, double price) {
        this.serviceID = serviceID;
        this.serviceDesc = serviceDesc;
        this.price = price;
    }

    public int getServiceID() {
        return serviceID;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public double getPrice() {
        return price;
    }
    
    public ArrayList<Service> selectService() throws SQLException
    {
        return ServiceDA.selectService();
    }
    
    public Service createService(int id, String desc, double price) throws SQLException
    {
        return ServiceDA.createService(id,desc,price);
    }
    
    public Service getService(int serviceID) throws SQLException
    {
        return ServiceDA.getService(serviceID);
    }
    
    public Service updateService(int serviceID, String desc, double price) throws SQLException
    {
        return ServiceDA.updateService(serviceID,desc,price);
    }
    
    public ArrayList<Service> viewService() throws SQLException
    {
        return ServiceDA.selectService();
    }
    
    public ArrayList<Service> getServiceDesc(int repairID)
    {
        return RepairServiceDA.getServiceDesc(repairID);
    }
    
    
    
}
