package com.example.myapplication;

/**
 * Created by 805138185 on 2019/6/10.
 */

public class User {
    private Integer id;
    private Integer user_type_id;
    private String account;
    private String password;
    private String username;
    private String sex;
    private String phone;
    private String address;
    private String head_image;



    @Override
    public String toString() {
        return "User [id=" + id + ", user_type_id=" + user_type_id + ", account=" + account + ", password="
                + password + ", username=" + username + ", sex=" + sex + ", phone=" + phone + ", address=" + address
                + ", head_image=" + head_image + "]";
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUser_type_id() {
        return user_type_id;
    }
    public void setUser_type_id(Integer user_type_id) {
        this.user_type_id = user_type_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getHead_image() {
        return head_image;
    }
    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }


}
