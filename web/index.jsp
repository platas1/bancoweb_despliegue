<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAO"%>


<%
       
EntidadBancariaDAOImpJDBC entidadBancariaDAOImpJDBC = new EntidadBancariaDAOImpJDBC(); //impJDBC

//EntidadBancaria entidadBancaria =  entidadBancariaDAO.read(1);

List<EntidadBancaria> entidadesBancarias = entidadBancariaDAOImpJDBC.findAll();


String nombre=request.getParameter("nombre");


List<EntidadBancaria> entidadesBancariasNombre = entidadBancariaDAOImpJDBC.findByNombre(nombre);

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
                %><tr>  <td><% out.print(entidadBancaria.getIdEntidad());%></td>
                    <td><%  out.print(entidadBancaria.getCodigo());%></td>
                                    <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                <td><% out.print(entidadBancaria.getNombre()); %></td>
                <td><% out.print(entidadBancaria.getCif()); %></td>    
                <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                
                <td><a href="Borrar.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidad()%>">BORRAR</a>
                 </td>
                
                </tr>
   <% } %>
   
            </table>
          
        </div>   
   
           <div align="center"> 
            <p>Tu entidad Bancaria por nombre es:</p> 
                
            <table border="solid">
                
           <% for(EntidadBancaria entidadBancaria:entidadesBancariasNombre){ 
                %><tr><td><%  out.print(entidadBancaria.getCodigo());%></td>
                <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                <td><% out.print(entidadBancaria.getNombre()); %></td>
                <td><% out.print(entidadBancaria.getCif()); %></td>    
                <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td></tr>
   <% } %>
   
            </table>
          
        </div>  
   
   
  <% out.print(nombre);%>
   
    </body>
</html>