<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="Chef.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
		String nameUser=request.getParameter("mensajeSoloTexto");
                Publicador g1 = new Publicador();
                g1.ColocarMensaje(1, request.getParameter("mensajeSoloTexto"));
                response.sendRedirect("../opcionesChef.jsp");
        %>
        <h1>Hello World!</h1>
    </body>
</html>
