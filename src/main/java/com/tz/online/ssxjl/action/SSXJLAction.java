package com.tz.online.ssxjl.action;


import com.alibaba.fastjson.JSON;
import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/19 13:25.
 * Project: SSXJL.
 */
@WebServlet(
        name = "SSXJLAction",
        urlPatterns = {"/ssxjl"}
)
public class SSXJLAction extends HttpServlet {
    private static final String DEFAULT_ACTION = "findProvince";
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ISSXJLDao ssxjlDao = (ISSXJLDao) ac.getBean("SSXJLDaoImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.length() == 0) {
            action = DEFAULT_ACTION;
        }
        PrintWriter out = resp.getWriter();
        switch (action) {
            case "findProvince":
                List<Province> provinces = ssxjlDao.selectAllProvinces();
                req.setAttribute("provinces", provinces);
                req.getRequestDispatcher("ssxjl.jsp").forward(req, resp);
                break;
            case "findCity":
                String provinceCode = req.getParameter("provinceCode");
                List<City> cities = ssxjlDao.selectCityByProvinceCode(provinceCode);
                String jsonStr = JSON.toJSONString(cities);
                out.println(jsonStr);
                break;
            case "findArea":
                String cityCode = req.getParameter("cityCode");
                List<Area> areas = ssxjlDao.selectAreaByCityCode(cityCode);
                String jsonStr2 = JSON.toJSONString(areas);
                out.println(jsonStr2);
                break;
            case "findCode":
                String areaCode = req.getParameter("areaCode");
                // String
                break;
        }
        out.flush();
        out.close();
    }
}
