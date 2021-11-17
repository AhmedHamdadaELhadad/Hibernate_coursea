package POJO;

import POJO.HQL.Person;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CHQL {

    public void Criterial() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            Criteria c = s.createCriteria(Person.class);
            Integer[] valus = {6250, 6666, 2};
            c.setFirstResult(0);
            c.setMaxResults(4);
            c.add(Restrictions.isNotNull("salary"));
            c.add(Restrictions.ge("salary", 1000));
            c.add(Restrictions.between("salary", 1200, 122200));
            c.add(Restrictions.like("name", "A", MatchMode.ANYWHERE));
            c.add(Restrictions.lt("salary", 500));
            c.add(Restrictions.le("salary", 500));
            c.add(Restrictions.between("salary", 1200, 122200));
            c.add(Restrictions.like("salary", 5555));

            c.add(Restrictions.in("salary", valus));
            c.add(Restrictions.isNull("name"));
            c.add(Restrictions.ne("name", "Ali"));

            c.setProjection(Projections.property("name"));
            List p = c.list();
            for (int i = 0; i < p.size(); ++i) {
                System.out.println(p.get(i));

            }

            Criterion c1 = Restrictions.eq("position", "junior");
            Criterion c2 = Restrictions.like("name", "a", MatchMode.ANYWHERE);

            LogicalExpression log1 = Restrictions.or(c1, c2);
            LogicalExpression log2 = Restrictions.and(c1, c2);
            c.add(log2);
            List<Person> per = c.list();
            for (Person pp : per) {

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

    public void AggregateMehtod() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            Criteria c1 = s.createCriteria(Person.class);
            c1.setProjection(Projections.max("salary"));
            List<Person> max = c1.list();
            Criteria c2 = s.createCriteria(Person.class);
            Criteria min = c2.setProjection(Projections.min("salary"));

            Criteria c3 = s.createCriteria(Person.class);
            Criteria sum = c3.setProjection(Projections.sum("salary"));
            Criteria c4 = s.createCriteria(Person.class);
            Criteria count = c4.setProjection(Projections.count("salary"));
            Criteria c5 = s.createCriteria(Person.class);
            Criteria dicount = c5.setProjection(Projections.countDistinct("salary"));
            Criteria c6 = s.createCriteria(Person.class);
            Criteria avg = c6.setProjection(Projections.avg("salary"));

            System.out.println("The max IS: " + max.get(0));
            System.out.println("The min IS: " + min.list().get(0));
            System.out.println("The sum IS: " + sum.list().get(0));
            System.out.println("The count IS:" + count.list().get(0));
            System.out.println("The ava IS: " + avg.list().get(0));

        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
