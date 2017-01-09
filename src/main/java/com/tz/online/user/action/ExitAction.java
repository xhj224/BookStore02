package com.tz.online.user.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 16:37.
 * Project: BookStore01.
 */
@WebServlet(
        name = "exit",
        urlPatterns = {"/user/exit"}
)
public class ExitAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getContextPath();
        HttpSession session = req.getSession();
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        resp.sendRedirect(base + "/book/IndexAction");
    }
}
