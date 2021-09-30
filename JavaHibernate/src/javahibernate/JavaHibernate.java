package javahibernate;

import POJO.Collection.Operation;
import POJO.Employee;
import POJO.NewHibernateUtil;
import POJO.TwoClassInOneTable.operation;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class JavaHibernate {

    public static void main(String[] args) throws ParseException {
        

        
      /*  
        operation op=new operation();
        op.insert();
        */
        
        
       Operation o=new Operation();
     //  o.insertCollection();
        o.deletCollection();
        
        
        
        
        
        
        
        
        
        
        /*CRUD crud = new CRUD();
       crud.delete(29L);
      crud.updata(24L);
      crud.selcet(3L);*/

    }

  
}
