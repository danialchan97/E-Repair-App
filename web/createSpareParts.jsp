<%-- 
    Document   : addNewSpareParts
    Created on : Dec 19, 2018, 3:23:24 PM
    Author     : user
--%>

<%@page import="db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="headeradmin.jsp"/>
<head>
    <meta charset="UTF-8">
    <title>Add New SpareParts</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>


    <link rel='stylesheet prefetch' href='css/cust.css'>
</head>

        <body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>
            <h1 style="color:white; text-align:center; font-size:40px ">New SpareParts</h1>
            
            <form action="${pageContext.request.contextPath}/manageSparePartsInfoHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="createSpareParts">
               
                <% 
                    int id1 =0;
                     Connection conn = DBConnect.getConnection();
                     PreparedStatement st1 = conn.prepareStatement("SELECT PARTSSEQ.NEXTVAL FROM DUAL");
                     ResultSet rs = st1.executeQuery();
                     if(rs.next())
                     {
                         id1 = rs.getInt(1);
                     }
                    
                %>
                <div class="input">
                    <input type="text" name="id" id="id" value = "<% out.println(id1); %>" placeholder="<% out.println(id1); %>" readonly/>
                </div><br>

                
                <div class="input">
                    <input type="text" name="name" id="name" placeholder="SpareParts Name" />
                </div><br>

                <div class="input">
                    <input type="number" name="price" id="price" placeholder="Price" />
                </div><br>


                <input type="submit" value="Create" name="Create">
                </div>

            </form>



        </body>

</html>
