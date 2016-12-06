package com.example.orderapp1.util;

import java.io.Serializable;

public class food implements Serializable{
	private int id;
	private String foodname;
	private int num;
	private int price;
	public food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public food(String foodname, int price) {
		super();
		this.foodname = foodname;
		this.price = price;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfoodname() {
		return foodname;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setfoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "food [id=" + id + ", foodname=" + foodname + ", num=" + num + ", price="
				+ price + "]";
	}
	
}
