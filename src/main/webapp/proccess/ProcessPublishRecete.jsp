
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="Chef.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String titulo=request.getParameter("titulo");
            String descripcion=request.getParameter("descripcion");
            String ingredientes=request.getParameter("ingredientes");
            String preparacion=request.getParameter("prepa");

            out.println(titulo);
            out.println(descripcion);
            out.println(ingredientes);
            out.println(preparacion);
            
            Publicador g1 = new Publicador();
            g1.ColocarReceta(1, titulo, descripcion, ingredientes, preparacion);
            response.sendRedirect("../opcionesChef.jsp");

        %>
    </body>
</html>
