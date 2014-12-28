package library.service;

import library.entity.AuthorObject;
import library.entity.BookObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.AuthorDao;

import java.sql.Date;
import java.util.List;

/**
 * Created by Любовь on 11.12.2014.
 */
@Service

@Transactional
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public AuthorObject getAuthorParameters(Integer id) {
        try {
            return authorDao.getAuthorParameters(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AuthorObject> getAllAuthor() {
        try {
            return authorDao.listAuthor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void createAuthor(String name, Date birthday, String biography) throws Exception {
        AuthorObject authorObject = new AuthorObject(name, birthday, biography);
        authorDao.createAuthor(authorObject);
    }


    public void updateAuthor(Integer id, String name, Date birthday, String biography) throws Exception {
        AuthorObject authorObject = new AuthorObject(id, name, birthday, biography);
        authorDao.updateAuthor(authorObject);
    }

    public List<BookObject> getNotAuthorBooks(Integer id) {
        try {
            return authorDao.listNotAuthorBook(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


