package com.tz.online.address.action;

import com.tz.online.address.service.IAddressService;
import com.tz.online.entity.Address;
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
 * Date: 2016/12/26 13:53.
 * Project: BookStore01.
 */
@WebServlet(
        name = "saveAddress",
        urlPatterns = {"/address/saveAddress"}
)
public class SaveAddressAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IOrderService orderService = (IOrderService) ac.getBean("orderServiceImpl");
    private IAddressService addressService = (IAddressService) ac.getBean("addressServiceImpl");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getContextPath();
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String addressDetail = req.getParameter("address_detail");
        String code = req.getParameter("code");
        String reciverName = req.getParameter("reciverName");
        String tel = req.getParameter("tel");
        if ((province != null && province.trim().length() > 0) && (city != null && city.trim().length() > 0) &&
                (area != null && area.trim().length() > 0) && (addressDetail != null && addressDetail.trim().length() > 0) &&
                (code != null && code.trim().length() > 0) && (reciverName != null && reciverName.trim().length() > 0) &&
                (tel != null && tel.trim().length() > 0)) {

            String newArea = addressService.findProvinceByCode(province).getProvinceName() + addressService.findCityByCode(city).getCityName() + addressService.findAreaByCode(area).getAreaName();

            Address address = new Address(newArea, addressDetail, code, reciverName, tel);
            String defaultAddress = req.getParameter("defaultAddress");
            User user = (User) req.getSession().getAttribute("userInfo");
            address.setUser(user);
            if (defaultAddress != null && defaultAddress.trim().length() > 0) {
                address.setIsDefault("1");
                addressService.clearDefaultAddressForUser(user);
            } else {
                address.setIsDefault("0");
            }
            boolean bool = orderService.saveAddress(address);
            if (bool) {
                resp.sendRedirect(base + "/order/balance");
            } else {
                resp.sendRedirect(base + "/error.html");
            }
        } else {
            resp.sendRedirect(base + "/error.html");
        }
    }
}
