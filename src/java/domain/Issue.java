/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.IssueDA;
import da.RepairIssueDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Issue {
    
    int issueID;
    String issueDetails;

    
    public Issue(int pid, String p)
    {
        issueID = pid;
        issueDetails = p;
    }
    
    public Issue()
    {
        issueID = 0;
        issueDetails = "";

    }
    
    public int getIssueID()
    {
        return issueID;
    }
    
    public String getDetails()
    {
        return issueDetails;
    }
    
    
    public ArrayList<Issue> viewIssue() throws SQLException {
       return IssueDA.viewIssue();
    }
    

    public Issue getIssue(int issueID) throws SQLException {
        return IssueDA.getIssue(issueID);
    }
    
    public Issue createIssue(int issueID, String issueDetails) throws SQLException
    {
        return IssueDA.createIssue(issueID,issueDetails);
    }
    
    public Issue updateIssue(int issueID, String issueDetails) throws SQLException {
        return IssueDA.updateIssue(issueID, issueDetails);
    }
    
     public ArrayList<Issue> getIssueDesc(int repairID) throws SQLException {
       return RepairIssueDA.getIssueDesc(repairID);
    }
}
