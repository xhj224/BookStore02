package com.tz.online.book.service.impl;

import com.tz.online.book.dao.IBookDao;
import com.tz.online.book.service.IBookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:31.
 * Project: BookStore01.
 */
@Service
public class BookServiceImpl implements IBookService {
    @Resource
    private IBookDao bookDao;

    @Override
    public Pageing queryBookByCondition(String now, String size, String cateId) {
        if ((now != null && now.trim().length() > 0) && (size != null && size.trim().length() > 0) && (cateId != null && cateId.trim().length() > 0)) {
            List<Book> bookList = bookDao.selectBookByCondition(Integer.parseInt(now), Integer.parseInt(size), Long.parseLong(cateId));
            long rowCount = bookDao.getRowCount(Long.parseLong(cateId));
            int pageCount = (int) (rowCount / Integer.parseInt(size));
            if (rowCount % Integer.parseInt(size) != 0) {
                pageCount += 1;
            }
            Pageing pageing = new Pageing(Integer.parseInt(now), Integer.parseInt(size), pageCount, rowCount);
            pageing.setBooks(bookList);
            return pageing;
        } else {
            return null;
        }
    }

    @Override
    public Book queryBookById(String bookId) {
        if (bookId != null && bookId.trim().length() > 0) {
            return bookDao.selectBookById(Long.parseLong(bookId));
        } else {
            return null;
        }
    }
}
