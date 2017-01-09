package com.tz.online.user.action;

import com.tz.online.entity.User;
import com.tz.online.user.service.IUserService;
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
 * Date: 2016/12/24 13:09.
 * Project: BookStore01.
 */
@WebServlet(
        name = "register",
        urlPatterns = {"/user/register"}
)
public class RegisterAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IUserService userService = (IUserService) ac.getBean("userServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/user/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getContextPath();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String comparate = req.getParameter("comparate");
        String address = req.getParameter("address");
        if ((username != null && username.trim().length() > 0) && (password != null && password.trim().length() > 0) &&
                (email != null && email.trim().length() > 0) && (tel != null && tel.trim().length() > 0) &&
                (comparate != null && comparate.trim().length() > 0) && (address != null && address.trim().length() > 0)) {

            User user = new User(username, password, tel, email, address, comparate);
            boolean bool = userService.registerUser(user);
            if (bool) {
                resp.sendRedirect(base + "/user/login");
            } else {
                resp.sendRedirect(base + "/error.html");
            }
        } else {
            resp.sendRedirect(base + "/error.html");
        }
    }
}
