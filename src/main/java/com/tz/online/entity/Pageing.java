package com.tz.online.entity;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:22.
 * Project: BookStore01.
 */
public class Pageing {
    private List<Book> books; // 要分页显示的单页图书
    private List<Address> as; // 地址集合
    private List<Order> orders; // 订单集合
    private int pageNow; // 当前页
    private int pageSize; // 每页显示多少数据
    private int pageCount; // 总共有多少页
    private long rowCount; // 总共有多少条数据

    public Pageing() {
    }

    public Pageing(int pageNow, int pageSize, int pageCount, long rowCount) {
        this.pageNow = pageNow;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.rowCount = rowCount;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public List<Address> getAs() {
        return as;
    }

    public void setAs(List<Address> as) {
        this.as = as;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Pageing{" +
                "books=" + books +
                ", pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", rowCount=" + rowCount +
                ", as=" + as +
                ", orders=" + orders +
                '}';
    }
}
