package com.tz.online.category.service.impl;

import com.tz.online.category.dao.ICategoryDao;
import com.tz.online.category.service.ICategoryService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 19:52.
 * Project: BookStore01.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private ICategoryDao categoryDao;

    @Override
    public Pageing findBooksByPage(String now, String pageSize) {
        if ((now != null && now.trim().length() != 0) && (pageSize != null && pageSize.trim().length() != 0)) {
            List<Book> bookList = categoryDao.selectBooksForPage(Integer.parseInt(now), Integer.parseInt(pageSize));
            long rowCount = categoryDao.getRowCount();
            int pageCount = (int) (rowCount / Integer.parseInt(pageSize));
            if (rowCount % Integer.parseInt(pageSize) != 0) {
                pageCount += 1;
            }
            Pageing pageing = new Pageing(Integer.parseInt(now), Integer.parseInt(pageSize), pageCount, rowCount);
            pageing.setBooks(bookList);
            return pageing;
        } else {
            return null;
        }
    }
}
