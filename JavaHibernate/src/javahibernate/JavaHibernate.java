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
      
        crud.insert(" mostafa","25-3-2201",new Date(),"26","shabin elkom");
      
    }


    /*     
  try {

	
            java.sql.Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?serverTimezone=UTC",
                    "root",
                    ""
            );
    JOptionPane.showInputDialog("null","WEEL");
      System.out.println(c);
  }catch(Exception E){
      System.out.println(E.toString());
  
  }
     */
}
