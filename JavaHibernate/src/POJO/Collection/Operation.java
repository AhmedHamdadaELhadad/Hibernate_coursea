package POJO.Collection;

import POJO.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Operation {

    public void insertCollection() {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            Student s=new Student();
            s.setName("Ahmed");
            Adress ad1=new Adress();
            ad1.setCity("kom hmada");
            ad1.setStates("ELb7are");
            ad1.setStreet("13 str ELmo3s");
             Adress ad2=new Adress();
            ad2.setCity("fasha");
            ad2.setStates("Menufia");
            ad2.setStreet("16 str elstraha ");
             Adress ad3=new Adress();
            ad3.setCity("el salma");
            ad3.setStates("Cairo");
            ad3.setStreet("19 str elkalefa");
            s.getAd().add(ad1);
            s.getAd().add(ad2);
            s.getAd().add(ad3);
            session.save(s);
            
            session.getTransaction().commit();
            
        } catch (HibernateException e) {

            System.out.println(e.getMessage());

        } finally {
            session.close();
        }

    }
    
    
    
    
      public void deletCollection() {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            Student s=new Student();
           s= (Student) session.get(Student.class, 1);
            session.delete(s);
            
            
            session.getTransaction().commit();
            
        } catch (HibernateException e) {

            System.out.println(e.getMessage());

        } finally {
            session.close();
        }

    }
    
    
    
    
    
    
}
