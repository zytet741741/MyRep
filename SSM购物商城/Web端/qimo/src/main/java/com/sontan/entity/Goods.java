package com.sontan.entity;

public class Goods {
	private String id;
	private String typeid;
	private String good_name;
	private String content;
	private Double price;
	private String create_date;
	private String imgurl;
//	private Order order;
//	private OrderType orderType;
	
//	public OrderType getOrderType() {
//		return orderType;
//	}
//	public void setOrderType(OrderType orderType) {
//		this.orderType = orderType;
//	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", typeid=" + typeid + ", good_name=" + good_name + ", content=" + content
				+ ", price=" + price + ", create_date=" + create_date + ", imgurl=" + imgurl + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
