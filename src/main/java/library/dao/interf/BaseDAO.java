package library.dao.interf;

import library.entity.BaseObject;

import java.util.List;


/**
 * Created by trainee on 29.12.14.
 */
public interface BaseDao<T extends BaseObject> {

    void create(T entity);
    List<T> getList();
    T findById(Integer id);
    void update(T entity);
}
