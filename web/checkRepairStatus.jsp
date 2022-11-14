<%-- 
    Document   : viewDetailedRepair
    Created on : Dec 21, 2018, 3:19:54 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<jsp:include page="verticleTable.jsp"/>

<!DOCTYPE html>
 <html> 
 <head>    
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">     
  <title>Check Repair Status</title>
  <link rel="stylesheet"
href="https://fonts.googleapis.com/css?family=Lobster">
 
<script> $(document).ready( function () {$('#example').DataTable();} ); </script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
 <script src = 'http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js' ></script>
 <link rel='stylesheet' href= 'css/jquery.dataTables.min.css'>

  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>     
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
  
  

  <!--[endif]--> 
<link rel="stylesheet" href="css/cust.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/wtf.css" >
<link href='http://fonts.googleapis.com/css?family=Crete+Round' rel='stylesheet' type='text/css'> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">


</head>   


<body>

    <div class="container">
    <br/>
	<div class="row justify-content-center">
                        <div class="col-12 col-md-10 col-lg-8">
                            <form class="card card-sm" id="form" method="post" onsubmit="return validateform();">
                                <div class="card-body row no-gutters align-items-center">
                                    <div class="col-auto">
                                        <i class="fas fa-search h4 text-body"></i>
                                    </div>
                                    <!--end of col-->
                                    <div class="col">
                                   
                                            <input class="form-control form-control-lg form-control-borderless" type="text" name="id1" id="id1" placeholder="Track Your Device" required>
                                        
                                    </div>
                                    <!--end of col-->
                                    <div class="col-auto">
                                        <button class="btn btn-lg " id="searchButton" type="button">Search</button>
                                    </div>
                                    <!--end of col-->
                                </div>
                            </form>
                        </div>
                        <!--end of col-->
                    </div>
    <div class ="body">
       <div id ="live_data"> </div>
    </div>
</div>

    


</body>
</html>

<script>
    
    
    function validateform()
    {
        
         var id=document.forms["form"]["id1"].value;
         
         if(id == "")
         {
             alert('Repair ID cannot be empty!');
        return false;
         }
         
         if(isNaN(id))
                {
                    alert("Invalid Repair ID!");
                    return false;
                }

         return true;
    }
    
    
   $(document).on('click', '#searchButton', function(e) {

    var action = "searchResult";
    var searchInput = document.getElementById("id1").value;  
    
    if(validateform())
    {
        $.ajax({
    url: "${pageContext.request.contextPath}/checkRepairStatusHandler",
    method: "POST",
    data: {searchInput: searchInput, action: action},
    dataType: "text",
    
    success: function(data) { 
      //alert(data);
      //alert("abc");
       $('#live_data').html(data);
              //$('#live_data2').html("");

    }
    });
    }
    

    });
    
    $(document).on('click', '#btn_device', function(e) {
    var deviceID = $(this).data("id1");
    var action = "getDeviceID";
    $.ajax({
    url: "${pageContext.request.contextPath}/checkRepairStatusHandler",
    method: "POST",
    data: {deviceID: deviceID, action: action},
    dataType: "text",
    success: function(data) {
        //alert(data);
        $('#live_data').html(data);

      
    }
    });

    });
    
    </script>