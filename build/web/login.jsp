<%-- 
    Document   : login
    Created on : Dec 17, 2018, 4:00:37 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html >

<head>
  <meta charset="UTF-8">
  <title>Login</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

      
  <link rel='stylesheet prefetch' href='css/login.css'>

</head>


<body style="background-image:url('img/back.png');">

<h1 style="color:white; text-align:center; font-size:40px ">Login</h1> 
    <br>


   <form name = "form" action="${pageContext.request.contextPath}/loginHandler" method ="post" class="login">
  
    <input type="hidden" name="action" value="authenticateStaff">
    
    
    <div class="input">
    <input type="text" placeholder="Staff IC" name = "id" id = "ic" required /><br>

    </div>
    
    <div class="input">
        <input type="password" placeholder="Password" name = "pass" id = "pass" required /><br>
    </div>
    
    <input type="submit" class="submit" name="submit" id="submit" value="Login">
    <br>
    

 
</form>
</body>

</html>