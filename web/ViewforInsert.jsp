<%@page import="Negocio.TipoEntidadBancaria"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario insercion</h1>
        
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/Insertar.jsp">
            <input class="btn btn-success" type="text" name="idEntidad" value="idEntidad"/>
            <input class="btn btn-success" type="text" name="codigoEntidad" value="codigoEntidad"/>
            <input class="btn btn-success" type="text" name="nombre" value="nombre"/>
            <input class="btn btn-success" type="text" name="cif" value="cif"/>
            
    <select class="btn btn-success" name="tipoEntidadBancaria">
      <option selected>--- Elige un tipo Entidad ---</option>
      <option value="<%=TipoEntidadBancaria.Caja.name() %>">Caja de ahorros</option>
      <option value="<%=TipoEntidadBancaria.Banco.name()%>">Banco</option>
    </select>

            <!--<input type="text" name="tipoEntidadBancaria" value="tipoEntidadBancaria"/>   -->
            <input class="btn btn-primary" type="submit"/>
        </form>
        
        <br></br>
        <a class="btn btn-info" href="index.jsp">INDEX</a> 
    </body>
</html>
