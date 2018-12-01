<%-- 
    Document   : admin.jsp
    Created on : Nov 26, 2018, 9:14:00 PM
    Author     : Mamta
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<%
            
            try{
            String user = request.getParameter("uname");
            String pass = request.getParameter("pass");
            
            String myurl="jdbc:mysql://localhost/mamta";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");
                Statement st=conn.createStatement();
                String query1="insert into admin (uname, pass) values ('"+user+"','"+pass+"')";
                int i=st.executeUpdate(query1);
                
            if(i>0)
            {    
                 response.sendRedirect("index_2.html");
            }
            else 
            {
               response.sendRedirect("login.html");
            }    
                 st.close();
}
            catch(IOException e)
            {
                out.println(e.getMessage());
            }
   
        %>            
            
                </body>
</html>