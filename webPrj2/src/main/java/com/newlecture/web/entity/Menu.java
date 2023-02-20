package com.newlecture.web.entity;

import java.util.Date;

public class Menu {

	private int id;
	private String name;
	private int price;
	private String img; //img였음
	private Date regDate; //java.util.Date;임! sql아님. 자바에서 이용하니까 util인가?
	private String imgs;
	
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	

	public Menu(int id, String name, int price, String img, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.regDate = regDate;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDon() {
		return img;
	}

	public void setDon(String don) {
		this.img = don;
	}
	


	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getImgs() {
		return imgs;
	}



	public void setImgs(String imgs) {
		this.imgs = imgs;
	}



	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", regDate=" + regDate
				+ ", imgs=" + imgs + "]";
	}






	
	
	
}
