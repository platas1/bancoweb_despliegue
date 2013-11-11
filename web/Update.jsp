<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.TipoEntidadBancaria"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>

<% //CONTROLADOR
        EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate(); //impJDBC
       //   EntidadBancariaDAOImpJDBC entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
        
        String idEntidad=request.getParameter("idEntidadBancaria");        
        Integer idEntidadBancaria = Integer.parseInt(idEntidad);
        
        String codigoEntidad=request.getParameter("codigoEntidad");
        String nombre=request.getParameter("nombre");
        String cif=request.getParameter("cif");
      //String tipoEntidadBancaria=request.getParameter("tipoEntidadBancaria");
        
        EntidadBancaria entidadBancariaActualiza = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.Banco);
        
        entidadBancariaDAO.update(entidadBancariaActualiza);
        
       // List<EntidadBancaria> entidadesBancarias = entidadBancariaDAOImpJDBC.findAll();
        %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exito al Actualizar</h1>
        
                <a href="index.jsp">INDEX</a> 
                
    </body>
</html>
