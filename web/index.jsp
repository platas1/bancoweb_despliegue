<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAO"%>


<%
       
EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO(); //impJDBC

//EntidadBancaria entidadBancaria =  entidadBancariaDAO.read(1);

List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();


String nombre=request.getParameter("nombre");

List<EntidadBancaria> entidadesBancariasNombre = entidadBancariaDAO.findByNombre(nombre);

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