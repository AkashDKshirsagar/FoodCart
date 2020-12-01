package com.akash.bean;

public class Food {
	private int code = 0;
	private String item = " ";
	private float price = 0.0f;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Food() {

	}
	
	public Food(int id){
		this.code = id;
	}

	@Override
	public String toString() {
		return "Food [code=" + code + ", item=" + item + ", price=" + price + "]";
	}
	
}
