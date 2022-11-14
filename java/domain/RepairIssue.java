/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.RepairIssueDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RepairIssue {
    
    int repairID;
    int issueID;
    
    public RepairIssue()
    {
        repairID = 0;
        issueID = 0;
    }

    public RepairIssue(int repairID, int issueID) {
        this.repairID = repairID;
        this.issueID = issueID;
    }

    public int getRepairID() {
        return repairID;
    }

    public int getIssueID() {
        return issueID;
    }
    
    public RepairIssue chooseIssue(int issueID,int repairID) throws SQLException
    {
            return RepairIssueDA.chooseIssue(issueID,repairID);
    }
    
    public ArrayList<RepairIssue> getRepairIssue(int repairID) throws SQLException {
       return RepairIssueDA.getRepairIssue(repairID);
    }
    
    
}
