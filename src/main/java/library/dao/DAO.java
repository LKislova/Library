package library.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by trainee on 11.12.14.
 */
public class DAO {
    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
//    private static SessionFactory sessionFactory = createSessionFactory();
    @Autowired
    protected SessionFactory sessionFactory;

//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//    public static SessionFactory createSessionFactory() {
////        ServiceRegistry serviceRegistry;
//        Configuration configuration = new Configuration();
//        configuration.configure();
////        serviceRegistry = new ServiceRegistryBuilder().applySettings(
////                configuration.getProperties()).buildServiceRegistry();
//        return configuration.buildSessionFactory(/*serviceRegistry*/);
//    }
    protected DAO() {
    }
//
    public  Session getSession() {
        Session session = (Session) DAO.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            DAO.session.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.session.set(null);
    }

    public  void close() {
        getSession().close();
        DAO.session.set(null);
    }
}

