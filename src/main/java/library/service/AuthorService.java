package library.service;

import library.entity.AuthorObject;
import library.entity.BookObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.AuthorDaoImpl;

import java.sql.Date;
import java.util.List;

/**
 * Created by Любовь on 11.12.2014.
 */
@Service

@Transactional
public class AuthorService {
    @Autowired
    public AuthorDaoImpl authorDao;
    @Transactional(readOnly = true)
    public AuthorObject getAuthorParameters(Integer id) {
        try {
            return authorDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public List<AuthorObject> getAllAuthor() {
        try {
            return authorDao.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = false)
    public void createAuthor(String name, Date birthday, String biography) throws Exception {
        AuthorObject authorObject = new AuthorObject(name, birthday, biography);
        authorDao.create(authorObject);
    }

    @Transactional(readOnly = false)
    public void updateAuthor(Integer id, String name, Date birthday, String biography) throws Exception {
        AuthorObject authorObject =authorDao.findById(id);
        authorObject.setBiography(biography);
        authorObject.setBirthday(birthday);
        authorObject.setName(name);
        authorDao.update(authorObject);
    }
    @Transactional(readOnly = true)
    public List<BookObject> getNotAuthorBooks(Integer id) {
        try {
            return authorDao.listNotAuthorBook(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


