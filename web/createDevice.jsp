<%-- 
    Document   : createDevice
    Created on : Dec 23, 2018, 9:30:33 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Device</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <jsp:include page="headeradmin.jsp"/>


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

<% String id = (String) request.getSession(false).getAttribute("custID");

%>
            <h1 style="color:white; text-align:center; font-size:40px ">New Device</h1>
            
            <form action="${pageContext.request.contextPath}/manageRepairHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="createDevice">
                
                <div class="input">
                    <input type="text" name="id" id="id" placeholder="Device ID" required />
                </div><br>
                
                <div class="input">
                    <input type="text" name="model" id="model" placeholder="Device Model" required />
                </div><br>


                <div class="input">
                   
                        
                        <div id ="live_data">
                        </div>
                            
                   
                </div>
                <br>

                <div class="input">
                    <input type="text" name="pass" id="pass" placeholder="Device Passocde" required/>
                </div><br>

                <div class="input">
                    <input type="text" name="custID" id="custID" value="<% out.println(id);%>" readonly />
                </div><br>



                <input type="submit" value="Add" name="submit">
                </div>

            </form>



        </body>

</html>

<script>
    
    fetch_data();
    

    
    function fetch_data()
    {
    var action ="getBrand";
    $.ajax({
    url: "${pageContext.request.contextPath}/manageCustomerHandler",
    method: "POST",
    data: {action: action},
    dataType: 'text',
    success: function(data) {
       
    $('#live_data').html(data);

    }
    });
    }
    
    </script>