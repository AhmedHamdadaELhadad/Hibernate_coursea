package POJO.TwoClassInOneTable;

import POJO.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class operation {

    public void insert() {

        Session s = NewHibernateUtil.getSessionFactory().openSession();

        try {
            s.beginTransaction();
            location loc = new location();
            loc.setForm_Loacation("ALEX");
            loc.setTo_Loacation("CAIRO");
            
            embassdor emd = new embassdor();
            
            emd.setFullname("ahemd");
            
            emd.setLo(loc);
          
            s.save(emd);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

}
