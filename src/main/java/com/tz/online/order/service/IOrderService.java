package com.tz.online.order.service;

import com.tz.online.entity.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:36.
 * Project: BookStore01.
 */
public interface IOrderService {
    /**
     * 保存地址信息
     *
     * @param address 要保存的地址信息
     * @return 成功返回true，失败返回false
     */
    boolean saveAddress(Address address);

    /**
     * 保存订单对象
     *
     * @param order 要保存的订单对象
     * @return 成功返回true，失败返回false
     */
    boolean saveOrder(Order order);

    /**
     * 查询地址
     *
     * @param user 用户
     * @param now  当前页
     * @param size 每页多少行
     * @return Pageing对象
     */
    Pageing queryAllAddressByUser(User user, String now, String size);

    /**
     * 查询订单
     *
     * @param user 用户
     * @param now  当前页
     * @param size 每页多少行
     * @return pageing对象
     */
    Pageing queryAllOrderByUser(User user, String now, String size);

    /**
     * 根据地址ID查询对应的地址
     *
     * @param id 要查询的地址
     * @return 地址对象
     */
    Address findAddressById(String id);

    Order findOrderByOrderNum(String orderNum);

    boolean saveOrderItem(OrderItem orderItem);
}
