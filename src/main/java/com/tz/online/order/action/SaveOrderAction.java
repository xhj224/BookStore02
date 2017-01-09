package com.tz.online.order.action;

import com.tz.online.entity.*;
import com.tz.online.order.service.IOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 19:35.
 * Project: BookStore01.
 */
@WebServlet(
        name = "saveOrder",
        urlPatterns = {"/order/saveOrder"}
)
public class SaveOrderAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IOrderService orderService = (IOrderService) ac.getBean("orderServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getContextPath();
        // 接收地址ID
        String addressId = req.getParameter("addressId");
        // 获得地址对象
        Address address = orderService.findAddressById(addressId);
        // 获得用户对象
        User user = address.getUser();
        // 获得原始购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获得要结算的购物车
        Cart settlementCart = (Cart) req.getSession().getAttribute("settlementCart");
        // 获得订单明细集合
        Set<OrderItem> items = settlementCart.getItems();
        // 生成订单号
        String orderNum = String.valueOf(new Date().getTime());
        // 创建Order对象
        Order order = new Order(orderNum, new Date(), items, user, address, "0");
        // 将order对象存入数据库
        orderService.saveOrder(order);
        // 将订单对象与orderItem关联，并保存订单详情到数据库
        for (OrderItem item : items) {
            item.setOrder(order);
            orderService.saveOrderItem(item);
        }
        // 从原来的购物车中将已经结算的商品删除掉
        cart.removeCart((String) req.getSession().getAttribute("ids"));
        req.getSession().setAttribute("cart", cart);
        req.getSession().removeAttribute("ids");
        req.getSession().removeAttribute("settlementCart");
        resp.sendRedirect(base + "/order/orderList");
    }
}
