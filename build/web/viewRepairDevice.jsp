<%-- 
    Document   : viewRepairDevice
    Created on : Dec 27, 2018, 12:27:55 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headeradmin.jsp"/>
<jsp:include page="table.jsp"/>
<html>
    <title>View Job</title>

<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel="stylesheet" href="css/cust.css">
        <link rel="stylesheet" href="css/w3.css">
        

</head>


<body style= "background-attachment: fixed; ">
    
    <br>
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
    var action ="viewRepairDetails";
    $.ajax({
    url: "${pageContext.request.contextPath}/viewRepairDetailsHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
    $('#live_data').html(data);

    }
    });
    }
    
    
    

            
    </script>
