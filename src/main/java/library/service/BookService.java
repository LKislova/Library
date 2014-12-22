package library.service;

import library.dao.AuthorDao;

import library.entity.BookObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.BookDao;

import java.util.List;

/**
 * Created by Любовь on 11.12.2014.
 */
@Service
@Transactional
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;


    public BookObject getBookParameters(Integer id) {
        try {

            return bookDao.getBookParameters(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BookObject> getAllBook() {
        try {
            return bookDao.listBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


//    public void createBook(String name, String style, Integer publishDay) throws Exception {
//        BookObject bookObject = new BookObject(name, style, publishDay);
//        bookDao.createBook(bookObject);
//    }


    public void updateBook(Integer id, String name, String style, Integer publishDay) throws Exception {
        BookObject bookObject = new BookObject(id, name, style, publishDay);
        bookDao.updateBook(bookObject);
    }
}

