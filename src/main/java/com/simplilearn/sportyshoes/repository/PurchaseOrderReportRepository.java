package com.simplilearn.sportyshoes.repository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.model.PurchaseOrder;

public interface PurchaseOrderReportRepository extends JpaRepository<PurchaseOrder, Long> {
List<PurchaseOrder> findAllByShoecategoryAndOrderdateBetween(String shoe_type, Date fromDate, Date toDate);

List<PurchaseOrder> findAllByShoecategory(String shoe_type);

List<PurchaseOrder> findAllByOrderdate(Date date);



List<PurchaseOrder> findAllByOrderdateBetween(Date fromDate, Date toDate);	
}
