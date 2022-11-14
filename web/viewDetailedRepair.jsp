<%-- 
    Document   : viewDetailedRepair
    Created on : Dec 21, 2018, 3:19:54 PM
    Author     : user
--%>

<%@page import="domain.Repair"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="headerstaff.jsp"/>
<jsp:include page="verticleTable.jsp"/>
<html>
    <title>View Detailed Repair</title>

<head>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
	<link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>
        <link rel='stylesheet' href= 'css/w3.css'>
        


<script>
    $(document).ready( function () {
    $('#example').DataTable();
} );

$(document).ready(function() {
    $('table.display').DataTable();
} );
</script>


</head>


<body>
    
    <br>
    <br>

<% 
      int  repairID = (Integer) request.getSession(false).getAttribute("repairID");
      
Repair R = new Repair();
R = R.checkRepairStatus(repairID);

if(R.getRepairStatus().equalsIgnoreCase("repaired") || R.getPaymentStatus().equalsIgnoreCase("paid"))
{ %>
<button onclick="location.href = 'chooseSpareParts.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseSpareParts" disabled/> Choose SpareParts </button>
<button onclick="location.href = 'chooseIssue.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseIssue" disabled/> Choose Issue </button>
<button onclick="location.href = 'chooseService.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseService" disabled/> Choose Service </button>
<button id="updatePrice" class = "w3-button w3-custom" type="submit" name="Add" value="updatePrice" disabled/> Update price </button>

<%} else{ %>

<button onclick="location.href = 'chooseSpareParts.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseSpareParts" /> Choose SpareParts </button>
<button onclick="location.href = 'chooseIssue.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseIssue" /> Choose Issue </button>
<button onclick="location.href = 'chooseService.jsp';" class = "w3-button w3-custom" type="submit" name="Add" value="chooseService" /> Choose Service </button>
<button id="updatePrice" class = "w3-button w3-custom" type="submit" name="Add" value="updatePrice" /> Update price </button>

<%}
 
%>


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
    //fetch_data1();
    
    function fetch_data()
    {
    var action ="viewDetailedRepair";
    $.ajax({
    url: "${pageContext.request.contextPath}/viewRepairDetailsHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
      // alert(data);
    $('#live_data').html(data);

    }
    });
    }
    
   $(document).on('click', '#updatePrice', function(e) {

    var action = "updatePrice";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageRepairHandler",
    method: "POST",
    data: { action: action},
    dataType: "text",
    success: function(data) {
        
      alert(data);
      window.location = "viewRepairDetails.jsp";
    }
    });

    });
    
    </script>