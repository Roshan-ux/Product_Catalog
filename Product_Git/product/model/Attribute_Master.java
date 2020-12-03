package com.product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "attribute_master")
public class Attribute_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int att_id;
	String att_name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Attribute_Category",
	joinColumns = {@JoinColumn(name ="att_id")},inverseJoinColumns = {@JoinColumn(name="cat_id")})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Category> attri = new HashSet<Category>();
	
	
	public Attribute_Master() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Attribute_Master(int att_id, String att_name, Set<Category> attri) {
		super();
		this.att_id = att_id;
		this.att_name = att_name;
		this.attri = attri;
	}


	public int getAtt_id() {
		return att_id;
	}


	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}


	public String getAtt_name() {
		return att_name;
	}


	public void setAtt_name(String att_name) {
		this.att_name = att_name;
	}


	public Set<Category> getAttri() {
		return attri;
	}


	public void setAttri(Set<Category> attri) {
		this.attri = attri;
	}


	
	
}
