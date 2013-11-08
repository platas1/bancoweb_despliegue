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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vamos A ver los Datos para Actualizar</h1>
        
                
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/Update.jsp">
            <input type="text" name="idEntidadBancaria"  readonly="readonly" value="<% out.print(entidadbancaria.getIdEntidad());%>"/>
            <input type="text" name="codigoEntidad" value="<% out.print(entidadbancaria.getCodigoEntidad());%>"/>
            <input type="text" name="nombre" value="<% out.print(entidadbancaria.getNombre());%>"/>
            <input type="text" name="cif" value="<% out.print(entidadbancaria.getCif());%>"/>
            <!--<input type="text" name="tipoEntidadBancaria" value="<% out.print(entidadbancaria.getTipoEntidadBancaria());%>"/>   -->
            <input type="submit"/>
        </form>
        
        
        <p></p>
            <p><% out.print(entidadbancaria.getCodigo());%></p>
                <p><% out.print(entidadbancaria.getCodigoEntidad());%></p>
                    <p><% out.print(entidadbancaria.getCif());%></p>
       

        <a href="index.jsp">INDEX</a> 
        
        
    </body>
</html>
