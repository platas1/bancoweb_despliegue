<%@page import="Negocio.TipoEntidadBancaria"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario insercion</h1>
        
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/Insertar.jsp">
            <input type="text" name="idEntidad" value="idEntidad"/>
            <input type="text" name="codigoEntidad" value="codigoEntidad"/>
            <input type="text" name="nombre" value="nombre"/>
            <input type="text" name="cif" value="cif"/>
            
    <select name="tipoEntidadBancaria">
      <option selected>--- Elige un tipo Entidad ---</option>
      <option value="<%=TipoEntidadBancaria.Caja.name() %>">Caja de ahorros</option>
      <option><%=TipoEntidadBancaria.Banco.name()%></option>
    </select>

            <!--<input type="text" name="tipoEntidadBancaria" value="tipoEntidadBancaria"/>   -->
            <input type="submit"/>
        </form>
        
        <br></br>
        <a href="index.jsp">INDEX</a> 
    </body>
</html>
