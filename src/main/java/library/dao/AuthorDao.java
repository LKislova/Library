package library.dao;

import library.entity.AuthorObject;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository
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
//            new AuthorDao().begin();
            String hql = "FROM AuthorObject ";//!!!!!
            List<AuthorObject> authorObjects = getSession().createQuery(hql).list();
            return authorObjects;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }

    public AuthorObject updateAuthor(AuthorObject authorObject) throws Exception {
        Session session = null;
        try {
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

            String select ="FROM AuthorObject WHERE id =:authorId";
            Query query = getSession().createQuery(select);
            query.setParameter("authorId", id);
                return (AuthorObject) query.list().get(0);
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get author list", e);
        }
    }


}
