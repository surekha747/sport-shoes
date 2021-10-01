package com.simplilearn.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ColorEntity")
public class ColorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String color_value;
	@ManyToOne
	private SizeEntity sizeentity;
	
	public SizeEntity getSizeentity() {
		return sizeentity;
	}

	public void setSizeentity(SizeEntity sizeentity) {
		this.sizeentity = sizeentity;
	}

	public void setColor_value(String color_value) {
		this.color_value = color_value;
	}

	public ColorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColorEntity(SizeEntity sizeentity, String color_value) {
		super();
		this.sizeentity = sizeentity;
		this.color_value = color_value;
	}
	
    public String getColor_value() {
		return color_value;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
