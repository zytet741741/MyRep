package com.sontan.entity;

public class OrderType {
	private Integer id;
	private String order_status_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_status_name() {
		return order_status_name;
	}
	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}
	@Override
	public String toString() {
		return "OrderType [id=" + id + ", order_status_name=" + order_status_name + "]";
	}
	
	
	
}
