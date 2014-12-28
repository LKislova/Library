package library.dao;

import library.entity.BookObject;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository

public class BookDao extends DAO {
    @Transactional(readOnly = false)
    public BookObject createBook(BookObject bookObject)
            throws Exception {

        getSession().save(bookObject);

        return bookObject;

    }

    @Transactional(readOnly = true)
    public List<BookObject> listBook() throws Exception {

        String hql = "FROM BookObject ";//!!!!!
        List<BookObject> bookObjects = getSession().createQuery(hql).list();

        return bookObjects;

    }

    @Transactional(readOnly = false)
    public BookObject updateBook(BookObject bookObject) throws Exception {

        getSession().update(bookObject);

        return bookObject;

    }

    @Transactional(readOnly = true)
    public BookObject getBookParameters(Integer id) throws Exception {

        String hql = "FROM BookObject where id=:bookId";
        Query query = getSession().createQuery(hql);
        query.setParameter("bookId", id);
        return (BookObject) query.list().get(0);

    }
}
