/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.Repair_SparePartsDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Repair_SpareParts {
    
    int repairPartsID;
    int repairID;
    int partsID;

    
    public Repair_SpareParts()
    {
        repairPartsID = 0;
        repairID = 0;
        partsID = 0;

    }

    public Repair_SpareParts(int repairPartsID, int repairID, int partsID) {
        this.repairPartsID = repairPartsID;
        this.repairID = repairID;
        this.partsID = partsID;

    }
    
    public int getRepairPartsID() {
        return repairPartsID;
    }

    public int getRepairID() {
        return repairID;
    }

    public int getPartsID() {
        return partsID;
    }
    
    public Repair_SpareParts chooseSpareParts(int partsID,int repairID) throws SQLException
    {
        return Repair_SparePartsDA.chooseSpareParts(partsID,repairID);
    }
    
    public ArrayList<Repair_SpareParts> getRepairSpareParts(int repairID) throws SQLException {
        return Repair_SparePartsDA.getRepairSpareParts(repairID);
    }
    
    


    
    
}
