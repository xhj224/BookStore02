package com.tz.online.user.service;

import com.tz.online.entity.User;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:36.
 * Project: BookStore01.
 */
public interface IUserService {
    /**
     * 验证用户是否合法
     *
     * @param name 要验证的用户名
     * @return 用户对象
     */
    User loginUser(String name);

    /**
     * 完成用户的注册功能
     *
     * @param user 要注册的用户对象
     * @return 成功返回true，失败返回false
     */
    boolean registerUser(User user);

    /**
     * 验证用户是否登录成功
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户对象
     */
    User loginUserByNameAndPwd(String name, String password);
}
