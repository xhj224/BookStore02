package com.tz.online.order.dao;

import com.tz.online.entity.Address;
import com.tz.online.entity.Order;
import com.tz.online.entity.OrderItem;
import com.tz.online.entity.User;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:33.
 * Project: BookStore01.
 */
public interface IOrderDao {
    /**
     * 保存地址
     *
     * @param a 要保存的地址对象
     * @return 成功返回true，失败返回false
     */
    boolean insertAddress(Address a);

    /**
     * 保存订单
     *
     * @param o 要保存的订单对象
     * @return 成功返回true，失败返回false
     */
    boolean insertOrder(Order o);

    /**
     * 分页查询地址
     *
     * @param user 用户对象
     * @param now  当前页码
     * @param size 每页显示多少内容
     * @return 地址集合
     */
    List<Address> selectAddressByPage(User user, int now, int size);

    /**
     * 分页查询订单
     *
     * @param user 用户对象
     * @param now  当前页码
     * @param size 每页显示多少内容
     * @return 订单集合
     */
    List<Order> selectOrderByPage(User user, int now, int size);

    /**
     * 获得当前用户的地址数量
     *
     * @param user 用户对象
     * @return 地址数量
     */
    long getRowCountForAddress(User user);

    /**
     * 获得当前用户的订单数量
     *
     * @param user 用户对象
     * @return 订单数量
     */
    long getRowCountForOrder(User user);

    /**
     * 根据地址ID查询对应的地址
     *
     * @param id 要查询的地址
     * @return 地址对象
     */
    Address selectAddressById(Long id);

    /**
     * 根据orderNum查找对应的订单
     *
     * @param orderNum 订单号
     * @return Order对象
     */
    Order selectOrderByOrderNum(String orderNum);

    boolean insertItem(OrderItem item);
}
