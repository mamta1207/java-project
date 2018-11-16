<%-- 
    Document   : login
    Created on : Nov 15, 2018, 9:49:44 AM
    Author     : Mamta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=request.getParameter("uname")%>
        <%=request.getParameter("pass")%>
    </body>
</html>
