package library.dao;

import library.dao.interf.AuthorDao;
import library.entity.AuthorObject;
import library.entity.BookObject;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by trainee on 11.12.14.
 */
@Repository

public class AuthorDaoImpl extends BaseDaoImpl<AuthorObject> implements AuthorDao {
    public AuthorDaoImpl() {
        super(AuthorObject.class);
    }

    public List<BookObject> listNotAuthorBook(Integer id) throws Exception {

        String hql = "FROM BookObject WHERE author_id != :authorId or author_id is NULL";//!!!!!
        Query query = getSession().createQuery(hql);
        query.setParameter("authorId", id);
        List<BookObject> notAuthorBooks = query.list();
        return notAuthorBooks;
    }
}


