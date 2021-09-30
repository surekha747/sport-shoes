package com.simplilearn.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoe_category")
public class ShoesCategory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String shoe_type;

	public String getShoe_type() {
		return shoe_type;
	}

	public void setShoe_type(String shoe_type) {
		this.shoe_type = shoe_type;
	}

	public ShoesCategory(String shoe_type) {
		super();
		
		this.shoe_type = shoe_type;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoesCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
