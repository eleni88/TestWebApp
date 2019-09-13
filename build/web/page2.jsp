<%-- 
    Document   : page2
    Created on : Jun 27, 2019, 1:07:41 PM
    Author     : Eleni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            String username = request.getParameter("username");
            String secretkey = request.getParameter("secrete-key");
            out.println("Welcome " + username + ", your secrete key is : " + secretkey);
            %>
    </body>
</html>
