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
 * Date: 2016/12/22 16:58.
 * Project: BookStore01.
 */
@WebServlet(
        name = "indexAction",
        urlPatterns = {"/book/IndexAction"}
)
public class IndexAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IBookService bookService = (IBookService) ac.getBean("bookServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询出两本精选图书，三本新书，三本推荐图书
        Pageing bestBook = bookService.queryBookByCondition("1", "2", "1000003");
        Pageing newBook = bookService.queryBookByCondition("1", "3", "1000002");
        Pageing tuijianBook = bookService.queryBookByCondition("1", "3", "1000001");

        req.setAttribute("bestBook", bestBook);
        req.setAttribute("newBook", newBook);
        req.getSession().setAttribute("tuijianBook", tuijianBook);

        req.getRequestDispatcher("/WEB-INF/jsp/book/index.jsp").forward(req, resp);
    }
}
