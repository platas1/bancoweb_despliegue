package Presentacion;

import Datos.EntidadBancariaDAO;
import Negocio.EntidadBancaria;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;
    //Estas son las dos entidades creadas con Autowired , se hace con autowired applicationContext
    // estas son las dos entidades entidadBancaria que he comentado en la clase delete y read

    @RequestMapping(value = {"/EntidadBancaria/{idEntidad}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidad") int idEntidad) throws IOException {

        try {
            //EntidadBancaria entidadBancaria = new EntidadBancariaDAOImpHibernate().read(idEntidad);
            EntidadBancaria entidadBancaria = entidadBancariaDAO.read(idEntidad); //creo variable para pasarla abajo
            
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(entidadBancaria); //Aqui la variable creada
            httpServletResponse.getWriter().println(json);
            
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidad}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidad") int idEntidad) {

        try {
            //EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate(); 
            entidadBancariaDAO.delete(idEntidad);
            /*ObjectMapper objectMapper = new ObjectMapper();
             String json = objectMapper.writeValueAsString(null);
             httpServletResponse.setContentType("application/json; charset=UTF-8");
             httpServletResponse.getWriter().println(json);*/
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }
}