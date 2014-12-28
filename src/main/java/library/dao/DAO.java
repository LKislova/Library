package library.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by trainee on 11.12.14.
 */
public class DAO {


    @Autowired
    protected SessionFactory sessionFactory;
    protected DAO() {
    }

    public  Session getSession() {

        return  sessionFactory.getCurrentSession();
    }
}

