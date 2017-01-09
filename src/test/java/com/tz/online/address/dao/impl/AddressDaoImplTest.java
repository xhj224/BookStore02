package com.tz.online.address.dao.impl;

import com.tz.online.address.dao.IAddressDao;
import com.tz.online.entity.*;
import com.tz.online.user.dao.IUserDao;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 15:31.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class AddressDaoImplTest extends AbstractTestNGSpringContextTests {
    @Resource
    private IAddressDao addressDao;
    @Resource
    private IUserDao userDao;

    @Test
    public void selectProvinceById() throws Exception {
        Province province = addressDao.selectProvinceById("140000");
        System.out.println(province);
    }

    @Test
    public void selectCityById() throws Exception {
        City city = addressDao.selectCityById("130200");
        System.out.println(city);
    }

    @Test
    public void selectAreaById() throws Exception {
        Area area = addressDao.selectAreaById("230107");
        System.out.println(area);
    }

    @Test
    public void selectDefaultAddressByUser() throws Exception {
        User user = userDao.selectUserByName("smith");
        Address address = addressDao.selectDefaultAddressByUser(user);
        System.out.println(address);
    }
}