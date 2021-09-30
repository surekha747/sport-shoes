package com.simplilearn.sportyshoes.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.simplilearn.sportyshoes.model.PurchaseOrder;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Ordered By", "Order Date", "PO Promise Date", "PO Paid", "PO Paid Type",
			"PO Confirmed", "PO Canceled", "Product Name", "Sub Category", "Product Quantity", "Shoe Color", "Size",
			"Shoe Category" };
	static String SHEET = "Purchase Order Report";

	public static ByteArrayInputStream purchaseOrderToExcel(List<PurchaseOrder> porder) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			// Header

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			if (porder != null) {
				for (PurchaseOrder po : porder) {
					Row row = sheet.createRow(rowIdx++);

					row.createCell(0).setCellValue(po.getId());
					row.createCell(1).setCellValue(po.getOrdered_by());
					row.createCell(2).setCellValue(formatter.format(po.getOrderdate()));
					row.createCell(3).setCellValue(po.getPo_promise_date());
					row.createCell(4).setCellValue(po.getPo_paid());
					row.createCell(5).setCellValue(po.getPo_paid_type());
					row.createCell(6).setCellValue(po.getPo_confirmed());
					row.createCell(7).setCellValue(po.getPo_cancelled());
					row.createCell(8).setCellValue(po.getProduct_name());
					row.createCell(9).setCellValue(po.getCategory());
					row.createCell(10).setCellValue(po.getProduct_quantity());
					row.createCell(11).setCellValue(po.getShoe_color());
					row.createCell(12).setCellValue(po.getShoe_size());
					row.createCell(13).setCellValue(po.getShoecategory());
				}

				workbook.write(out);
			}
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}