package com.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductAttribute {
	
	@Id
	int prod_att_id;
	
	int pid;
	int att_id;
	String value;
	
	public ProductAttribute(int prod_att_id, int pid, int att_id, String value) {
		super();
		this.prod_att_id = prod_att_id;
		this.pid = pid;
		this.att_id = att_id;
		this.value = value;
	}
	
	public ProductAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProd_att_id() {
		return prod_att_id;
	}
	public void setProd_att_id(int prod_att_id) {
		this.prod_att_id = prod_att_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getAtt_id() {
		return att_id;
	}
	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
