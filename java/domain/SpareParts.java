/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.Repair_SparePartsDA;
import da.SparePartsDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class SpareParts {


     int partsID;
     String partsName;
     double price;
     
     public SpareParts(int pid, String pn, double p)
     {
         partsID = pid;
         partsName = pn;
         price = p;
     }
     
     public SpareParts()
     {
         partsID = 0;
         partsName = "";
         price = 0.0;
     }
     
     public int getPartsID()
     {
        return partsID;
     }
     
     public String getName()
     {
        return partsName;
     }
     
     
     public double getPrice()
     {
        return price;
     }
     
     public ArrayList<SpareParts> getPartsName(int repairID) throws SQLException {
       return Repair_SparePartsDA.getPartsName(repairID);
    }
     
     public SpareParts createSpareParts(int id, String name, double price) throws SQLException {
        return SparePartsDA.createSpareParts(id, name, price);
    }
     
     public ArrayList<SpareParts> selectSpareParts() throws SQLException
     {
        return SparePartsDA.selectSpareParts();
     }
     
     public SpareParts getSpareParts(int partsID) throws SQLException
     {
        return SparePartsDA.getSpareParts(partsID);
     }
     
     public ArrayList<SpareParts> viewSpareParts() throws SQLException {
       return SparePartsDA.viewSpareParts();
     }
     
     public SpareParts updateSpareParts(int id, String name, double price) throws SQLException {
        return SparePartsDA.updateSpareParts(id, name, price);
    }
    
     
     
}
