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
 * Date: 2016/12/25 11:16.
 * Project: BookStore01.
 */
@WebServlet(
        name = "removeCart",
        urlPatterns = {"/cart/removeCart"}
)
public class RemoveCartAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String ids = req.getParameter("ids");
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.removeCart(ids);
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
