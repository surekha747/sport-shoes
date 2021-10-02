package com.simplilearn.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="image")
public class Image {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String image_path;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getImage_path() {
	return image_path;
}
public void setImage_path(String image_path) {
	this.image_path = image_path;
}
}
