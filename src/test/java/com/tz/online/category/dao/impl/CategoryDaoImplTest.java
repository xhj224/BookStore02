package com.tz.online.category.dao.impl;

import com.tz.online.category.dao.ICategoryDao;
import com.tz.online.entity.Book;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 20:14.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class CategoryDaoImplTest {
    @Resource
    private ICategoryDao categoryDao;

    @Test
    public void selectBooksForPage() throws Exception {
        List<Book> bookPageing = categoryDao.selectBooksForPage(1, 12);
        bookPageing.forEach(System.out::println);
    }
}