<%@page import="Negocio.EntidadBancaria"%><%@page import="Datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
  //Llamo a entidadBancaria
    String idEntidadString = request.getParameter("idEntidad");  ///
    Integer idEntidadBancariaInteger = Integer.parseInt(idEntidadString); ///
    EntidadBancaria entidadBancaria = new EntidadBancariaDAOImpHibernate().read(idEntidadBancariaInteger/*1*/);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(entidadBancaria);
    response.setContentType("application/json; charset=UTF-8");
    out.print(json);
%>