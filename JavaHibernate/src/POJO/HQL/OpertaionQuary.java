package POJO.HQL;

import POJO.Employee;
import POJO.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import static org.hibernate.hql.internal.antlr.HqlSqlTokenTypes.UPDATE;

public class OpertaionQuary {

    public void insertbyQuary(String n, int sa, String pos, String loc) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            Person person = new Person();
            person.setName(n);
            person.setSalary(sa);
            person.setJobTitle(pos);
            person.setPosition(loc);

            s.save(person);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void seletAll() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            List<Person> person = new ArrayList<>();
            //usally use and ,or ,Between ,..
            Query q = s.createQuery("From Person p where p.name='Ahmed' OR p.salary Between 1200 and 8000 ");
            person = q.list();
            for (Person pp : person) {

                System.out.println("The ID IS: " + pp.getId());
                System.out.println("The Name IS: " + pp.getName());
                System.out.println("The Salary IS: " + pp.getSalary());
                System.out.println("The JobTitle IS: " + pp.getJobTitle());
                System.out.println("The Position IS: " + pp.getPosition());

            }

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void seletAllbycharater() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            List<Person> person = new ArrayList<>();
            //usally use and ,or ,Between ,..
            Query q = s.createQuery("From Person p where p.name like '%A%' ");
            person = q.list();
            for (Person pp : person) {

                System.out.println("The ID IS: " + pp.getId());
                System.out.println("The Name IS: " + pp.getName());
                System.out.println("The Salary IS: " + pp.getSalary());
                System.out.println("The JobTitle IS: " + pp.getJobTitle());
                System.out.println("The Position IS: " + pp.getPosition());

            }

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

    public void seletLimit(int Frist, int max) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            List<Person> person = new ArrayList<>();
            Query q = s.createQuery("From Person p order by p.name ASC ");

            q.setFirstResult(Frist);
            q.setMaxResults(max);

            person = q.list();
            for (Person pp : person) {

                System.out.println("The ID IS: " + pp.getId());
                System.out.println("The Name IS: " + pp.getName());
                System.out.println("The Salary IS: " + pp.getSalary());
                System.out.println("The JobTitle IS: " + pp.getJobTitle());
                System.out.println("The Position IS: " + pp.getPosition());

            }

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
        Person pp = new Person();
        try {
            Query q = s.createQuery("From Person p where p.name=:?");

            q.setString("?", name);

            //q.setParameter("n", name);
            pp = (Person) q.uniqueResult();
            System.out.println("The ID IS: " + pp.getId());
            System.out.println("The Name IS: " + pp.getName());
            System.out.println("The Salary IS: " + pp.getSalary());
            System.out.println("The JobTitle IS: " + pp.getJobTitle());
            System.out.println("The Position IS: " + pp.getPosition());
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

    public void Update() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        String str = "UPDATE Person set salary = :salary " + "WHERE id = :person_id";
        Query q = s.createQuery(str);
        q.setParameter("salary", 1000);
        q.setParameter("person_id", 10);
        //"update Person set salary 3450 where id=2 "

        int result = q.executeUpdate();
        System.out.println("Rows affected: " + result);
        s.getTransaction().commit();
        try {

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

    public void delete() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery(" DELETE FROM Person WHERE name = 'Ahmed' ");
        int result = q.executeUpdate();
        System.out.println("Rows affected: " + result);
        try {

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }

}
