package library.dao;

import library.entity.AuthorObject;
import library.entity.BookObject;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository

public class AuthorDao extends DAO {

@Transactional(readOnly = false)
    public AuthorObject createAuthor(AuthorObject authorObject)
            throws Exception {
             getSession().save(authorObject);
              return authorObject;

    }
@Transactional(readOnly = true)
    public List<AuthorObject> listAuthor() throws Exception {

            String hql = "FROM AuthorObject ";//!!!!!
            List<AuthorObject> authorObjects = getSession().createQuery(hql).list();

            return authorObjects;

    }

    @Transactional(readOnly = false)
    public AuthorObject updateAuthor(AuthorObject authorObject) throws Exception {

            getSession().update(authorObject);

            return authorObject;

    }
    @Transactional(readOnly = true)
    public AuthorObject getAuthorParameters(Integer id) throws Exception {

//
            String select = "FROM AuthorObject WHERE id =:authorId";
            Query query = getSession().createQuery(select);
            query.setParameter("authorId", id);

            return (AuthorObject) query.list().get(0);

    }
    @Transactional(readOnly =true)
    public List<BookObject> listNotAuthorBook(Integer id) throws Exception {

            String hql = "FROM BookObject WHERE author_id != :authorId or author_id is NULL";//!!!!!
            Query query = getSession().createQuery(hql);
            query.setParameter("authorId", id);
            List<BookObject> notAuthorBooks = query.list();

            return notAuthorBooks;

    }


}
