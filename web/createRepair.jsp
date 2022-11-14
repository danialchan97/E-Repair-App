<%-- 
    Document   : createRepair
    Created on : Dec 24, 2018, 11:08:13 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Create Repair</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>
    
    <jsp:include page="headeradmin.jsp"/>


    <link rel='stylesheet prefetch' href='css/Reg.css'>
</head>

        <body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>

<% String id = (String) request.getSession(false).getAttribute("deviceID");

%>
            <h1 style="color:white; text-align:center; font-size:40px ">New Repair</h1>
            
            <form action="${pageContext.request.contextPath}/manageRepairHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="createRepair">
                
                <div class="input">
                    <input type="text" name="id" id="id" placeholder="Device ID" />
                </div><br>
                
                <div class="input">
                    <input type="text" name="name" id="name" placeholder="Device Model" />
                </div><br>


                <div class="input">
                   
                        
                        <div id ="live_data">
                        </div>
                            
                   
                </div>
                <br>

                <div class="input">
                    <input type="text" name="phone" id="phone" placeholder="Device Passocde" />
                </div><br>

                <div class="input">
                    <input type="text" name="add" id="add" value="<% out.println(id);%>" readonly />
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
