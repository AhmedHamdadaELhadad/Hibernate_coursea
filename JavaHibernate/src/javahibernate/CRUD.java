package javahibernate;

import POJO.Employee;
import POJO.NewHibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CRUD {

    public void insert(String name, String Date, Date time, String age, String address) throws ParseException {

        Session s = NewHibernateUtil.getSessionFactory().openSession();

        try {
            s.beginTransaction();

            Employee employee3 = new Employee();
            employee3.setFullName(name);
            employee3.setHireData(new SimpleDateFormat("dd-MM-yyyy").parse(Date));
            employee3.setTime(new Date());
            employee3.setAge(age);
            employee3.setAddress(address);
           
            s.save(employee3);

            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

    public void delete(Long id) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();

        try {
            s.beginTransaction();
            Employee e = new Employee();
            e = (Employee) s.get(Employee.class, id);
            s.delete(e);

            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void selcet(Long id) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        try {
           // s.beginTransaction();
            Employee e = new Employee();
            e = (Employee) s.get(Employee.class, id);
            System.out.println("Id is " + e.getId());
            System.out.println("Name is " + e.getFullName());
            System.out.println("Address  is :" + e.getAddress());
            System.out.println("Age  is :" + e.getAge());
          
            System.out.println("Date is :" + e.getHireData());
            System.out.println("TIME  is :" + e.getTime());
         //   s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void updata(Long id) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();

        try {
            s.beginTransaction();
            Employee e = new Employee();

            e = (Employee) s.get(Employee.class, id);
            e.setFullName("sara");

            e.setHireData(new Date());
            e.setTime(new Date());
            e.setAge("25");
            e.setAddress("Mansoura");
            s.update(e);

            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void selcetAllData() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();

        try {
            s.beginTransaction();
            List<Employee> e;
            e = s.createQuery("From Employee").list();
            for (Employee ee : e) {
                System.out.println("**************************");
                System.out.println("ID is " + ee.getId());
                System.out.println("Name is " + ee.getFullName());
                System.out.println("Address  is :" + ee.getAddress());
                System.out.println("Age  is :" + ee.getAge());
                System.out.println("Data  is " + ee.getHireData());
                System.out.println("Time is " + ee.getTime());
                System.out.println("**************************");
            }

            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

}
