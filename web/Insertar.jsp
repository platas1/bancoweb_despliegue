<%@page import="java.util.List"%>
<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="Negocio.TipoEntidadBancaria"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        

<% //CONTROLADOR
          EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate(); //impJDBC
          //EntidadBancariaDAOImpJDBC entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
        
        String idEntidad=request.getParameter("idEntidad");        
        Integer idEntidadBancaria = Integer.parseInt(idEntidad);
        
        String codigoEntidad=request.getParameter("codigoEntidad");
        String nombre=request.getParameter("nombre");
        String cif=request.getParameter("cif");
        /*String tipoEntidadBancaria=request.getParameter("tipoEntidadBancaria");*/
        
        
        //////---- PROBLEMAS JDBC E HIBERNATE EN OTRAS CLASES
        
        EntidadBancaria entidadBancariaInserta = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.Banco);
        
        entidadBancariaDAO.insert(entidadBancariaInserta);
        
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
        %>
        
<!DOCTYPE html  VISTA>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exito al Insertar Datos</h1>
        
         <div align="center"> 
            <p>Tu entidad Bancaria es:</p> 

            <table border="solid">

                <% for (EntidadBancaria entidadBancaria : entidadesBancarias) {
                %><tr><td><%  out.print(entidadBancaria.getCodigoEntidad());%></td>
                    <td><% out.print(entidadBancaria.getCodigo());%></td>
                    <td><% out.print(entidadBancaria.getNombre());%></td>
                    <td><% out.print(entidadBancaria.getCif());%></td>    
                    <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                </tr>
                <% }%>

            </table>

        </div> 
                
 <a href="index.jsp">Volver</a>
        
    </body>
</html>
