<%-- 
    Document   : updateProblem
    Created on : Dec 26, 2018, 10:05:52 PM
    Author     : user
--%>

<%@page import="domain.Issue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headeradmin.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update PareParts</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>


    <link rel='stylesheet prefetch' href='css/cust.css'>
</head>


<% 
    Issue P = (Issue) request.getSession().getAttribute("problemObj");

%>
        <body>
            <br>
<br>
<br>
<br>
<br>
<br>
<br>
            <h1 style="color:white; text-align:center; font-size:40px ">Update Issue</h1>
            
            <form action="${pageContext.request.contextPath}/manageIssueHandler" method="post" class="login" name="form" id="form" onsubmit="return validateform();">
                <input type="hidden" name="action" value="updateIssue">
               

                <div class="input">
                    <input type="text" name="id" id="id" value = "<% out.println(P.getIssueID()); %>" placeholder="<% out.println(P.getIssueID()); %>" readonly/>
                </div><br>

                
                <div class="input">
                    <input type="text" name="details" id="name" value = "<% out.println(P.getDetails()); %>"  />
                </div><br>

                <input type="submit" value="Update" name="Update">
                </div>

            </form>



        </body>

</html>
