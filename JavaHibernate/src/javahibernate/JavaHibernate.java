package javahibernate;

import POJO.Collection.Operation;
import POJO.Employee;
import POJO.HQL.Aggregate_Methods;
import POJO.HQL.OpertaionQuary;
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

       /* OpertaionQuary opq = new OpertaionQuary();
        opq.insertbyQuary("mazan",5050,"backend","SemiSenior");
      opq.seletByName("AHMED");
       opq.seletLimit(0, 3);
      opq.seletByName("Ahmed");
      
       opq.UpdatatBySalary();
      
       opq.Update();
        */

 /*CRUD crud = new CRUD();
       crud.delete(29L);
      crud.updata(24L);
      crud.selcet(3L);*/
 /*  
        operation op=new operation();
        op.insert();
       
       Operation o=new Operation();
     //  o.insertCollection();
        o.deletCollection();*/
 
 
        Aggregate_Methods agm =new  Aggregate_Methods();
        agm.opertaion();
 
 
 
 
 
 
    }

}
