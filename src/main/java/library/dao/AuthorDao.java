package library.dao;

import library.entity.AuthorObject;
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
public class AuthorDao extends DAO {

    public AuthorObject createAuthor(AuthorObject authorObject)
            throws Exception {
        try {

            begin();
            getSession().save(authorObject);
            commit();
            return authorObject;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create author ", e);
        }
    }

    public List<AuthorObject> listAuthor() throws Exception {
        try {
//            Session session = null;
            begin();
            String hql = "FROM AuthorObject ";//!!!!!
            List<AuthorObject> authorObjects = getSession().createQuery(hql).list();
            commit();
            return authorObjects;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }

    ///
    public AuthorObject updateAuthor(AuthorObject authorObject) throws Exception {

        try {
//            Session session = null;
            begin();
            getSession().update(authorObject);
            commit();
            return authorObject;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create author ", e);
        }
    }

    public AuthorObject getAuthorParameters(Integer id) throws Exception {
        try {
//            Session session = null;
            begin();
            String select = "FROM AuthorObject WHERE id =:authorId";
            Query query = getSession().createQuery(select);
            query.setParameter("authorId", id);
            commit();
            return (AuthorObject) query.list().get(0);
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }

    public List<BookObject> listNotAuthorBook(Integer id) throws Exception {
        try {
//            Session session = null;
//            new AuthorDao().begin();
            begin();
            String hql = "FROM BookObject WHERE author_id != :authorId or author_id is NULL";//!!!!!
            Query query = getSession().createQuery(hql);
            query.setParameter("authorId", id);
            List<BookObject> notAuthorBooks = query.list();
            commit();
            return notAuthorBooks;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get book list", e);
        }
    }


}
