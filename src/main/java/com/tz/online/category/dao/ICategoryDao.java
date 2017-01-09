package com.tz.online.category.dao;

import com.tz.online.entity.Book;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 16:26.
 * Project: BookStore01.
 */
public interface ICategoryDao {
    List<Book> selectBooksForPage(int now, int size);

    long getRowCount();
}
