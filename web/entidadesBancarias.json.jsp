<%@page import="java.util.List"%>
<%@page import="Negocio.EntidadBancaria"%><%@page import="Datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
  //Llamo a entidadBancaria
    String nombre=request.getParameter("nombre"); //recibo variable desde el index para que busque
    List<EntidadBancaria> entidadBancaria = new EntidadBancariaDAOImpHibernate().findByNombre(nombre); // con find by codigo pongo (1)
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(entidadBancaria);
    response.setContentType("application/json; charset=UTF-8");
    out.print(json);
%>