package com.tz.online.user.dao.impl;

import com.tz.online.entity.User;
import com.tz.online.user.dao.IUserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:34.
 * Project: BookStore01.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserDaoImpl implements IUserDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User selectUserByName(String name) {
        String hql = "from User where username=:name";
        return (User) getSession().createQuery(hql).setParameter("name", name).uniqueResult();
    }

    @Override
    public boolean insertUser(User user) {
        try {
            if (user != null) {
                getSession().save(user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User selectUserByNameAndPassword(String name, String password) {
        String hql = "from User where username=:name and password=:password";
        return (User) getSession().createQuery(hql).setParameter("name", name).setParameter("password", password).uniqueResult();
    }
}
