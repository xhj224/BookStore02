package com.tz.online.entity;

import javax.persistence.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_CATEGORY")
public class Category {
    private Long cateId; // 图书类型ID标识
    private String cateName; // 类型名称

    public Category() {
    }

    public Category(String cateName) {
        this.cateName = cateName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "category_id")
    @SequenceGenerator(name = "category_id", sequenceName = "online_category_id", initialValue = 0, allocationSize = 1)
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    @Column(length = 100, nullable = false, unique = true)
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}