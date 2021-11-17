package javahibernate;

import POJO.CHQL;
import POJO.CRUD;
import POJO.HQL.OpertaionQuary;
import POJO.NewHibernateUtil;
import java.text.ParseException;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import relationships.manytomany.Car;
import relationships.manytomany.Color;
import relationships.manytoone.ManyToOneCRUD;
import relationships.onetoone.OneToOneCRUD;

public class Hibernate {

    public static void main(String[] args) throws ParseException {

        //CRUD OPERATION in Employee class 
        CRUD crud = new CRUD();
        crud.insert("Ahmed", "2-5-2002", new Date(), "11", "mostafa sa3d");
        crud.selcet(5l);
        crud.selcetAllData();
        crud.delete(5L);
        crud.updata(5L);

        //  HQL operation and Uses
        OpertaionQuary hql = new OpertaionQuary();
        hql.insertbyQuary("MOHMED", 11, "senior", "dataEnginnering");
        hql.seletLimit(0, 5);
        hql.seletAll();
        hql.seletByName("Ahmed");
        hql.seletAllbycharater();
        hql.Update();
        hql.delete();

        //Criterial method 
        CHQL ch = new CHQL();
        ch.Criterial();
        ch.AggregateMehtod();

        //operation for one to one 
        OneToOneCRUD oto = new OneToOneCRUD();
        oto.save();
        oto.select();
        oto.updata(2);
        oto.deldet(2);
        oto.selettbybook();

        //operation for Many to One
        ManyToOneCRUD mto = new ManyToOneCRUD();
        mto.insert();
        mto.get();
        mto.updata();
        mto.delete();

        // operation for Many To Many 
        ManyToOneCRUD m = new ManyToOneCRUD();
        m.insert();
        m.get();
        m.updata();
        m.delete();

    }
}
