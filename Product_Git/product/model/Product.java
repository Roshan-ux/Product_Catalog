package com.product.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prod_id;
	
	@Size(min = 10,max = 100)
	private String prod_name;
	
	@Min(value = 2000)
	@Max(value = 50_000)
	private float price;
	
	@Size(min=100,max = 400)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cate",referencedColumnName = "cat_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int prod_id, String prod_name, float price, String description, Category category) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.price = price;
		this.description = description;
		this.category = category;
	}


	public int getProd_id() {
		return prod_id;
	}


	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	
	
}
