/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import static da.SparePartsDA.conn;
import db.DBConnect;
import domain.Issue;
import domain.Repair_SpareParts;
import domain.SpareParts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class IssueDA {
    
    
    public static ArrayList<Issue> viewIssue() throws SQLException
    {
        ArrayList<Issue> arrayP = new ArrayList<Issue>();
        Issue P = null;
        
        Connection conn = DBConnect.getConnection();

        PreparedStatement st = conn.prepareStatement("SELECT * FROM ISSUE");

        
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

    public static Issue createIssue(int issueID, String issueDetails) throws SQLException {
        
        conn = DBConnect.getConnection();
        Issue P = null;
        
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO ISSUE (ISSUEID,ISSUEDESC) VALUES (?,?)");
            st.setInt(1,issueID);
            st.setString(2,issueDetails);
       
        int i = st.executeUpdate();
        
        if(i == 1)
            P = new Issue(issueID,issueDetails);
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        

        return P;
    }

    public static Issue getIssue(int issueID) throws SQLException {
        conn = DBConnect.getConnection();
        Issue P = null;
        
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM ISSUE WHERE ISSUEID = ?");
            st.setInt(1,issueID);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                issueID = rs.getInt("ISSUEID");
                String issueDetails = rs.getString("ISSUEDESC");
                
                P = new Issue(issueID,issueDetails);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return P;
    }

    public static Issue updateIssue(int issueID, String issueDetails) throws SQLException {
        
        Connection conn = DBConnect.getConnection();
        
        PreparedStatement st = conn.prepareStatement("UPDATE ISSUE SET ISSUEDESC = ? WHERE ISSUEID = ?");
        
        st.setString(1,issueDetails);
        st.setInt(2,issueID);
 
        
        st.executeUpdate();
        conn.commit();
        
        Issue P = new Issue(issueID,issueDetails);
        return P;
        
    }
    
    
    
}
