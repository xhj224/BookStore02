package com.tz.online.order.dao.impl;

import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.order.dao.IOrderDao;
import com.tz.online.user.dao.IUserDao;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/25 15:12.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class OrderDaoImplTest {
    @Resource
    private IOrderDao orderDao;
    @Resource
    private IUserDao userDao;

    @Test
    public void insertAddress() throws Exception {
        Address address = new Address("江苏省苏州市", "烽火路80号", "210000", "王五", "15633334444");
        address.setIsDefault("1");
        User user = userDao.selectUserByName("王五");
        if (user != null) {
            address.setUser(user);
        }
        boolean bool = orderDao.insertAddress(address);
        System.out.println(bool);
    }

    @Test
    public void insertOrder() throws Exception {

    }

    @Test
    public void selectAddressByPage() throws Exception {

    }

    @Test
    public void selectOrderByPage() throws Exception {

    }

    @Test
    public void getRowCountForAddress() throws Exception {

    }

    @Test
    public void getRowCountForOrder() throws Exception {

    }

    @Test
    public void selectAddressById() throws Exception {
        Address address = orderDao.selectAddressById(8L);
        System.out.println(address);
    }

}