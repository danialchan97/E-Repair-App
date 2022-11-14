<%-- 
    Document   : manageCustomer
    Created on : Dec 23, 2018, 3:57:44 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headeradmin.jsp"/>
<jsp:include page="table.jsp"/>
<html>
     <title>Manage Customer</title>

<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel="stylesheet" href="css/cust.css">
        <link rel='stylesheet' href= 'css/w3.css'>

</head>


<body style= "background-attachment: fixed;">
    
    <br>
    <br>

    
    
    <button onclick="location.href = 'createCustomer.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="addCustomer"/> Create Customer </button>
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
    var action ="viewCustomer";
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
    
    $(document).on('click', '#btn_view', function(e) {
    var custID = $(this).data("id1");
    var action = "getCustID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageCustomerHandler",
    method: "POST",
    data: {custID: custID, action: action},
    dataType: "text",
    success: function(data) {
        
        window.location = "viewDetailedCustomer.jsp";
    }
    });

    });
    
    $(document).on('click', '#btn_view1', function(e) {
    var custID = $(this).data("id1");
    var action = "getCustID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageCustomerHandler",
    method: "POST",
    data: {custID: custID, action: action},
    dataType: "text",
    success: function(data) {
        
        window.location = "createDevice.jsp";
    }
    });

    });
    
    
            
    </script>
