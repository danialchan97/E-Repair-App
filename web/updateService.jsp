<%-- 
    Document   : updateService
    Created on : Feb 1, 2019, 1:40:02 PM
    Author     : user
--%>

<%@page import="domain.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headerstaff.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Service</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>


    <link rel='stylesheet prefetch' href='css/cust.css'>
</head>
<% 
    Service S = (Service) request.getSession().getAttribute("partsObj");

%>

<body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>
            <h1 style="color:white; text-align:center; font-size:40px ">Update Service</h1>
            
            <form action="${pageContext.request.contextPath}/manageServiceHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="updateService">
               

                <div class="input">
                    <input type="text" name="id" id="id" value = "<% out.println(S.getServiceID()); %>" placeholder="<% out.println(S.getServiceID()); %>" readonly/>
                </div><br>

                
                <div class="input">
                    <input type="text" name="name" id="name" value = "<% out.println(S.getServiceDesc()); %>"  />
                </div><br>



                <div class="input">
                    <input type="text" name="price" id="price" value = "<% out.println(S.getPrice()); %>"  />
                </div><br>


                <input type="submit" value="Update" name="Update">
                </div>

            </form>



        </body>

</html>

