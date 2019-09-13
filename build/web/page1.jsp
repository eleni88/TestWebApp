<%-- 
    Document   : page1
    Created on : Jun 27, 2019, 12:59:21 PM
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
            if(!username.equals("admin")){
            throw new Exception("Unauthorizes Access");
            }else{
        %>
        <jsp:include page="page2.jsp">
            <jsp:param name="secrete-key" value="<%=secretekey %>" />
        </jsp:include>
        <%  }  %>
        <%! private String secretekey = "1234"; %>
            }
       
    </body>
</html>
