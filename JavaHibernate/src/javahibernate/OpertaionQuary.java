package javahibernate;

import POJO.Employee;
import POJO.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class OpertaionQuary {

    public void seletLimit() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {

            List<Employee> e;
            Query query = s.createQuery("from Employee");
            query.setFirstResult(3);
            query.setMaxResults(5);
            e = query.list();
            System.out.println("**************************");
            System.out.println("ID is " + e.get(1).getId());
            System.out.println("Name is " + e.get(1).getFullName());
            System.out.println("Address  is :" + e.get(1).getAddress());
            System.out.println("Age  is :" + e.get(1).getAge());
            System.out.println("Data  is " + e.get(1).getHireData());
            System.out.println("Time is " + e.get(1).getTime());
            System.out.println("**************************");

            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void seletByName(String name) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {

            Employee e = new Employee();
            // Query q= s.createQuery(" from Employee e WHERE e.fullName = 'sara' ");
            Query q = s.createQuery(" from Employee e WHERE e.fullName =: n ");
            q.setParameter("n", name);
            e = (Employee) q.uniqueResult();
            System.out.println(e);
            /* System.out.println("**************************");
            System.out.println("ID is " + e.getId());
            System.out.println("Name is " + e.getFullName());
            System.out.println("Address  is :" + e.getAddress());
            System.out.println("Age  is :" + e.getAge());
            System.out.println("Data  is " + e.getHireData());
            System.out.println("Time is " + e.getTime());
            System.out.println("**************************");
             */
            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

    public void UpdatatByName(String name) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        try {
            Employee e = new Employee();
            Query q = s.createQuery("update Employee set fullName=:n where id=:i");
            q.setParameter("n", name);
            q.setParameter("i", 3);
            q.executeUpdate();
            int status = q.executeUpdate();
            System.out.println(status);
            s.getTransaction().commit();

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }
}
