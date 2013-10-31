package Datos;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author alumno
 */
public class HibernateContextListenerAndFilter implements ServletContextListener{

      // NO ESTA IMPLEMENTADO AUNHibernateUtil.buildSessionFactory();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      //AQUI LLAMARE EL BUILD SESSION FACTORY
          System.out.println("Hola estoy inicializando");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
          System.out.println("Hola estoy cerrando");
       //AQUI LLAMARE EL CLOSE SESSION FACTORY 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
