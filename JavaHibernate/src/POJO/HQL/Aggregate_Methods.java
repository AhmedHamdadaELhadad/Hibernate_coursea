package POJO.HQL;

import POJO.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class Aggregate_Methods {

    public void opertaion() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            Query q1 = s.createQuery("Select max(id) from Person");
            Query q2 = s.createQuery("Select MIN(id) from Person");
            Query q3 = s.createQuery("Select sum(salary) from Person");
            Query q4 = s.createQuery("Select count(id) from Person");
             Query q5 = s.createQuery("Select count(distinct position) from Person");
            Query q6 = s.createQuery("Select avg(id) from Person"); 
             
            System.out.println("The MAX ID IS: " + q1.list().get(0));
            System.out.println("The MIN ID IS: " + q2.list().get(0));
            System.out.println("The SUM salary IS: " + q3.list().get(0));
            System.out.println("The count ID IS: " + q4.list().get(0));
             System.out.println("The avg ID IS: " + q5.list().get(0));
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
