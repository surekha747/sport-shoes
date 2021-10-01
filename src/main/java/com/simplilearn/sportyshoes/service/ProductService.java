package com.simplilearn.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.model.ColorCategory;
import com.simplilearn.sportyshoes.model.GenderCategory;
import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.model.ShoesCategory;
import com.simplilearn.sportyshoes.model.SignedUsers;
import com.simplilearn.sportyshoes.model.SizeCategory;
import com.simplilearn.sportyshoes.repository.ColorRepository;
import com.simplilearn.sportyshoes.repository.GenderRepository;
import com.simplilearn.sportyshoes.repository.ProductRepository;
import com.simplilearn.sportyshoes.repository.ShoesCategoryRepository;
import com.simplilearn.sportyshoes.repository.SizeRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository proeuctRepo;
	@Autowired
	ColorRepository repository;
	@Autowired
	SizeRepository sizerepository;
	@Autowired
	ShoesCategoryRepository shoerepository;
	@Autowired
	GenderRepository repo;

	public List<ColorCategory> getColorList() {
		List<ColorCategory> list = (List<ColorCategory>) repository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<ColorCategory>();
		}
	}

	public List<SizeCategory> getSizeList() {
		List<SizeCategory> list = (List<SizeCategory>) sizerepository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<SizeCategory>();
		}
	}
	public List<GenderCategory> getGenderList() {
		List<GenderCategory> list = (List<GenderCategory>) repo.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<GenderCategory>();
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
	public Product addProduct(Product product) {
		return proeuctRepo.save(product);
	}
	
	public List<Product> getProductList(){
		return proeuctRepo.findAll();
		
	}

	

	public Product getProductByid(Long id) {
		Optional < Product > optional = proeuctRepo.findById(id);
		Product product = null;
        if (optional.isPresent()) {
        	product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " +id);
        }
        return product;
	}

	
}
