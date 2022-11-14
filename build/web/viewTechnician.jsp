<%-- 
    Document   : viewTechnician
    Created on : Dec 19, 2018, 6:13:47 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headeradmin.jsp"/>
<jsp:include page="table.jsp"/>
<html>

<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel="stylesheet" href="css/cust.css">
        <link rel="stylesheet" href="css/w3.css">




	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
</head>


<body style= "background-attachment: fixed;">
    
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
    var action ="viewTechnicianDetails";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
    $('#live_data').html(data);

    }
    });
    }
    
    $(document).on('click', '#btn_view', function(e) {
    var techID = $(this).data("id1");
    var action = "createRepair";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {techID: techID, action: action},
    dataType: "text",
    success: function(data) {
        
        //alert(data);
        alert('Successfully assign technician');
       window.location = "dashboard.jsp";
    }
    });

    });
    
    
            
    </script>