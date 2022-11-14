<%-- 
    Document   : manageService
    Created on : Feb 1, 2019, 1:03:52 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headerstaff.jsp"/>
<jsp:include page="table.jsp"/>
<!DOCTYPE html>
<html>
    <title>Manage Service</title>
    
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

    
  
<button onclick="location.href = 'createService.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="createService"/> Create New Service  </button>


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
    url: "${pageContext.request.contextPath}/manageServiceHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
        
    $('#live_data').html(data);

    }
    });
    }
    
    $(document).on('click', '#update', function(e) {
    var serviceID = $(this).data("id1");
    var action = "getServiceID";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageServiceHandler",
    method: "POST",
    data: {serviceID: serviceID, action: action},
    dataType: "text",
    success: function(data) {
        
      ///alert(data);
      window.location = "updateService.jsp";
    }
    });

    });
    
    
            
    </script>