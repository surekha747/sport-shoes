package com.simplilearn.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.model.Color;
import com.simplilearn.sportyshoes.model.Gender;
import com.simplilearn.sportyshoes.model.ShoesCategory;
import com.simplilearn.sportyshoes.model.SignedUsers;
import com.simplilearn.sportyshoes.model.Size;
import com.simplilearn.sportyshoes.repository.ColorRepository;
import com.simplilearn.sportyshoes.repository.GenderRepository;
import com.simplilearn.sportyshoes.repository.ShoesCategoryRepository;
import com.simplilearn.sportyshoes.repository.SizeRepository;

@Service
public class ProductService {
	@Autowired
	ColorRepository repository;
	@Autowired
	SizeRepository sizerepository;
	@Autowired
	ShoesCategoryRepository shoerepository;
	@Autowired
	GenderRepository repo;

	public List<Color> getColorList() {
		List<Color> list = (List<Color>) repository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<Color>();
		}
	}

	public List<Size> getSizeList() {
		List<Size> list = (List<Size>) sizerepository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<Size>();
		}
	}
	public List<Gender> getGenderList() {
		List<Gender> list = (List<Gender>) repo.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<Gender>();
		}
	}


	public List<ShoesCategory> getShoeTypeList() {
		List<ShoesCategory> list = (List<ShoesCategory>) shoerepository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<ShoesCategory>();
		}
	}
}
