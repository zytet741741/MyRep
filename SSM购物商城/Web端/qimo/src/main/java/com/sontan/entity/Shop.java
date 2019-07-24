package com.sontan.entity;

public class Shop {
	private Integer id;
	private String good_name;
	private String good_content;
	private String good_image;
	private String good_price;
	private String user_account;
	private Integer number;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_content() {
		return good_content;
	}
	public void setGood_content(String good_content) {
		this.good_content = good_content;
	}
	public String getGood_image() {
		return good_image;
	}
	public void setGood_image(String good_image) {
		this.good_image = good_image;
	}
	public String getGood_price() {
		return good_price;
	}
	public void setGood_price(String good_price) {
		this.good_price = good_price;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", good_name=" + good_name + ", good_content=" + good_content + ", good_image="
				+ good_image + ", good_price=" + good_price + ", user_account=" + user_account + ", number=" + number
				+ "]";
	}
	
	
}
