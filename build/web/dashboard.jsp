<%-- 
    Document   : dashboard
    Created on : Dec 17, 2018, 9:53:50 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE HTML>
 <html> 
     
   
<% String pos = (String) session.getAttribute("position");

if(pos.equals("Manager")) { 
    %><jsp:include page="headeradmin.jsp"/><%

} else if (pos.equals("Technician")) { 
%> <jsp:include page="headerstaff.jsp"/> <%

} %>



     

 <head>    
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">     
  <link rel="stylesheet"
href="https://fonts.googleapis.com/css?family=Lobster">


  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>     

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

  <marquee><h2>Welcome To Xpert</h2></marquee>
  </div>
</div>


<br>


<div id="slider">
<ul>
  <li>
  <div class="slider-container">
    <h4>GOALS</h4>
    <p> To become the largest mobile service in Malaysia.</p>
  </div>
  </li>
    <li>
    <div class="slider-container">
       <h4>Punctual</h4>
    <p>Arrive at Work 10 Minutes Early</p>
  </div>
  </li>

    <li>
    <div class="slider-container">
       <h4>Friendly</h4>
    <p>Smile to Our Customers</p>
  </div>
  </li>




</ul>
</div>

<br>


<div class="first">

  <div id="middle">
    
   <h1> Operation Hours </h1>
   <p>  8:00 A.M to 6:00 P.M </p>
   <p> EVERYDAY! </p>

  </div>
  
  <div id="middle">

    <h1> Announcement </h1>
   <p>  Xpert will expand our branch in Batu Pahat, Kota Tinggi and Miri! </p>


   
  </div>

  <aside id="middle">

    <h1> Total Number Of Visitor </h1>
    <p> 40 </p>



  </aside>
</div>


</body> 


 </html>

