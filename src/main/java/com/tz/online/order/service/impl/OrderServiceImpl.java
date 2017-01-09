package com.tz.online.order.service.impl;

import com.tz.online.entity.*;
import com.tz.online.order.dao.IOrderDao;
import com.tz.online.order.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:37.
 * Project: BookStore01.
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderDao orderDao;

    @Override
    public boolean saveAddress(Address address) {
        return orderDao.insertAddress(address);
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public Pageing queryAllAddressByUser(User user, String now, String size) {
        if ((user != null) && (now != null && now.length() > 0) && (size != null && size.length() > 0)) {
            List<Address> addressList = orderDao.selectAddressByPage(user, Integer.parseInt(now), Integer.parseInt(size));
            long rowCount = orderDao.getRowCountForAddress(user);
            int pageCount = (int) (rowCount / Integer.parseInt(size));
            if (rowCount % Integer.parseInt(size) != 0) {
                pageCount += 1;
            }
            Pageing pageing = new Pageing(Integer.parseInt(now), Integer.parseInt(size), pageCount, rowCount);
            pageing.setAs(addressList);
            return pageing;
        } else {
            return null;
        }
    }

    @Override
    public Pageing queryAllOrderByUser(User user, String now, String size) {
        if ((user != null) && (now != null && now.length() > 0) && (size != null && size.length() > 0)) {
            List<Order> orderList = orderDao.selectOrderByPage(user, Integer.parseInt(now), Integer.parseInt(size));
            long rowCount = orderDao.getRowCountForOrder(user);
            int pageCount = (int) (rowCount / Integer.parseInt(size));
            if (rowCount % Integer.parseInt(size) != 0) {
                pageCount += 1;
            }
            Pageing pageing = new Pageing(Integer.parseInt(now), Integer.parseInt(size), pageCount, rowCount);
            pageing.setOrders(orderList);
            return pageing;
        } else {
            return null;
        }
    }

    @Override
    public Address findAddressById(String id) {
        if (id != null && id.trim().length() > 0) {
            return orderDao.selectAddressById(Long.parseLong(id));
        } else {
            return null;
        }
    }

    @Override
    public Order findOrderByOrderNum(String orderNum) {
        return orderDao.selectOrderByOrderNum(orderNum);
    }

    @Override
    public boolean saveOrderItem(OrderItem orderItem) {
        return orderDao.insertItem(orderItem);
    }
}

