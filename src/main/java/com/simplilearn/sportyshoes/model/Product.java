package com.simplilearn.sportyshoes.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3515464855236976939L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long prod_id;
	@Column
	private String product_name;
	@Column
	private String brand_name;
	@Column
	private String manufacturer;
	@Column
	private Double standard_price;
	@Column
	private Double maximum_retail_price;
	@Column
	private String offers;
	@Column
	private String sku;
	@Column
	private String product_enrichment;
	@Column
	private String keyword;
	@Column
	private String discount;
	@Column
	private Long stock;
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	@Transient  
	private List <Color> colorlist;
	  @OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn(name="pid")
	  @OrderColumn(name="type")  
	  private List <Size> sizelist;
	
	@Transient   
	private List <ShoesCategory> categorylist;
	
	@Transient  
	private List <Gender> genderlist;
	
	@Transient   
	private List <Image> imagelist;
	
	public List<Image> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<Image> imagelist) {
		this.imagelist = imagelist;
	}



	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public List<Gender> getGenderlist() {
		return genderlist;
	}

	public void setGenderlist(List<Gender> genderlist) {
		this.genderlist = genderlist;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String product_name, String brand_name, Double standard_price, Double maximum_retail_price,
			String offers, String sku, String product_enrichment, Long stock, List<Color> colorlist) {
		super();
		this.product_name = product_name;
		this.brand_name = brand_name;
		this.standard_price = standard_price;
		this.maximum_retail_price = maximum_retail_price;
		this.offers = offers;
		this.sku = sku;
		this.product_enrichment = product_enrichment;
		this.stock = stock;
		this.colorlist = colorlist;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public Double getStandard_price() {
		return standard_price;
	}

	public void setStandard_price(Double standard_price) {
		this.standard_price = standard_price;
	}

	public Double getMaximum_retail_price() {
		return maximum_retail_price;
	}

	public void setMaximum_retail_price(Double maximum_retail_price) {
		this.maximum_retail_price = maximum_retail_price;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProduct_enrichment() {
		return product_enrichment;
	}

	public void setProduct_enrichment(String product_enrichment) {
		this.product_enrichment = product_enrichment;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public List <Color> getColorlist() {
		return colorlist;
	}

	public void setColorlist(List <Color> colorlist) {
		this.colorlist = colorlist;
	}

	public List <Size> getSizelist() {
		return sizelist;
	}

	public void setSizelist(List <Size> sizelist) {
		this.sizelist = sizelist;
	}

	public List <ShoesCategory> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List <ShoesCategory> categorylist) {
		this.categorylist = categorylist;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	}
