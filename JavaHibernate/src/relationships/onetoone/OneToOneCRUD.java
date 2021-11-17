package relationships.onetoone;

import POJO.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class OneToOneCRUD {

    public void save() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            student s = new student();
            book bo = new book();
            s.setName("AHMED");
            bo.setNameBook("introduction to java ");
            s.setBo(bo);
            session.save(s);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());

        } finally {
            System.out.println("finsied");
            session.close();
        }

    }

    public void select() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            student s = new student();
            s.setId(5);
            student res = (student) session.get(student.class, s.getId());
            System.out.println("Name is " + res.getName());
            System.out.println("BOok is " + res.getBo().getNameBook());

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());

        } finally {

            session.close();
        }

    }
 public void deldet(int id ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            student s = new student();
            s.setId(id);
            student res = (student) session.get(student.class, s.getId());
            session.delete(res);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());

        } finally {

            session.close();
        }

    }
  public void updata(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            student s = new student();
            s.setId(id);
            student res = (student) session.get(student.class, s.getId());
           res.setName("haba");
           res.getBo().setNameBook("data analysis ");
           
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());

        } finally {

            session.close();
        }

    }
   public void selettbybook( ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            book bo=new book();
            bo.setId(0);
            book res = (book) session.get(book.class, bo.getId());
            
            System.out.println("Name is " + res.getNameBook());
            System.out.println("BOok is " + res.getStu().getName());
            
            
            session.delete(res);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            System.out.println(he.toString());

        } finally {

            session.close();
        }
}}
