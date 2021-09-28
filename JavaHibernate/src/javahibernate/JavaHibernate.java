package javahibernate;

import POJO.Employee;
import POJO.NewHibernateUtil;
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
        
 
        CRUD crud = new CRUD();
      
        crud.insert(" omar","23-8-2001",new Date(),"37","shabin elkom");
      crud.selcet(29L);
    }


  
}
