package library.service;

import library.dao.AuthorDaoImpl;

import library.entity.AuthorObject;
import library.entity.BookObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.BookDaoImpl;

import java.util.List;

/**
 * Created by Любовь on 11.12.2014.
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private AuthorDaoImpl authorDao;

    @Transactional(readOnly = true)
    public BookObject getBookParameters(Integer id) {
        try {
            return bookDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public List<BookObject> getAllBook() {
        try {
            return bookDao.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = false)
    public void createBook(String name, String style, Integer publishDay) throws Exception {
        BookObject bookObject = new BookObject(name, style, publishDay);
        bookDao.create(bookObject);
    }

    @Transactional(readOnly = false)
    public void updateBook(Integer id, String name, String style, Integer publishDay) throws Exception {
       BookObject bookObject = bookDao.findById(id);
        bookObject.setName(name);
        bookObject.setPublishDate(publishDay);
        bookObject.setStyle(style);
        bookDao.update(bookObject);
    }
    @Transactional(readOnly = false)
    public void deleteAuthorBook(Integer id, Integer idBook) throws Exception {

        BookObject bookObject = bookDao.findById(idBook);
        bookObject.setBooksAuthor(null);
        bookDao.update(bookObject);

    }
    @Transactional(readOnly = false)
    public void addAuthorBook(Integer id, Integer idBook) throws Exception {
        AuthorObject authorObject = authorDao.findById(id);
        BookObject bookObject = bookDao.findById(idBook);
        bookObject.setBooksAuthor(authorObject);
        bookDao.update(bookObject);


    }
}

