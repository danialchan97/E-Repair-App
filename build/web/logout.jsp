<%-- 
    Document   : logout
    Created on : Dec 27, 2018, 12:25:51 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
session.invalidate();
        response.sendRedirect("index.jsp");

%>
    </body>
</html>
