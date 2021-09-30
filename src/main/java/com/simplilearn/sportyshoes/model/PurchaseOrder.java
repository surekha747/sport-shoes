package com.simplilearn.sportyshoes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

//purchase_orders
@Entity
@Table(name="purchase_orders")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String ordered_by;
	private Date orderdate;
	private String po_promise_date;
	private String po_paid;
	private String po_paid_type;
	private String po_confirmed;
	private String po_cancelled;
	private String product_name;
	private String category;
	private String product_quantity;
	private String shoe_color;
	private String shoe_size;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;
	private String shoecategory;
	
	@Transient
	private List<Color> colorlist;
	@Transient
	private List<Size> sizelist;
	@Transient
	private List<ShoesCategory> categorylist;
	@Transient
	private List<Gender> genderlist;


	public List<Color> getColorlist() {
		return colorlist;
	}

	public void setColorlist(List<Color> colorlist) {
		this.colorlist = colorlist;
	}

	public List<Size> getSizelist() {
		return sizelist;
	}

	public void setSizelist(List<Size> sizelist) {
		this.sizelist = sizelist;
	}

	public List<ShoesCategory> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<ShoesCategory> categorylist) {
		this.categorylist = categorylist;
	}

	public List<Gender> getGenderlist() {
		return genderlist;
	}

	public void setGenderlist(List<Gender> genderlist) {
		this.genderlist = genderlist;
	}

	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder(String ordered_by, Date orderdate, String po_promise_date, String po_paid,
			String po_paid_type, String po_confirmed, String po_cancelled, String product_name, String category,
			String product_quantity, String shoe_color, String shoe_size,String shoecategory) {
		super();
		this.ordered_by = ordered_by;
		this.orderdate = orderdate;
		this.po_promise_date = po_promise_date;
		this.po_paid = po_paid;
		this.po_paid_type = po_paid_type;
		this.po_confirmed = po_confirmed;
		this.po_cancelled = po_cancelled;
		this.product_name = product_name;
		this.category = category;
		this.product_quantity = product_quantity;
		this.shoe_color = shoe_color;
		this.shoe_size = shoe_size;
		this.shoecategory=shoecategory;
	}

	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getOrdered_by() {
		return ordered_by;
	}

	public void setOrdered_by(String ordered_by) {
		this.ordered_by = ordered_by;
	}

	

	public String getPo_promise_date() {
		return po_promise_date;
	}

	public void setPo_promise_date(String po_promise_date) {
		this.po_promise_date = po_promise_date;
	}

	public String getPo_paid() {
		return po_paid;
	}

	public void setPo_paid(String po_paid) {
		this.po_paid = po_paid;
	}

	public String getPo_paid_type() {
		return po_paid_type;
	}

	public void setPo_paid_type(String po_paid_type) {
		this.po_paid_type = po_paid_type;
	}

	public String getPo_confirmed() {
		return po_confirmed;
	}

	public void setPo_confirmed(String po_confirmed) {
		this.po_confirmed = po_confirmed;
	}

	public String getPo_cancelled() {
		return po_cancelled;
	}

	public void setPo_cancelled(String po_cancelled) {
		this.po_cancelled = po_cancelled;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getShoe_color() {
		return shoe_color;
	}

	public void setShoe_color(String shoe_color) {
		this.shoe_color = shoe_color;
	}

	public String getShoe_size() {
		return shoe_size;
	}

	public void setShoe_size(String shoe_size) {
		this.shoe_size = shoe_size;
	}

	



	public String getShoecategory() {
		return shoecategory;
	}

	public void setShoecategory(String shoecategory) {
		this.shoecategory = shoecategory;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
