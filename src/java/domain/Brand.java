/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.BrandDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Brand {
    
    int brandID;
    String brandName;
    
    public Brand(int bid, String bn)
    {
        brandID = bid;
        brandName = bn;
    }

    public Brand() {
       brandID = 0;
       brandName = "";
    }
    
    public int getID()
    {
        return brandID;
    }
    
    public String getName()
    {
        return brandName;
    }
    
    public ArrayList<Brand> getBrand() throws SQLException {
        return BrandDA.getBrand();
    }
}
