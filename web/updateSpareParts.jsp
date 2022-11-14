<%-- 
    Document   : updateSpareParts
    Created on : Dec 19, 2018, 3:19:01 PM
    Author     : user
--%>

<%@page import="domain.SpareParts"%>
<%@page import="domain.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headeradmin.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update SpareParts</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>


    <link rel='stylesheet prefetch' href='css/cust.css'>
</head>


<% 
    SpareParts SP = (SpareParts) request.getSession().getAttribute("partsObj");

%>
        <body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>
            <h1 style="color:white; text-align:center; font-size:40px ">Update SpareParts</h1>
            
            <form action="${pageContext.request.contextPath}/manageSparePartsInfoHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="updateSpareParts">
               

                <div class="input">
                    <input type="text" name="id" id="id" value = "<% out.println(SP.getPartsID()); %>" placeholder="<% out.println(SP.getPartsID()); %>" readonly/>
                </div><br>

                
                <div class="input">
                    <input type="text" name="name" id="name" value = "<% out.println(SP.getName()); %>"  />
                </div><br>



                <div class="input">
                    <input type="text" name="price" id="price" value = "<% out.println(SP.getPrice()); %>"  />
                </div><br>


                <input type="submit" value="Update" name="Update">
                </div>

            </form>



        </body>

</html>
