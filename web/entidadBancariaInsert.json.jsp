<%@page import="Negocio.TipoEntidadBancaria"%>
<%@page import="Negocio.EntidadBancaria"%><%@page import="Datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
    //Llamo a entidadBancaria
    EntidadBancariaDAOImpHibernate entidadBancaria = new EntidadBancariaDAOImpHibernate(); //impJDBC
    String idEntidad = request.getParameter("idEntidad");
    Integer idEntidadBancaria = Integer.parseInt(idEntidad);
    String codigoEntidad = request.getParameter("codigoEntidad");
    String nombre = request.getParameter("nombre");
    String cif = request.getParameter("cif");
    String tipoEntidadBancariaString = request.getParameter("tipoEntidadBancaria");
    TipoEntidadBancaria tipoEntidadBancaria = TipoEntidadBancaria.valueOf(tipoEntidadBancariaString);
    EntidadBancaria entidadBancariaInserta = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, tipoEntidadBancaria);
    entidadBancaria.insert(entidadBancariaInserta);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(entidadBancaria);
    response.setContentType("application/json; charset=UTF-8");
    out.print(json);
%>