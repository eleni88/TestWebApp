<%-- 
    Document   : updatestudent
    Created on : Jun 27, 2019, 10:13:37 AM
    Author     : Eleni
--%>

<%@page import="entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
       
        <h1><%=request.getAttribute("title")%></h1>
        <form method="POST" action="UpdateStudentServlet">
            Id:<input name="id" type="number" value=<%= request.getAttribute("id")%> />
            Surname:<input name="surname" type="text"value=<%= request.getAttribute("surname")%> />
            Name:<input name="name" type="text" value=<%= request.getAttribute("name")%> />
            Grade:<input name="grade" type="number" value=<%= request.getAttribute("grade")%> />
            Birthdate:<input name="birthdate" type="date" value=<%= request.getAttribute("birthDate")%> />
            <input type="submit" value="Update" name="update student" />
              
        </form>
    </body>
</html>
