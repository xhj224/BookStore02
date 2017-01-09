package com.tz.online.category.dao.impl;

import com.tz.online.category.dao.ICategoryDao;
import com.tz.online.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 19:47.
 * Project: BookStore01.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CategoryDaoImpl implements ICategoryDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectBooksForPage(int now, int size) {
        String hql = "from Book";
        return getSession().createQuery(hql).setFirstResult((now - 1) * size).setMaxResults(size).list();
    }

    @Override
    public long getRowCount() {
        String hql = "select count(*) from Book";
        return (long) getSession().createQuery(hql).uniqueResult();
    }
}
