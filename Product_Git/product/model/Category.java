package com.product.model;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cat_id;
	private String cat_name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Attribute_Category",
	joinColumns = {@JoinColumn(name ="cat_id")},inverseJoinColumns = {@JoinColumn(name="att_id")})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Attribute_Master> attri = new HashSet<Attribute_Master>();
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cat_id, String cat_name, Set<Attribute_Master> attri) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.attri = attri;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public Set<Attribute_Master> getAttri() {
		return attri;
	}

	public void setAttri(Set<Attribute_Master> attri) {
		this.attri = attri;
	}

	
	
}
