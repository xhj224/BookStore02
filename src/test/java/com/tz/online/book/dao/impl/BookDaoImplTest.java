package com.tz.online.book.dao.impl;

import com.tz.online.book.dao.IBookDao;
import com.tz.online.entity.Book;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/23 16:54.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class BookDaoImplTest {
    @Resource
    private IBookDao bookDao;

    @Test
    public void selectBookById() throws Exception {
        Book book = bookDao.selectBookById(1L);
        if (book != null) {
            System.out.println(book);
        }
    }

    @Test
    public void selectBookByCondition() throws Exception {
        List<Book> bookList = bookDao.selectBookByCondition(2, 2, 1000001L);
        if (bookList != null) {
            bookList.forEach(System.out::println);
        }
    }

    @Test
    public void getRowCount() throws Exception {
        long count = bookDao.getRowCount(1000001L);
        System.out.println(count);
    }
}