package com.tz.online.user.dao.impl;

import com.tz.online.entity.User;
import com.tz.online.user.dao.IUserDao;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 13:46.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserDaoImplTest {
    @Resource
    private IUserDao userDao;

    @Test
    public void selectUserByName() throws Exception {
        User user = userDao.selectUserByName("jack");
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User("张三", "123123", "13344445555", "123123@qq.com", "江苏苏州", "天智");
        boolean bool = userDao.insertUser(user);
        System.out.println(bool);
    }

    @Test
    public void selectUserByNameAndPassword() throws Exception {
        User user = userDao.selectUserByNameAndPassword("张三", "123123");
        System.out.println(user);
    }

}