package com.tz.online.user.dao;

import com.tz.online.entity.User;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:33.
 * Project: BookStore01.
 */
public interface IUserDao {
    /**
     * 根据用户名查询用户
     *
     * @param name 要查询的用户名
     * @return 用户对象
     */
    User selectUserByName(String name);

    /**
     * 保存用户对象到数据库
     *
     * @param user 要保存的用户对象
     * @return 成功返回true，失败返回false
     */
    boolean insertUser(User user);

    /**
     * 通过用户名和密码查找对应的用户
     *
     * @param name     用户名
     * @param password 密码
     * @return User对象
     */
    User selectUserByNameAndPassword(String name, String password);
}
