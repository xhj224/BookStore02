package com.tz.online.cart.action;

import com.tz.online.book.service.IBookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Cart;
import com.tz.online.entity.OrderItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 19:52.
 * Project: BookStore01.
 */
@WebServlet(
        name = "addCart",
        urlPatterns = {"/cart/addCart"}
)
public class AddCartAction extends HttpServlet {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private IBookService bookService = (IBookService) ac.getBean("bookServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String bookId = req.getParameter("bookId");
            Book book = bookService.queryBookById(bookId);
            OrderItem item = new OrderItem(book, 1, book.getPrice());
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            cart.addCart(item);
            req.getSession().setAttribute("cart", cart);
            out.print("1:" + cart.getAllcount() + ":" + cart.getAllPrice());
        } catch (Exception e) {
            out.print("0");
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
