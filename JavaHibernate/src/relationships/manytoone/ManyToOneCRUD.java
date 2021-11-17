package relationships.manytoone;

import POJO.NewHibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneCRUD {
    
    public void insert() {
        /* SessionFactory sf = new Configuration().configure("").
               
                addAnnotatedClass(Man.class)
                .addAnnotatedClass(Info.class)
                .buildSessionFactory();*/
        Session session = (Session) NewHibernateUtil.getSessionFactory();
        try {
            session.beginTransaction();
            Man man = new Man();
            Info info1 = new Info();
            man.setName("mohmed");
            info1.setPhone("01203859650");
            Info info2 = new Info();
            info2.setPhone("599944455");
            
            man.getInfo().add(info1);
            man.getInfo().add(info2);
            info1.setMan(man);
            info2.setMan(man);
            
            session.save(man);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());
            
        } finally {
            System.out.println("finsied");
            session.close();
        }
        
    }
    
    public void get() {
        
        Session session = (Session) NewHibernateUtil.getSessionFactory();
        try {
            session.beginTransaction();
            Man m = new Man();
            m = (Man) session.get(Man.class, 2);
            
            System.out.println("Name is" + m.getName());
            for (Info ff : m.getInfo()) {
                
                System.out.println("Phones is " + ff.getPhone());
                
            }
             session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());
            
        } finally {
            System.out.println("finsied");
            session.close();
        }
        
    }

    public void updata() {
        
        Session session = (Session) NewHibernateUtil.getSessionFactory();
        try {
            session.beginTransaction();
            Man m = new Man();
            m = (Man) session.get(Man.class, 2);
            m.setName("mostafa");   
            m.getInfo().get(0).setPhone("1111111");
            m.getInfo().get(1).setPhone("44444");
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());
             
        } finally {
            System.out.println("finsied");
            session.close();
        }
        
    }
    
    
     public void delete() {
        
        Session session = (Session) NewHibernateUtil.getSessionFactory();
        try {
            session.beginTransaction();
            Man m = new Man();
            m = (Man) session.get(Man.class, 2);
            session.delete(m);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());
             
        } finally {
            System.out.println("finsied");
            session.close();
        }
        
    }
}
