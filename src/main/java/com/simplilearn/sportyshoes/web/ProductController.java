package com.simplilearn.sportyshoes.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.model.Color;
import com.simplilearn.sportyshoes.model.Gender;
import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.model.ShoesCategory;
import com.simplilearn.sportyshoes.model.SignedUsers;
import com.simplilearn.sportyshoes.model.Size;
import com.simplilearn.sportyshoes.service.ProductService;

@Controller
@RequestMapping(value="/product", method = RequestMethod.GET)
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping
    public String getColors(Product product,Model model) 
    {
		
		 List<Color> list = service.getColorList();
		 product.setColorlist(list);
		 List<Size> sizelist = service.getSizeList();
		 product.setSizelist(sizelist);
		 List<ShoesCategory> categorylist = service.getShoeTypeList();
		 product.setCategorylist(categorylist);
		List<Gender> genderlist=service.getGenderList();
		product.setGenderlist(genderlist);
	        model.addAttribute("product", product);
	        return "product";	
    }
	   }

