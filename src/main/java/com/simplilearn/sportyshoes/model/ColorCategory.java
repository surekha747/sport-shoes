package com.simplilearn.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "color")
public class ColorCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String color_value;
	/*
	 * @Column private boolean active;
	 */
	
	public String getColor_value() {
		return color_value;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setColor_value(String color_value) {
		this.color_value = color_value;
	}
}
