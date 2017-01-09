package com.tz.online.category.service;

import com.tz.online.entity.Pageing;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 19:50.
 * Project: BookStore01.
 */
public interface ICategoryService {
    Pageing findBooksByPage(String now,String pageSize);
}
