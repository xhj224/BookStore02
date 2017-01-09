package com.tz.online.book.dao.impl;

import com.tz.online.book.dao.IBookDao;
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
 * Date: 2016/12/22 16:30.
 * Project: BookStore01.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class BookDaoImpl implements IBookDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectBookByCondition(int now, int size, Long cateId) {
        String hql = "from Book where category.cateId=:cateId";
        return getSession().createQuery(hql).setParameter("cateId", cateId).setFirstResult((now - 1) * size).setMaxResults(size).list();
    }

    @Override
    public Book selectBookById(Long id) {
        return (Book) getSession().get(Book.class, id);
    }

    @Override
    public long getRowCount(Long cateId) {
        String hql = "select count(*) from Book b where b.category.cateId=:cateId";
        return (long) getSession().createQuery(hql).setParameter("cateId", cateId).uniqueResult();
    }
}
