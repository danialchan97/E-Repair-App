<%-- 
    Document   : chooseSpareParts
    Created on : Dec 25, 2018, 1:19:23 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headerstaff.jsp"/>
<jsp:include page="table.jsp"/>
<html>
    <title>Choose Issue</title>

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

    
    
    <div class ="body">
        <div id ="live_data" </div>
    </div>



</html>

<script>
    
    
    fetch_data();
    
    function fetch_data()
    {
    var action ="viewService";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
        //alert(data);
    $('#live_data').html(data);

    }
    });
    }
    
    $(document).on('click', '#btn_select1', function(e) {
    var serviceID = $(this).data("id1");
    var action = "chooseService";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: {serviceID: serviceID, action: action},
    dataType: "text",
    success: function(data) {
        
       alert('Successfully choose Service!');
      window.location = "viewDetailedRepair.jsp";
    }
    });

    });
</script>
