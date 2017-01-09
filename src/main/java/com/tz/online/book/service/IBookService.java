package com.tz.online.book.service;

import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:31.
 * Project: BookStore01.
 */
public interface IBookService {
    /**
     * 根据条件查询，并进行分页
     *
     * @param now    当前页
     * @param size   每页显示多少行
     * @param cateId 商品类别ID
     * @return Pageing对象
     */
    Pageing queryBookByCondition(String now, String size, String cateId);

    /**
     * 根据商品ID查询商品
     *
     * @param bookId 要查询的商品ID
     * @return Book对象
     */
    Book queryBookById(String bookId);
}
