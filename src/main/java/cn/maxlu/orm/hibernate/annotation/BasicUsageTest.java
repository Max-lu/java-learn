package cn.maxlu.orm.hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by luwei on 2017/6/1.
 */
class BasicUsageTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate/hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        //creating transaction object
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
//        e1.setId(100);
        e1.setFirstName("Max");
        e1.setLastName("lu");

        session.persist(e1);//persisting the object

        t.commit();//transaction is committed
        session.close();
        factory.close();

        System.out.println("successfully saved");
    }
}
