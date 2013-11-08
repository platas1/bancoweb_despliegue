<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAO"%>


<%

    EntidadBancariaDAOImpJDBC entidadBancariaDAOImpJDBC = new EntidadBancariaDAOImpJDBC(); //impJDBC
//EntidadBancaria entidadBancaria =  entidadBancariaDAO.read(1);

//EntidadBancariaDAOImpHibernate entidadBancariaDAOImpHibernate = new EntidadBancariaDAOImpHibernate();

    List<EntidadBancaria> entidadesBancarias = entidadBancariaDAOImpJDBC.findAll();  //Tambien con JDBC


    String nombre = request.getParameter("nombre");


    List<EntidadBancaria> entidadesBancariasNombre = entidadBancariaDAOImpJDBC.findByNombre(nombre);

%>

<html>
    <head>
        <title>-- BANCO --</title>
    </head>
    <body>
        <div align="center"> 
            <p>Tu entidad Bancaria es:</p> 

            <table border="solid">

                <% for (EntidadBancaria entidadBancaria : entidadesBancarias) {
                %><tr>  <td><% out.print(entidadBancaria.getIdEntidad());%></td>
                    <td><%  out.print(entidadBancaria.getCodigo());%></td>
                    <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                    <td><% out.print(entidadBancaria.getNombre());%></td>
                    <td><% out.print(entidadBancaria.getCif());%></td>    
                    <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td>

                    <td><a href="Borrar.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidad()%>">BORRAR</a>
                    </td>
                    <td><a href="ViewforUpdate.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidad()%>">MODIFICAR</a>
                    </td>

                </tr>
                <% }%>

            </table>

        </div>   

        <div align="center"> 
            <p>Tu entidad Bancaria por nombre es:</p> 

            <table border="solid">

                <% for (EntidadBancaria entidadBancaria : entidadesBancariasNombre) {
                %><tr><td><%  out.print(entidadBancaria.getCodigo());%></td>
                    <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                    <td><% out.print(entidadBancaria.getNombre());%></td>
                    <td><% out.print(entidadBancaria.getCif());%></td>    
                    <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td></tr>
                    <% }%>

            </table>

        </div>  


        <% out.print(nombre);%>

        <br></br>
        <a href="ViewforInsert.jsp">Nuevo_JSP</a><br></br>
        <!--<a href="ViewforUpdate.jsp">View For Update</a>-->
    </body>
</html>