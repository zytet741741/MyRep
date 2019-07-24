package com.sontan.entity;

public class Good {
	private Integer id;
	private Integer good_type_id;
	private String good_name;
	private String good_content;
	private String good_price;
	private String good_image;
	private Good goodType;
	public Good getGoodType() {
		return goodType;
	}
	public void setGoodType(Good goodType) {
		this.goodType = goodType;
	}
	private Order order;
	private OrderType orderType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGood_type_id() {
		return good_type_id;
	}
	public void setGood_type_id(Integer good_type_id) {
		this.good_type_id = good_type_id;
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


	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	@Override
	public String toString() {
		return "Good [id=" + id + ", good_type_id=" + good_type_id + ", good_name=" + good_name + ", good_content="
				+ good_content + ", good_price=" + good_price + ", good_image=" + good_image + ", order=" + order
				+ ", orderType=" + orderType + "]";
	}

	
	
	

	
	
}
