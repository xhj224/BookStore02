package com.tz.online.order.dao.impl;

import com.tz.online.entity.Address;
import com.tz.online.entity.Order;
import com.tz.online.entity.OrderItem;
import com.tz.online.entity.User;
import com.tz.online.order.dao.IOrderDao;
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
 * Date: 2016/12/22 16:34.
 * Project: BookStore01.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderDaoImpl implements IOrderDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean insertAddress(Address a) {
        try {
            if (a != null) {
                getSession().save(a);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertOrder(Order o) {
        try {
            if (o != null) {
                getSession().save(o);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> selectAddressByPage(User user, int now, int size) {
        String hql = "from Address where user=:user and isDefault='0'";
        return getSession().createQuery(hql).setParameter("user", user).setFirstResult((now - 1) * size).setMaxResults(size).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> selectOrderByPage(User user, int now, int size) {
        String hql = "from Order where user=:user order by createDate desc ";
        return getSession().createQuery(hql).setParameter("user", user).setFirstResult((now - 1) * size).setMaxResults(size).list();
    }

    @Override
    public long getRowCountForAddress(User user) {
        String hql = "select count(*) from Address where user=:user";
        return (long) getSession().createQuery(hql).setParameter("user", user).uniqueResult();
    }

    @Override
    public long getRowCountForOrder(User user) {
        String hql = "select count(*) from Order where user=:user";
        return (long) getSession().createQuery(hql).setParameter("user", user).uniqueResult();
    }

    @Override
    public Address selectAddressById(Long id) {
        return (Address) getSession().get(Address.class, id);
    }

    @Override
    public Order selectOrderByOrderNum(String orderNum) {
        String hql = "from Order where orderNum=:orderNum";
        return (Order) getSession().createQuery(hql).setParameter("orderNum", orderNum).uniqueResult();
    }

    @Override
    public boolean insertItem(OrderItem item) {
        try {
            getSession().save(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
