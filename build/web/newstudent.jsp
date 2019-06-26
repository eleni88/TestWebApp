<%-- 
    Document   : newstudent
    Created on : Jun 26, 2019, 11:58:16 AM
    Author     : Eleni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1><%=request.getAttribute("title")%></h1>
        <form method="POST" action="InputStudentServlet">
            Name:<input name="name" type="text">
            Surname:<input name="surname" type="text">
            Grade:<input name="grade" type="number">
            Birthdate:<input name="birthdate" type="date">
            <input type="submit" value="new" name="new student" />
              
        </form>
    </body>
</html>
