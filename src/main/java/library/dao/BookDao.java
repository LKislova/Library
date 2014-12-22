package library.dao;

import library.entity.AuthorObject;
import library.entity.BookObject;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository
public class BookDao extends DAO {
    public BookObject createBook(BookObject bookObject)
            throws Exception {
        try {
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
            String hql = "FROM BookObject ";//!!!!!
            List<BookObject> bookObjects = getSession().createQuery(hql).list();
            return bookObjects;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get book list", e);
        }
    }

    public BookObject updateBook(BookObject bookObject) throws Exception {
        Session session = null;
        try {
            begin();
            getSession().save(bookObject);
            commit();
            return bookObject;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create author ", e);
        }
    }

    public BookObject getBookParameters(Integer id) throws Exception {
        try {
            String hql = "FROM BookObject where id=:bookId";
            Query query = getSession().createQuery(hql);
            query.setParameter("bookId", id);
            return (BookObject) query.list().get(0);
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }
}
