<%-- 
    Document   : Buscar
    Created on : 17-oct-2013, 10:35:30
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Introduce nombre Entidad Bancaria</h1>
        
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/index.jsp">
            <input type="text" name="nombre"/>
        </form>
        
    </body>
</html>
