/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerhibernate;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static SessionFactory factory;
    
    public static void main(String[] args) {
        factory = new Configuration().configure(new File("src\\powerhibernate\\hibernate.cfg.xml")).buildSessionFactory();
        
        addStudent( new Student ("Viktor", 5) );
        
        
        
        
    }

    private static void addStudent(Student student) {
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        
        Integer insertID = (Integer) session.save(student);
        tr.commit();
        session.close();
        
    }
    
}
