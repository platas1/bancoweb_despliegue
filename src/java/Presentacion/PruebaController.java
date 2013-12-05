package Presentacion;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PruebaController {

    @RequestMapping({"/beer.json"}) //Este fichero no existe.. Mi página json es lo que hay a continuación
    public void read(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("Hola");
        } catch (IOException ex) {
            Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
