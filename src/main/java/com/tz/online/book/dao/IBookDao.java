package com.tz.online.book.dao;

import com.tz.online.entity.Book;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:29.
 * Project: BookStore01.
 */
public interface IBookDao {
    /**
     * 根据商品类别，分页查询商品
     *
     * @param now  当前页
     * @param size 每页显示多少页
     * @param cateId 类别ID
     * @return Pageing对象
     */
    List<Book> selectBookByCondition(int now, int size, Long cateId);

    /**
     * 根据ID查找对应的图书
     *
     * @param id 要查找的图书的ID
     * @return Book对象
     */
    Book selectBookById(Long id);

    /**
     * 根据类型查询出此图书的数量，用于封装pageing对象
     *
     * @param cateId 商品种类的ID
     * @return 该商品一共的数量
     */
    long getRowCount(Long cateId);
}
