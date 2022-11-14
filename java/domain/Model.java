/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author user
 */
public class Model {
    
    int modelID;
    String modelName;
    int brandID;
    
    public Model(int mid, String mn, int bid)
    {
        modelID = mid;
        modelName = mn;
        brandID = bid;
    }
    
    public int getModelID()
    {
        return modelID;
    }
    
    public String getName()
    {
        return modelName;
    }
    
    public int getBrandID()
    {
        return brandID;
    }
}
