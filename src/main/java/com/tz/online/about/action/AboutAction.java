package com.tz.online.about.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 21:37.
 * Project: BookStore01.
 */
@WebServlet(
        name = "aboutAction",
        urlPatterns = {"/about/aboutAction"}
)
public class AboutAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/other/about.jsp").forward(req, resp);
    }
}
