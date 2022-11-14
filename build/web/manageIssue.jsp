<%-- 
    Document   : manageSpareParts
    Created on : Dec 18, 2018, 11:30:12 PM
    Author     : user
--%>


<%@page import="domain.Staff"%>
<%@page import="domain.Manager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="da.SparePartsDA"%>
<%@page import="domain.SpareParts"%>
<%@page import="domain.SpareParts"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<jsp:include page="headeradmin.jsp"/>
<jsp:include page="table.jsp"/>
<html>
    <title>Manage SpareParts</title>
<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel="stylesheet" href="css/cust.css">



	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel='stylesheet' href= 'css/w3.css'>
</head>


<body style= "background-attachment: fixed;">
    
    <br>
    <br>
    <br>

      
   
     <br>
    <br>
    <br>

    
    <div class ="body">
        <div id ="live_data" </div>
    </div>



</html>

<script>
    
    
    fetch_data();
    
    function fetch_data()
    {
    var action ="viewIssue";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageIssueHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
    $('#live_data').html(data);

    }
    });
    }
    
    $(document).on('click', '#update', function(e) {
    var issueID = $(this).data("id1");
    var action = "getIssueID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageIssueHandler",
    method: "POST",
    data: {issueID: issueID, action: action},
    dataType: "text",
    success: function(data) {
        
      //alert(data);
      window.location = "updateIssue.jsp";
    }
    });

    });
            
    </script>