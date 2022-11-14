<%-- 
    Document   : checkRepairStatus
    Created on : Dec 19, 2018, 9:08:51 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
 <html> 
 <head>    
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">     
  <title>Check Repair Status</title>
  <link rel="stylesheet"
href="https://fonts.googleapis.com/css?family=Lobster">


  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>     
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>

  <!--[endif]--> 
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/index.css">  
<link href='http://fonts.googleapis.com/css?family=Crete+Round' rel='stylesheet' type='text/css'> 

</head>   

<body style="background-image:url('img/back.png');">     



<br>
<br>
<br>
<br>
<br>
<br>
<br>
  <div class="wrapper">
  <div class = "container" >  

 <h2>Enter Repair ID</h2>
  </div>
</div>


<br>

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
                                        <button class="btn btn-lg btn-success" id="searchButton" type="submit">Search</button>
                                    </div>
                                    <!--end of col-->
                                </div>
                            </form>
    
    


<div id="slider">
<ul>
  <li>
  <div class="slider-container">
    <h4>Fast</h4>
    <p> We will repair your smartphones as fast as we can</p>
  </div>
  </li>
    <li>
    <div class="slider-container">
       <h4>Quality</h4>
    <p>We provide quality service and repair</p>
  </div>
  </li>

    <li>
    <div class="slider-container">
       <h4>Trusted</h4>
    <p>We are trusted, and will take responsibility if anything happen</p>
  </div>
  </li>

</ul>
</div>

<br>

  



</div>

   


</body> 


 </html>
 
 <script>
     
     function validateform()
    {
        
         var id=document.forms["form"]["repairID"].value;
         
         
         
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
    var repairID = document.getElementById("id1").value;  
    var action = "searchResult";
    
    if(validateform())
    {
        
    
    $.ajax({
    url: "${pageContext.request.contextPath}/testing",
    method: "POST",
    data: {repairID: repairID, action: action},
    dataType: "text",
    success: function(data) {
        
        alert(data);
        
    }
    });}

    });
    
     </script>
