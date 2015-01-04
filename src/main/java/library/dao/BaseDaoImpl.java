package library.dao;


import library.dao.interf.BaseDao;
import library.entity.BaseObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by trainee on 11.12.14.
 */
@Repository
public abstract class BaseDaoImpl<T extends BaseObject  > implements BaseDao<T> {
    private Class<T> type;

    public BaseDaoImpl(Class<T> type) {
        this.type = type;
    }

    protected BaseDaoImpl() {
    }

    @Autowired
    protected SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(T entity) {
        getSession().save(entity);
            }

    @Override
    public List<T> getList() {
       List<T> list = getSession().createQuery("FROM "+ this.type.getSimpleName()).list();
        return list;
    }

    @Override
    public void update(T entity)  {
        getSession().update(entity);
           }

    @Override
    public T findById(Integer id)  {
        return (T) getSession().get(type,id);
    }


}


