/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerhibernate;

import java.io.File;
import java.util.ArrayList;
import org.hibernate.HibernateException;
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
        //factory = new Configuration().configure(new File("src\\powerhibernate\\hibernate.cfg.xml")).buildSessionFactory();
        
        factory = HibernateUtil.getSessionFactory();
                
        //addStudent( new Student ("Viktor", 25) );
        listStudent();
        
        
        
        
    }

   // private static void addStudent(Student student) {
    //    Session session = factory.openSession();
    //    Transaction tr = session.beginTransaction();
        
     //   Integer insertID = (Integer) session.save(student);
      //  tr.commit();
       // session.close();
        
    //}
    
    private static Integer addStudent(Student student) {
        Session session = factory.openSession();
        Transaction tr = null;
        Integer studentID = null;
        try {
            tr = session.beginTransaction();
            studentID = (Integer) session.save(student);
            tr.commit();
        } catch (HibernateException ex) {
            if ( tr != null ) {
            tr.rollback();
            }
        }
        finally {
            session.close();
        }
        return studentID;
    }
    
    
    
    
    public static void listStudent() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ArrayList<Student> listStudent = (ArrayList<Student>) session.createQuery("FROM Student").list();
            for (int i = 0; i < listStudent.size(); i++) {
                System.out.println(listStudent.get(i)); 
            }
            tx.commit();
        } catch (HibernateException ex) {
            if ( tx != null ) {
                tx.rollback();
            }
                    
                    
        }
       
    }
    
}
