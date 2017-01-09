package com.tz.online.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_BOOK")
public class Book {
    private Long bookId; // 商品ID
    private String bookName; // 商品名称
    private String author; // 作者
    private String publish; // 出版社
    private Date publishDate; // 出版日期
    private double price; // 单价
    private String introduce; // 图书简介
    private String imgUrl; // 图书的图片所在的地址
    private Category category; // 引用图书的类型

    public Book() {
    }

    public Book(String bookName, String author, String publish, Date publishDate, double price, String introduce, String imgUrl) {
        this.bookName = bookName;
        this.author = author;
        this.publish = publish;
        this.publishDate = publishDate;
        this.price = price;
        this.introduce = introduce;
        this.imgUrl = imgUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_id")
    @SequenceGenerator(name = "book_id", sequenceName = "online_book_id")
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Column(length = 100, nullable = false)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(length = 100, nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(length = 100, nullable = false)
    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Column(columnDefinition = "number(8,2) check(price > 0.0)", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(length = 500, nullable = false)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Column(nullable = false, length = 100)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @ManyToOne
    @JoinColumn(name = "CATE_ID")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", category=" + category +
                '}';
    }
}
