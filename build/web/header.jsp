<%-- 
    Document   : header
    Created on : Dec 17, 2018, 12:06:12 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Xpert</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/me.css">
<link rel="stylesheet" href="css/scss.css">


  <link href="https://fonts.googleapis.com/css?family=Fira+Sans:200,300,400,500" rel="stylesheet">

  
      <link rel="stylesheet" href="css/headerstyle.css">

<style>
/*full screen nav bar*/
.overlay {
    height: 0%;
    width: 100%;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: white;
    overflow-y: hidden;
    transition: 0.95s;
}

.overlay-content {
    position: relative;
    top: 25%;
    width: 100%;
    text-align: center;
    margin-top: 30px;
}

.overlay ul li {
   
    text-decoration: none;
    font-size: 30px;
    color: orange;
    display: inline-block;
    transition: 0.3s;
    margin-right: 25px;
    float:center;
    margin-top:25px;

}

.overlay li:hover, .overlay li:focus {
    color: black;
}

.overlay .closebtn {
    position: absolute;
    top: 20px;
    right: 45px;
    font-size: 60px;
    color:orange;

}

.overlay .closebtn:hover
{
  cursor:pointer;
  color:black;
}

@media screen and (max-height: 450px) {
  .overlay {overflow-y: auto;}
  .overlay a {font-size: 20px}
  .overlay .closebtn {
    font-size: 40px;
    top: 15px;
    right: 35px;
  }
}
</style>
<!-- header -->
<body>
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" style="letter-spacing:4px;">

<div id="myNav" class="overlay">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <div class="overlay-content">
    <ul>
      <li><a href="index.jsp">Home </a></li>
      <li><a href="login.jsp">Log In</a></li>
      <li><a href="checkRepairStatus.jsp">Track Your Device</a></li>
    </ul>
  </div>
</div>

<span class="w3-bar-item w3-button w3-padding-medium" style="cursor:pointer; color:white" onclick="openNav()">&#9776;</span>

<script>
function openNav() {
    document.getElementById("myNav").style.height = "100%";
}

function closeNav() {
    document.getElementById("myNav").style.height = "0%";
}
</script>


    <div style="text-align:center;">
    <a class="w3-button" href="index.jsp"><i>XPERT</i></a>
    </div>


  </div>
</div>
</body>
</html>
