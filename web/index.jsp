<%@page import="Datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="Datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%>
<%@page import="Datos.EntidadBancariaDAO"%>


<%

    //EntidadBancaria entidadBancaria =  entidadBancariaDAO.read(1);
    EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    //EntidadBancariaDAOImpJDBC entidadBancariaDAO = new EntidadBancariaDAOImpJDBC(); //impJDBC

    //List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();  //Tambien con JDBC


    String nombre = request.getParameter("nombre");


    List<EntidadBancaria> entidadesBancariasNombre = entidadBancariaDAO.findByNombre(nombre);

%>

<html>
    <head>
        <title>-- BANCO --</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap.js"></script>

    </head>

    <body>

        <% //out.print(nombre); TEST PARA COMPROBAR SI RECIBE BIEN EL NOMBRE%>

        <h2 align="center">Tus entidades:</h2> 

        <h3>Introduce nombre Entidad Bancaria</h3>
        <form METHOD="Get" ACTION="http://localhost:8084/BancoWeb/index.jsp">
            <input class="form-control" type="text" name="nombre" placeholder="Introduce AQUI la entidad bancaria que desees"/>
        </form>


        <div align="center"> 

            <table border="solid" class="table table-striped">

                <% for (EntidadBancaria entidadBancaria : entidadesBancariasNombre) {
                %><tr class="danger">  <td><% out.print(entidadBancaria.getIdEntidad());%></td>
                    <td><% out.print(entidadBancaria.getCodigoEntidad());%></td>
                    <td><% out.print(entidadBancaria.getNombre());%></td>
                    <td><% out.print(entidadBancaria.getCif());%></td>    
                    <td><% out.print(entidadBancaria.getTipoEntidadBancaria());%></td>

                    <td><a class="btn btn-primary" href="Borrar.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidad()%>">BORRAR</a>
                    </td>
                    <td><a class="btn btn-danger" href="ViewforUpdate.jsp?idEntidadBancaria=<%=entidadBancaria.getIdEntidad()%>">MODIFICAR</a>
                    </td>

                </tr>
                <% }%>

            </table>
        </div>

        <br>

        <a class="btn btn-success" href="ViewforInsert.jsp">Nuevo_JSP</a><br></br>
        <a class="btn btn-danger" href="Buscar.jsp">Buscar Por Nombre --- Link obsoleto pero funcional</a><br></br>
    </body>
</html>