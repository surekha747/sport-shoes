package com.simplilearn.sportyshoes.web;

import java.io.IOException;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simplilearn.sportyshoes.helper.FileUploadUtil;
import com.simplilearn.sportyshoes.model.ColorCategory;

import com.simplilearn.sportyshoes.model.GenderCategory;
import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.model.ShoesCategory;

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

	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String save(Product product, Model model, @RequestParam("image") MultipartFile multipartFile,
			RedirectAttributes redirAttrs) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		product.setPhotos(fileName);
		Product savedproduct = service.addProduct(product);

		String uploadDir = "user-photos/" + savedproduct.getId();

		FileUploadUtil.saveFile(uploadDir,savedproduct.getId(), fileName, multipartFile);

		Product prod = service.getProductByid(savedproduct.getId());
		String showdDir = "/user-photos/" + savedproduct.getId() + "/" + savedproduct.getPhotos();

		prod.setPhotosImagePath(showdDir);
		service.addProduct(prod);
		List<ColorCategory> list = service.getColorList();
		product.setColorlist(list);
		List<SizeCategory> sizelist = service.getSizeList();
		product.setSizelist(sizelist);
		List<ShoesCategory> categorylist = service.getShoeTypeList();
		product.setCategorylist(categorylist);
		List<GenderCategory> genderlist = service.getGenderList();
		product.setGenderlist(genderlist);
		// service.getProductList()
		if (prod != null) {
			model.addAttribute("productlist", prod);
			redirAttrs.addFlashAttribute("success", "Product Added Successfully.");
		}

		//return "product";

		return "redirect:/product?success";

	}

	@RequestMapping(value = "/viewproducts")
	public String view(Product product, Model model) {
		model.addAttribute("productlist", service.getProductList());
		return "productlist";

	}

	@RequestMapping(value = "/editproduct/{id}")
	public String edit(@PathVariable(value = "id") Long id, Model model) {
		Product product = service.getProductByid(id);
		model.addAttribute("product", product);
		return "updateProduct";

	}

	// saveProduct
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product, Model model,RedirectAttributes redirAttrs) {
		Product prod=service.addProduct(product);
		String showdDir = "/user-photos/" + prod.getId() + "/" + prod.getPhotos();
		prod.setPhotosImagePath(showdDir);
		model.addAttribute("productlist", service.getProductList());
		
		return "productlist";

	}

}
