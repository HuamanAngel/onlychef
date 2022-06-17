

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="Usuario.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Subscriptor g1 = new Subscriptor();
            g1.Suscribirse(2, request.getParameter("correoInsert"));
            out.println(request.getParameter("correoInsert"));
            response.sendRedirect("../perfilchef.jsp");
            
        %>
    </body>
</html>
