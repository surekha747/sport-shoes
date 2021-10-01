package com.simplilearn.sportyshoes.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.model.ColorCategory;

import com.simplilearn.sportyshoes.model.GenderCategory;
import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.model.ShoesCategory;
import com.simplilearn.sportyshoes.model.SignedUsers;

import com.simplilearn.sportyshoes.model.SizeCategory;
import com.simplilearn.sportyshoes.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getCategories(Product product, Model model) {

		List<ColorCategory> list = service.getColorList();
		product.setColorlist(list);
		List<SizeCategory> sizelist = service.getSizeList();
		product.setSizelist(sizelist);
		List<ShoesCategory> categorylist = service.getShoeTypeList();
		product.setCategorylist(categorylist);
		List<GenderCategory> genderlist = service.getGenderList();
		product.setGenderlist(genderlist);
		model.addAttribute("product", product);
		return "product";
	}
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String save(Product product,Model model) {
		service.addProduct(product);
		/*
		 * List<ColorCategory> list = service.getColorList();
		 * product.setColorlist(list); List<SizeCategory> sizelist =
		 * service.getSizeList(); product.setSizelist(sizelist); List<ShoesCategory>
		 * categorylist = service.getShoeTypeList();
		 * product.setCategorylist(categorylist); List<GenderCategory> genderlist =
		 * service.getGenderList(); product.setGenderlist(genderlist);
		 */
		model.addAttribute("productlist",service.getProductList());
		return "product";
		
	}

}
