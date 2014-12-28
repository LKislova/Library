package library.dao;

import library.entity.BookObject;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository
//@Transactional
public class BookDao extends DAO {
    public BookObject createBook(BookObject bookObject)
            throws Exception {
        try {
//            Session session = null;
            begin();
            getSession().save(bookObject);
            commit();
            return bookObject;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create author ", e);
        }
    }

    public List<BookObject> listBook() throws Exception {
        try {
//            Session session = null;
            begin();
            String hql = "FROM BookObject ";//!!!!!
            List<BookObject> bookObjects = getSession().createQuery(hql).list();
            commit();
            return bookObjects;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get book list", e);
        }
    }

    public BookObject updateBook(BookObject bookObject) throws Exception {
        try {
//            Session session = null;
            begin();
            getSession().update(bookObject);
            commit();
            return bookObject;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not update book ", e);
        }
    }

    public BookObject getBookParameters(Integer id) throws Exception {
        try {
//            Session session = null;
            begin();
            String hql = "FROM BookObject where id=:bookId";
            Query query = getSession().createQuery(hql);
            query.setParameter("bookId", id);
            commit();

            return (BookObject) query.list().get(0);
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }
}
