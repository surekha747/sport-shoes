package com.simplilearn.sportyshoes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ShoeCategoryProduct")
public class ShoeCategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String shoe_type;
	@OneToMany(mappedBy="shoeentity")
	private List<Product> product;
	
	public ShoeCategoryEntity(String shoe_type, List<Product> product) {
		super();
		this.shoe_type = shoe_type;
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShoe_type() {
		return shoe_type;
	}
	public void setShoe_type(String shoe_type) {
		this.shoe_type = shoe_type;
	}
	public ShoeCategoryEntity(String shoe_type) {
		super();
		this.shoe_type = shoe_type;
	}
	public ShoeCategoryEntity() {
		super();
		
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
