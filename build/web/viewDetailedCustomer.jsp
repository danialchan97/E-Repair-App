<%-- 
    Document   : viewDetailedCustomer
    Created on : Dec 23, 2018, 4:42:24 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headeradmin.jsp"/>
<jsp:include page="table.jsp"/>
<html>
    <title>View Detailed Customer</title>

<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel="stylesheet" href="css/cust.css">
        <link rel="stylesheet" href="css/w3.css">

<script>
    $(document).ready( function () {
    $('#example').DataTable();
} );

$(document).ready(function() {
    $('table.display').DataTable();
} );
</script>


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
    var action ="viewDetailedCustomer";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageCustomerHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
       
    $('#live_data').html(data);

    }
    });
    }
    
    $(document).on('click', '#btn_device', function(e) {
    var deviceID = $(this).data("id1");
    var action = "getDeviceID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {deviceID: deviceID, action: action},
    dataType: "text",
    success: function(data) {
        
       // alert(data);
      window.location = "viewTechnician.jsp";
    }
    });

    });
    

    
    </script>
