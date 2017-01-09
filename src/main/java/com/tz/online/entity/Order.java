package com.tz.online.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_ORDER")
public class Order {
    private Long orderId; // 订单ID标识
    private String orderNum; // 订单标号
    private Date createDate; // 下单日期
    private Set<OrderItem> items; // 订单中的商品明细
    private User user; // 订单所属的用户
    private Address address; // 订单的发货地址
    private String orderStatus; // 订单状态 0：未付款 1：已付款

    public Order() {
    }

    public Order(String orderNum, Date createDate, Set<OrderItem> items, User user, Address address, String orderStatus) {
        this.orderNum = orderNum;
        this.createDate = createDate;
        this.items = items;
        this.user = user;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id")
    @SequenceGenerator(name = "order_id", sequenceName = "online_order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(length = 30, nullable = false)
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @OneToMany(mappedBy = "order")
    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        for (OrderItem oi : items) {
            oi.setOrder(this);
        }
        this.items = items;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(length = 2, nullable = false)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", createDate=" + createDate +
                ", items=" + items +
                ", user=" + user +
                ", address=" + address +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
