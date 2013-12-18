<%@page import="Negocio.TipoEntidadBancaria"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%  EntidadBancariaDAOImpJDBC entidadBancariaDAO = new EntidadBancariaDAOImpJDBC(); //impJDBC
     
    String idEntidadBancariaString = request.getParameter("idEntidadBancaria");

    Integer idEntidadBancaria = Integer.parseInt(idEntidadBancariaString);
    
    EntidadBancaria entidadbancaria=entidadBancariaDAO.read(idEntidadBancaria);

%>
    
    
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vamos A ver los Datos para Actualizar</h1>
        
                
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/Update.jsp">
            <input class="btn btn-success" type="text" name="idEntidadBancaria"  readonly="readonly" value="<% out.print(entidadbancaria.getIdEntidad());%>"/>
            <input class="btn btn-success" type="text" name="codigoEntidad" value="<% out.print(entidadbancaria.getCodigoEntidad());%>"/>
            <input class="btn btn-success" type="text" name="nombre" value="<% out.print(entidadbancaria.getNombre());%>"/>
            <input class="btn btn-success" type="text" name="cif" value="<% out.print(entidadbancaria.getCif());%>"/>
     
            <select class="btn btn-success" name="tipoEntidadBancaria">
            <option selected><%=entidadbancaria.getTipoEntidadBancaria()%></option>
            <option value="<%=TipoEntidadBancaria.Caja.name() %>">Caja de ahorros</option>
            <option value="<%=TipoEntidadBancaria.Banco.name()%>">Banco</option>
    </select>

    <input class="btn btn-primary" type="submit"/>
    
        </form>        
    <br>
        <a class="btn btn-info" href="index.jsp">INDEX</a> 
        
        
    </body>
</html>
