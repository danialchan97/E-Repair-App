/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.DBConnect;
import domain.Issue;
import domain.RepairIssue;
import domain.Repair_SpareParts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RepairIssueDA {
    
    
    public static ArrayList<Issue> getIssueDesc(int repairID) throws SQLException
    {
        ArrayList<Issue> arrayP = new ArrayList<Issue>();
        Issue P = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIRISSUE R, ISSUE P WHERE R.ISSUEID = P.ISSUEID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            int issueID = rs.getInt("ISSUEID");
            String issueDetails = rs.getString("ISSUEDESC");

            
            P = new Issue(issueID,issueDetails);
            arrayP.add(P);
                   
        }
        
        return arrayP;
    }

    public static ArrayList<RepairIssue> getRepairIssue(int repairID) throws SQLException {
        ArrayList<RepairIssue> arrayP = new ArrayList<RepairIssue>();
        RepairIssue P = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM REPAIRISSUE R, ISSUE P WHERE R.ISSUEID = P.ISSUEID AND R.REPAIRID = ?");
        st.setInt(1,repairID);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
        {
            repairID = rs.getInt("REPAIRID");
            int issueID = rs.getInt("ISSUEID");
            
            
            P = new RepairIssue(repairID,issueID);
            arrayP.add(P);
                   
        }
        
        return arrayP;
    }
    
    public static RepairIssue chooseIssue(int issueID, int repairID) throws SQLException
    {
        Connection conn = DBConnect.getConnection();
        
        RepairIssue R = null;
        
        PreparedStatement st;
        st = conn.prepareStatement("INSERT INTO REPAIRISSUE (REPAIRID,ISSUEID) VALUES (?,?)");
        st.setInt(1,repairID);
        st.setInt(2,issueID);
        
        int i = st.executeUpdate();
        
        R = new RepairIssue(repairID,issueID);
        
        
  
        return R;
    }
}
