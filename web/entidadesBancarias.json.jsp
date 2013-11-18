<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%><%@page import="Datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
  //Llamo a entidadBancaria
    List<EntidadBancaria> entidadBancaria = new EntidadBancariaDAOImpHibernate().findAll();
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(entidadBancaria);
    response.setContentType("application/json; charset=UTF-8");
    out.print(json);
%>