package com.simplilearn.sportyshoes.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.helper.ExcelHelper;
import com.simplilearn.sportyshoes.helper.StringToSqlDateConvertor;
import com.simplilearn.sportyshoes.model.PurchaseOrder;
import com.simplilearn.sportyshoes.repository.PurchaseOrderReportRepository;

@Service
public class ExcelService {
	@Autowired
	PurchaseOrderReportRepository repo;
	@Autowired
	StringToSqlDateConvertor stringTodate;
	List<PurchaseOrder> porder = null;

	public ByteArrayInputStream load(String shoe_type, String fromDate, String toDate) {
		if (shoe_type != null && fromDate != null && toDate != null) {
			porder = repo.findAllByShoecategoryAndOrderdateBetween(shoe_type, stringTodate.convertTo(fromDate),
					stringTodate.convertTo(toDate));
		} else if (fromDate != null && toDate != null) {
			List<PurchaseOrder> porder = repo.findAllByOrderdateBetween(stringTodate.convertTo(fromDate),
					stringTodate.convertTo(toDate));
		} else if (shoe_type != null) {
			List<PurchaseOrder> porder = repo.findAllByShoecategory(shoe_type);
		} else {
			List<PurchaseOrder> porder = repo.findAll();
		}

		ByteArrayInputStream inputstream = ExcelHelper.purchaseOrderToExcel(porder);
		return inputstream;

	}

	

}
