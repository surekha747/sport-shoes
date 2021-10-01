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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3515464855236976939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@Column
	private String gender;
	@Column 
	private String color;
	@Column
	private String size;
	@Column
	private String status;
	@Column
	private String photos;
	
	private String photosImagePath;
	
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	@Column
	private String shoe_type;
	
	@Transient
	    public String getPhotosImagePath() {
	        if (photos == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + photos;
	    }
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private ShoeCategoryEntity shoeentity;
	
	@OneToMany(mappedBy ="product")
	private List<SizeEntity> sizeentity;
	
	
	@Transient
	private List<ColorCategory> colorlist;
	@Transient
	private List<SizeCategory> sizelist;

	@Transient
	private List<ShoesCategory> categorylist;

	@Transient
	private List<GenderCategory> genderlist;

	@Transient
	private List<Image> imagelist;
	
	public List<SizeEntity> getSizeentity() {
		return sizeentity;
	}

	public void setSizeentity(List<SizeEntity> sizeentity) {
		this.sizeentity = sizeentity;
	}
	
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

		public List<Image> getImagelist() {
		return imagelist;
	}

	public void setImagelist(List<Image> imagelist) {
		this.imagelist = imagelist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public List<ColorCategory> getColorlist() {
		return colorlist;
	}

	public void setColorlist(List<ColorCategory> colorlist) {
		this.colorlist = colorlist;
	}

	public List<SizeCategory> getSizelist() {
		return sizelist;
	}

	public void setSizelist(List<SizeCategory> sizelist) {
		this.sizelist = sizelist;
	}

	public List<GenderCategory> getGenderlist() {
		return genderlist;
	}

	public void setGenderlist(List<GenderCategory> genderlist) {
		this.genderlist = genderlist;
	}

	public List<ShoesCategory> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<ShoesCategory> categorylist) {
		this.categorylist = categorylist;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ShoeCategoryEntity getShoeentity() {
		return shoeentity;
	}

	public void setShoeentity(ShoeCategoryEntity shoeentity) {
		this.shoeentity = shoeentity;
	}

	public Product(Long id,String product_name, String brand_name, String manufacturer, Double standard_price,
			Double maximum_retail_price, String offers, String sku, String product_enrichment, String keyword,
			String discount, Long stock, String gender,String photos, String color, String shoe_type,String size, String status,
			ShoeCategoryEntity shoeentity, List<SizeEntity> sizeentity) {
		super();
		this.id=id;
		this.shoe_type=shoe_type;
		this.product_name = product_name;
		this.brand_name = brand_name;
		this.manufacturer = manufacturer;
		this.standard_price = standard_price;
		this.maximum_retail_price = maximum_retail_price;
		this.offers = offers;
		this.sku = sku;
		this.product_enrichment = product_enrichment;
		this.keyword = keyword;
		this.discount = discount;
		this.stock = stock;
		this.gender = gender;
		this.color = color;
		this.size = size;
		this.status = status;
		this.shoeentity = shoeentity;
		this.sizeentity = sizeentity;
		this.photos=photos;
		
		
	}



	public String getShoe_type() {
		return shoe_type;
	}

	public void setShoe_type(String shoe_type) {
		this.shoe_type = shoe_type;
	}
	public void setPhotosImagePath(String photosImagePath) {
		this.photosImagePath = photosImagePath;
	}
	

	

	

}
