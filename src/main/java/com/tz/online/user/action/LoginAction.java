package com.tz.online.user.action;

import com.tz.online.entity.User;
import com.tz.online.user.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 15:21.
 * Project: BookStore01.
 */
@WebServlet(
        name = "loginAction",
        urlPatterns = {"/user/login"}
)
public class LoginAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IUserService userService = (IUserService) ac.getBean("userServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getContextPath();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ((username != null && username.trim().length() > 0) && (password != null && password.trim().length() > 0)) {
            Cookie cookie;
            User user = userService.loginUserByNameAndPwd(username, password);
            if (user != null) {
                String terms = req.getParameter("terms");
                if (terms != null) {
                    //说明要七天免登陆
                    cookie = new Cookie("userInfo", URLEncoder.encode(username + ":" + password, "UTF-8"));
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    //设置Cookie作用域
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }
                req.getSession().setAttribute("userInfo", user);
                resp.sendRedirect(base + "/book/IndexAction");
            } else {
                req.setAttribute("info", "用户名或密码错误");
                req.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("info", "用户名或密码错误");
            req.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
        }
    }
}
