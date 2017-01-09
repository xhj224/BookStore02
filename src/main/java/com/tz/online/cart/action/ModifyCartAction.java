package com.tz.online.cart.action;

import com.tz.online.entity.Cart;

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
 * Date: 2016/12/24 22:32.
 * Project: BookStore01.
 */
@WebServlet(
        name = "modifyCart",
        urlPatterns = {"/cart/modifyCart"}
)
public class ModifyCartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String bookId = req.getParameter("bookId");
            String count = req.getParameter("count");
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.modifyCart(bookId, count);
            req.getSession().setAttribute("cart", cart);
            out.print("1");
        } catch (Exception e) {
            out.print("0");
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
