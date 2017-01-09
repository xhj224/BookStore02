package com.tz.online.entity;

import javax.persistence.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_ITEM")
public class OrderItem {
    private Long itemId; // 订单明细ID
    private Book book; // 引用图书外键
    private int count; // 购买数量
    private double allPrice; // 订单总价格
    private Order order; // 引用订单外键

    public OrderItem() {
    }

    public OrderItem(Book book, int count, double allPrice) {
        this.book = book;
        this.count = count;
        this.allPrice = allPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orderItem_id")
    @SequenceGenerator(name = "orderItem_id", sequenceName = "online_OrderItem_id")
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Column(length = 3, nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Column(columnDefinition = "number(8,2) check(allPrice > 0.0)", nullable = false)
    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", book=" + book +
                ", count=" + count +
                ", allPrice=" + allPrice +
                ", order=" + order +
                '}';
    }
}
