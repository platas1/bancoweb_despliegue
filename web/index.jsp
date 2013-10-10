<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAO"%>


<%
       
EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();

//EntidadBancaria entidadBancaria =  entidadBancariaDAO.read(1);

List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();

%>

<html>
    <head>
        <title>Fecha</title>
    </head>
    <body>
        <div align="center"> 
            <p>Tu entidad Bancaria es:</p> 
                
            <table border="solid">
                
           <% for(EntidadBancaria entidadBancaria:entidadesBancarias){ 
                %><tr><td><%  out.print(entidadBancaria.getCodigo());%></td>
                <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                <td><% out.print(entidadBancaria.getNombre()); %></td>
                <td><% out.print(entidadBancaria.getCif()); %></td>    
                <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td></tr>
   <% } %>
   
            </table>
          
        </div>
    </body>
</html>