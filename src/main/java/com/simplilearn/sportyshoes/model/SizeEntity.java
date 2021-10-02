package com.simplilearn.sportyshoes.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SizeEntity")
public class SizeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String size_value;
	@ManyToOne
	private Product product;
	@OneToMany(mappedBy="sizeentity")
	private List<ColorEntity> colorlist;
	
	public SizeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SizeEntity(String size_value, Product product, List<ColorEntity> colorlist) {
		super();
		this.size_value = size_value;
		this.product = product;
		this.colorlist = colorlist;
	}
	public List<ColorEntity> getColorlist() {
		return colorlist;
	}
	public void setColorlist(List<ColorEntity> colorlist) {
		this.colorlist = colorlist;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSize_value() {
		return size_value;
	}
	public void setSize_value(String size_value) {
		this.size_value = size_value;
	}
	
}
