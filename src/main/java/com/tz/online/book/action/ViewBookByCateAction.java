package com.tz.online.book.action;

import com.tz.online.book.service.IBookService;
import com.tz.online.entity.Pageing;
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
 * Date: 2016/12/22 16:59.
 * Project: BookStore01.
 */
@WebServlet(
        name = "viewBookByCate",
        urlPatterns = {"/book/viewBookByCate"}
)
public class ViewBookByCateAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IBookService bookService = (IBookService) ac.getBean("bookServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收图书类型
        String cateId = req.getParameter("cateId");

        // 接收分页条件
        String pageNow = req.getParameter("pageNow");
        String pageSize = req.getParameter("pageSize");

        // 如果没有接收到，给予默认
        if (pageNow == null || pageNow.trim().length() == 0) {
            pageNow = "1";
        }
        if (pageSize == null || pageSize.trim().length() == 0) {
            pageSize = "4";
        }
        if (cateId == null || cateId.trim().length() == 0) {
            cateId = "1000000";
        }

        Pageing pageing = bookService.queryBookByCondition(pageNow, pageSize, cateId);
        req.setAttribute("pageing", pageing);
        req.getRequestDispatcher("/WEB-INF/jsp/book/specials.jsp").forward(req, resp);
    }
}
