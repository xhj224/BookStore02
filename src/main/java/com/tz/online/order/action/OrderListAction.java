package com.tz.online.order.action;

import com.tz.online.entity.Pageing;
import com.tz.online.entity.User;
import com.tz.online.order.service.IOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 22:39.
 * Project: BookStore01.
 */
@WebServlet(
        name = "orderList",
        urlPatterns = {"/order/orderList"}
)
public class OrderListAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IOrderService orderService = (IOrderService) ac.getBean("orderServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("userInfo");
        // 接收分页条件
        String pageNow = req.getParameter("pageNow");
        String pageSize = req.getParameter("pageSize");
        // 如果没有接收到，给予默认
        pageNow = pageNow == null ? "1" : pageNow;
        pageSize = pageSize == null ? "4" : pageSize;

        Pageing pageingOrder = orderService.queryAllOrderByUser(user, pageNow, pageSize);

        req.setAttribute("pageingOrder", pageingOrder);
        req.getRequestDispatcher("/WEB-INF/jsp/order/order_list.jsp").forward(req, resp);
    }
}
