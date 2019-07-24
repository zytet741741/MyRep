package com.sontan.entity;

public class Order {
	private Integer id;
	private String good_name;
	private String good_price;
	private String good_image;
	private String user_account;
	private String evaluated;
	private Integer good_number;
	private Integer good_total_price;
	private Integer order_type_id;
	
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
	public String getGood_price() {
		return good_price;
	}
	public void setGood_price(String good_price) {
		this.good_price = good_price;
	}
	public String getGood_image() {
		return good_image;
	}
	public void setGood_image(String good_image) {
		this.good_image = good_image;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	
	public String getEvaluated() {
		return evaluated;
	}
	public void setEvaluated(String evaluated) {
		this.evaluated = evaluated;
	}
	public Integer getGood_number() {
		return good_number;
	}
	public void setGood_number(Integer good_number) {
		this.good_number = good_number;
	}
	public Integer getGood_total_price() {
		return good_total_price;
	}
	public void setGood_total_price(Integer good_total_price) {
		this.good_total_price = good_total_price;
	}
	public Integer getOrder_type_id() {
		return order_type_id;
	}
	public void setOrder_type_id(Integer order_type_id) {
		this.order_type_id = order_type_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", good_name=" + good_name + ", good_price=" + good_price + ", good_image="
				+ good_image + ", user_account=" + user_account + ", evaluated=" + evaluated + ", good_number="
				+ good_number + ", good_total_price=" + good_total_price + ", order_type_id=" + order_type_id + "]";
	}

	
	
}
