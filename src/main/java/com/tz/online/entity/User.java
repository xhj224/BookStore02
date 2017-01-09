package com.tz.online.entity;

import javax.persistence.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:20.
 * Project: BookStore01.
 */
@Entity
@Table(name = "ONLINE_USER")
public class User {
    private Long userId; // ID标识
    private String username; // 用户名
    private String password; // 密码
    private String tel; // 手机号
    private String email; // 邮箱
    private String address; // 用户的地址
    private String comparate; // 用户所在单位

    public User() {
    }

    public User(String username, String password, String tel, String email, String address, String comparate) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.comparate = comparate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id")
    @SequenceGenerator(name = "user_id", sequenceName = "online_user_id", initialValue = 0, allocationSize = 1)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(length = 30, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 20, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 200, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(length = 100, nullable = false)
    public String getComparate() {
        return comparate;
    }

    public void setComparate(String comparate) {
        this.comparate = comparate;
    }

    @Column(length = 150, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 12, nullable = false)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", comparate='" + comparate + '\'' +
                '}';
    }
}
