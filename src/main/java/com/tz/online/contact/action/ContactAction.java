package com.tz.online.contact.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 21:40.
 * Project: BookStore01.
 */
@WebServlet(
        name = "contactAction",
        urlPatterns = {"/contact/contactAction"}
)
public class ContactAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/other/contact.jsp").forward(req, resp);
    }
}
