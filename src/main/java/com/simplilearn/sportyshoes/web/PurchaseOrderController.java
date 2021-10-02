package com.simplilearn.sportyshoes.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import com.simplilearn.sportyshoes.model.ColorCategory;
import com.simplilearn.sportyshoes.model.GenderCategory;
import com.simplilearn.sportyshoes.model.PurchaseOrder;
import com.simplilearn.sportyshoes.model.ShoesCategory;
import com.simplilearn.sportyshoes.model.SizeCategory;
import com.simplilearn.sportyshoes.service.ExcelService;
import com.simplilearn.sportyshoes.service.ProductService;
@Controller
public class PurchaseOrderController {
	@Autowired
	ProductService service;
	@Autowired
	ExcelService excelService;

	@RequestMapping(value = "/purchaseReport", method = RequestMethod.GET)
	public String getPurchaseReport(PurchaseOrder purchaseOrder, Model model) {
		List<ColorCategory> list = service.getColorList();
		purchaseOrder.setColorlist(list);
		List<SizeCategory> sizelist = service.getSizeList();
		purchaseOrder.setSizelist(sizelist);
		List<ShoesCategory> categorylist = service.getShoeTypeList();
		purchaseOrder.setCategorylist(categorylist);
		List<GenderCategory> genderlist = service.getGenderList();
		purchaseOrder.setGenderlist(genderlist);
		model.addAttribute("purchaseOrder", purchaseOrder);
		return "purchase-report";

	}

	@RequestMapping(value = "/purchaseReport", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> getFile(String shoe_type, String fromDate, String toDate)
			throws ParseException {
		String filename = "PurchaseReport.xlsx";

		InputStreamResource file = null;

		file = new InputStreamResource(excelService.load(shoe_type, fromDate, toDate));

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
}
