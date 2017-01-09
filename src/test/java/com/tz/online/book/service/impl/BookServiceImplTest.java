package com.tz.online.book.service.impl;

import com.tz.online.book.service.IBookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/23 19:58.
 * Project: BookStore01.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class BookServiceImplTest {
    @Resource
    private IBookService bookService;

    @Test
    public void queryBookByCondition() throws Exception {
        Pageing pageing = bookService.queryBookByCondition("1", "2", "1000003");
        if (pageing != null) {
            System.out.println(pageing);
        }
    }

    @Test
    public void queryBookById() throws Exception {
        Book book = bookService.queryBookById("1");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("无返回结果");
        }
    }
}