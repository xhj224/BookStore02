package com.tz.online.user.service.impl;

import com.tz.online.entity.User;
import com.tz.online.user.service.IUserService;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 14:08.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserServiceImplTest {
    @Resource
    private IUserService userService;

    @Test
    public void loginUser() throws Exception {
        User user = userService.loginUser("张三");
        if (user != null) {
            System.out.println(user);
        }
    }

    @Test
    public void registerUser() throws Exception {
        User user = new User("李四", "123123", "13344446666", "124123@qq.com", "江苏苏州", "天智");
        boolean bool = userService.registerUser(user);
        System.out.println(bool);
    }

    @Test
    public void loginUserByNameAndPwd() throws Exception {
        User user = userService.loginUserByNameAndPwd("李四", "123123");
        System.out.println(user);
    }
}