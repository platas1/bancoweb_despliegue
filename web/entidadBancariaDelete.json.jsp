<%@page import="Datos.EntidadBancariaDAO"%><%@page import="Negocio.EntidadBancaria"%><%@page import="Datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
  //Llamo a entidadBancaria
    String idEntidadString = request.getParameter("idEntidad");
    Integer idEntidadBancariaInteger = Integer.parseInt(idEntidadString);
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate(); //impJDBC
    entidadBancariaDAO.delete(idEntidadBancariaInteger);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(null); // nombre de lo que devuelvo
    response.setContentType("application/json; charset=UTF-8");
    out.print(json);
%>