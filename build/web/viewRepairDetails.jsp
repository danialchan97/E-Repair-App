<%-- 
    Document   : viewRepairDetails
    Created on : Dec 20, 2018, 5:16:30 PM
    Author     : user
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headerstaff.jsp"/>
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

    
    
    <div class ="body">
        <div id ="live_data" </div>
    </div>



</html>

<script>
    
    
    fetch_data();

    function fetch_data()
    {
    var action ="viewJob";
    $.ajax({
    url: "${pageContext.request.contextPath}/viewRepairDetailsHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
        //alert(data);
    $('#live_data').html(data);

    }
    });
    }
    
    
    
    $(document).on('click', '#btn_update', function(e) {
    var repairID = $(this).data("id1");
    var action = "updateRepairStatus";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {repairID: repairID, action: action},
    dataType: "text",
    success: function(data) {
        alert('Successfully updated repair status!');
        window.location = "viewRepairDetails.jsp";
    }
    });

    });
    
    $(document).on('click', '#btn_update1', function(e) {
    var repairID = $(this).data("id1");
    var action = "updatePaymentStatus";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {repairID: repairID, action: action},
    dataType: "text",
    success: function(data) {
       // alert(data);
        alert('Successfully updated payment status!');
        window.location = "viewRepairDetails.jsp";
    }
    });

    });
    
    $(document).on('click', '#btn_view', function(e) {
    var repairID = $(this).data("id1");
    var action = "getRepairID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {repairID: repairID, action: action},
    dataType: "text",
    success: function(data) {
        
        window.location = "viewDetailedRepair.jsp";
    }
    });

    });
            
    </script>
