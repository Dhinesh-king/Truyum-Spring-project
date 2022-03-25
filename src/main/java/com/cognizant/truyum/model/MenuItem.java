package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class MenuItem {
	private long id;
	@NotBlank(message="Name Field Cannot be Blank")
	private String name;
	@DecimalMin(value="1",message="Price should be a Number")
	private float price;
	private boolean active;
	//@Pattern(regexp="[0-9]{2}/[0-9]{2}/[0-9]{4}",message="Date Should be in the Pattern (dd/MM/yyyy) ")
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;
	private String activeString;
	private String freeDeliveryString;
	public MenuItem() {
		super();
	}
	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		if(active==true) {
			this.setActiveString("Yes");
		}
		else {
			this.setActiveString("No");
		}
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		if(freeDelivery==true) {
			this.setFreeDeliveryString("Yes");
		}
		else {
			this.setFreeDeliveryString("No");
		}
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String getActiveString() {
		return activeString;
	}
	public void setActiveString(String activeString) {
		this.activeString = activeString;
	}
	public String getFreeDeliveryString() {
		return freeDeliveryString;
	}
	public void setFreeDeliveryString(String freeDeliveryString) {
		this.freeDeliveryString = freeDeliveryString;
	}

}
