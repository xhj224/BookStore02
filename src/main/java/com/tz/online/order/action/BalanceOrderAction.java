package com.tz.online.order.action;

import com.tz.online.address.service.IAddressService;
import com.tz.online.entity.*;
import com.tz.online.order.service.IOrderService;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/25 16:31.
 * Project: BookStore01.
 */
@WebServlet(
        name = "balanceOrder",
        urlPatterns = {"/order/balance"}
)
public class BalanceOrderAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IOrderService orderService = (IOrderService) ac.getBean("orderServiceImpl");
    private ISSXJLDao ssxjlDao = (ISSXJLDao) ac.getBean("SSXJLDaoImpl");
    private IAddressService addressService = (IAddressService) ac.getBean("addressServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("userInfo");
        Address address = addressService.findDefaultAddressByUser(user);
        // 1.根据用户查询出三个地址
        // 接收分页条件
        String pageNow = req.getParameter("pageNow");
        // String pageSize = req.getParameter("pageSize");
        String pageSize;
        // 如果没有接收到，给予默认
        pageNow = pageNow == null ? "1" : pageNow;
        // pageSize = pageSize == null ? "3" : pageSize;
        if (address == null) {
            pageSize = "4";
        } else {
            pageSize = "3";
        }
        Pageing addressPageing = orderService.queryAllAddressByUser(user, pageNow, pageSize);
        // 获得用户的默认地址
        // 2.接收提交过来的商品ID
        String ids = req.getParameter("ids");
        if (ids == null || ids.trim().length() == 0) {
            ids = (String) req.getSession().getAttribute("ids");
        }
        // 3.通过和购物车中的商品比较，得到要提交的商品明细
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Cart settlementCart = cart.settlementCart(ids);
        // 4.从购物车中删除要提交的商品明细
        // cart.removeCart(ids);
        List<Province> provinceList = ssxjlDao.selectAllProvinces();
        // 5.把购物车放到session中，地址分页对象和要提交的商品明细放到request中，转发到订单提交确认界面
        req.getSession().setAttribute("cart", cart); // 原先的购物车
        req.getSession().setAttribute("ids", ids); //　选中的商品的id字符串
        req.getSession().setAttribute("settlementCart", settlementCart); // 新的购物车
        req.setAttribute("defaultAddress", address); // 默认地址
        req.setAttribute("addressPageing", addressPageing); //　分页查找的非默认地址
        req.setAttribute("provinceList", provinceList); // 用于省市县级联的所有省份

        req.getRequestDispatcher("/WEB-INF/jsp/order/confirm_order.jsp").forward(req, resp);
    }
}
