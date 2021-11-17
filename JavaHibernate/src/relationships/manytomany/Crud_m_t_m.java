package relationships.manytomany;

import POJO.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Crud_m_t_m {

    public void addData() {
        Session session = (Session) NewHibernateUtil.getSessionFactory();
        try {
            session.beginTransaction();
            // creat object of Color
            Color col1 = new Color();
            Color col2 = new Color();
            Color col3 = new Color();
            col1.setName("red");
            col2.setName("yellow");
            col3.setName("blue");
            // creat object of Car
            Car c1 = new Car("BMW");
            Car c2 = new Car("LISENER");
            Car c3 = new Car("BYD");

            //Set Color in Car 
            //set all Color in Car1
            c1.getList().add(col1);
            c1.getList().add(col2);
            c1.getList().add(col3);

            c2.getList().add(col1);
            c2.getList().add(col2);
            c2.getList().add(col3);

            c3.getList().add(col1);
            c3.getList().add(col2);
            c3.getList().add(col3);

            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.getTransaction().commit();

        } catch (HibernateException he) {
            he.toString();

        }

    }

    public void getdata() {

        int id = 2;
        Session s = (Session) NewHibernateUtil.getSessionFactory();

        try {
            s.beginTransaction();

            Car c = (Car) s.get(Car.class, id);

            System.out.println(c.getName());
            for (Color cc : c.getList()) {

                System.out.println(cc.getName());

            }
             s.getTransaction().commit();
        } catch (HibernateException he) {
            he.toString();

        } finally {

            s.close();
        }

    }

    public void editdata() {

        int id = 2;
        Session s = (Session) NewHibernateUtil.getSessionFactory();

        try {
            s.beginTransaction();

            Car c = (Car) s.get(Car.class, id);
            c.setName("KAKAI");
           c.getList().get(0).setName("yellow");
           c.getList().get(1).setName("Green");
           c.getList().get(3).setName("BLack");
            s.getTransaction().commit();
        } catch (HibernateException he) {
            he.toString();

        } finally {

            s.close();
        }

    }
        public void deletedata() {

        int id = 2;
        Session s = (Session) NewHibernateUtil.getSessionFactory();

        try {
            s.beginTransaction();

            Car c = (Car) s.get(Car.class, id);
            s.delete(c);
            s.getTransaction().commit();
        } catch (HibernateException he) {
            he.toString();

        } finally {

            s.close();
        }

    }
}
