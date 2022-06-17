
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="Usuario.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Subscriptor g1 = new Subscriptor();
            g1.Desuscribirme();
            response.sendRedirect("../perfilchef.jsp");            
        %>        
        
    </body>
</html>
