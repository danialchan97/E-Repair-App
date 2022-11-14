<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
    
    
<div class="topnav">
  <a class="active" href="dashboard.jsp">XPERT</a>
  <a href="manageCustomer.jsp">Manage Customer</a>
  <a href="manageSpareParts.jsp">Manage SpareParts</a>
  <a href="manageIssue.jsp">Manage Issue</a>
  <a href="viewAllRepair.jsp">View Repair</a>
  
  <a style="float: right;" href="logout.jsp">Logout</a>
  
</div>



</body>
</html>
