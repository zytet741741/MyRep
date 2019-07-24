package com.sontan.entity;

public class GoodType {
	private Integer id;
	private String good_type_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGood_type_name() {
		return good_type_name;
	}
	public void setGood_type_name(String good_type_name) {
		this.good_type_name = good_type_name;
	}
	@Override
	public String toString() {
		return "GoodType [id=" + id + ", good_type_name=" + good_type_name + "]";
	}
	
	
}
