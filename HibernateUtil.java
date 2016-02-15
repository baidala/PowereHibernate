/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Student
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory  getSessionFactory() {
        if ( sessionFactory == null ){
            Configuration configuration = new Configuration().configure();
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            //configuration.addClass(powerhibernate.Student.class);
            // Read mappings as a application resourceName
            // addResource is for add hbml.xml files in case of declarative approach
            configuration.addResource("powerhibernate/Student.hbm.xml"); 
            sessionFactory = configuration.buildSessionFactory(sr);
        }
    return sessionFactory;
    }
    
    
    

}
