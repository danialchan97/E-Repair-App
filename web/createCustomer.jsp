<%-- 
    Document   : addCustomer
    Created on : Dec 18, 2018, 9:40:22 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String pos = (String) session.getAttribute("position");

if(pos.equals("Manager")) { 
    %><jsp:include page="headeradmin.jsp"/><%

} else if (pos.equals("Technician")) { 
%> <jsp:include page="headerstaff.jsp"/> <%
} %>
<html>
    

<head>
    <meta charset="UTF-8">
    <title>New Customer</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>


    <link rel='stylesheet prefetch' href='css/cust.css'>
</head>

        <body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>
            <h1 style="color:white; text-align:center; font-size:40px ">New Customer</h1>
            
            <form action="${pageContext.request.contextPath}/manageCustomerHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="createCustomer">
                
                <div class="input">
                    <input type="text" name="id" id="id" placeholder="Customer ID" required/>
                </div><br>
                
                <div class="input">
                    <input type="text" name="name" id="name" placeholder="Customer Name" required/>
                </div><br>


                <div class="input">
                    <input type="email" name="email" id="email" placeholder="Email" required/>
                </div><br>

                <div class="input">
                    <input type="text" name="phone" id="phone" placeholder="Phone Number" required/>
                </div><br>

                <div class="input">
                    <input type="text" name="add" id="add" placeholder="Address" required/>
                </div><br>



                <input type="submit" value="Add" name="submit">
                </div>

            </form>



        </body>

</html>

<script>
    function validateform()
    {
    
      
      var id=document.forms["form"]["id"].value;
      var name=document.forms["form"]["name"].value;
      var email = document.forms["form"]["email"].value;
      var phone = document.forms["form"]["phone"].value;
      var address = document.forms["form"].["add"].value;

    
      if(name == "")
      {
        alert('Name Cannot Be Empty!');
        return false;
      }
    

    
    if(id.length != 12 || isNaN(id) )
    {
      if(id.length != 12)
      {
        alert('ID must be exactly 12 characters!');
        return false;
      }
      else if( isNaNidic))
      {
        alert('ID must contain numbers only!');
        return false;
    
      }
    }
    
    
    if(phone == "")
    {
      alert('Phone number cannot be empty!');
      return false;
    }
    else if(phone.length < 10 || phone.length > 11)
    {
      alert('Invalid Phone Number');
      return false;
    
    }
    else if(isNaN(phone))
    {
      alert('Phone Number must contain numbers only!');
      return false;
    }
    
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    
     if(email == "" || reg.test(email) == false)
        {
          if(email == "")
          {
            alert('Email cannot be empty!');
            return false;
          }
    
          if (reg.test(email) == false) 
            {
              alert('Email is not valid!');
              return false;
            }
        }
        
        

    
    }
</script>

