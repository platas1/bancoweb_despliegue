<%-- 
    Document   : Borrar
    Created on : 07-nov-2013, 8:49:10
    Author     : alumno
--%>

<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="java.util.List"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    //Podria usar el DAO de JDBC solamente cambiando Hibernate por JDBC
    //EntidadBancariaDAOImpHibernate entidadBancariaDAOImpHibernate = new EntidadBancariaDAOImpHibernate(); //impJDBC

     EntidadBancariaDAOImpJDBC entidadBancariaDAOImpJDBC = new EntidadBancariaDAOImpJDBC(); //impJDBC
     
    String idEntidadBancaria = request.getParameter("idEntidadBancaria");

    Integer idEntidadBancariaInteger = Integer.parseInt(idEntidadBancaria);

    entidadBancariaDAOImpJDBC.delete(idEntidadBancariaInteger);

    List<EntidadBancaria> entidadesBancarias = entidadBancariaDAOImpJDBC.findAll();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar</title>
    </head>
    <body>
        <h1>Tu entidad Bancaria ha sido BORRADA</h1>     


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
