package com.tz.online.entity;

import javax.persistence.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_ADDRESS")
public class Address {
    private Long addressId; // 地址ID
    private String area; // 区域
    private String detailAddres; // 详细地址
    private String emailCode; // 邮编
    private String reciver; // 收件人
    private String tel; // 手机号
    private String isDefault; // 是否默认收货地址 0：否 1：是
    private User user; // 地址所属的用户

    public Address() {
    }

    public Address(String area, String detailAddres, String emailCode, String reciver, String tel) {
        this.area = area;
        this.detailAddres = detailAddres;
        this.emailCode = emailCode;
        this.reciver = reciver;
        this.tel = tel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "address_id")
    @SequenceGenerator(name = "address_id", sequenceName = "online_address_id")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Column(length = 100, nullable = false)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(length = 200, nullable = false)
    public String getDetailAddres() {
        return detailAddres;
    }

    public void setDetailAddres(String detailAddres) {
        this.detailAddres = detailAddres;
    }

    @Column(length = 6, nullable = false)
    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    @Column(length = 100, nullable = false)
    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    @Column(length = 12, nullable = false)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(length = 2, nullable = false)
    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", area='" + area + '\'' +
                ", detailAddres='" + detailAddres + '\'' +
                ", emailCode='" + emailCode + '\'' +
                ", reciver='" + reciver + '\'' +
                ", tel='" + tel + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", user=" + user +
                '}';
    }
}
