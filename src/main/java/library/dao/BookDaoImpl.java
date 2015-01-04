package library.dao;

import library.dao.interf.BookDao;
import library.entity.BookObject;

import org.springframework.stereotype.Repository;

/**
 * Created by trainee on 11.12.14.
 */
@Repository

public class BookDaoImpl extends BaseDaoImpl<BookObject> implements BookDao {

    public BookDaoImpl() {
        super(BookObject.class);
    }


}

