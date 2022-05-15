package com.laptrinhjavawebshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product") // để biết đang mapping với table trong database
public class ProductEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "totalnumber")
	private Long totalNumber;

	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(name = "price", columnDefinition = "TEXT")
	private Float price;

	@Column(name = "categorycode")
	private String categoryCode;
    
	
	
	@Column(name = "img")
	private String codeImg;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	// trong bảng New sẽ sinh ra 1 cột là category_id
	private CategoryEntity category;// mappedBy = "category" bên CategoryEntity

	
	@OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL )
	private List<CartDetailsEntity> cartDetails = new ArrayList<>();



	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCodeImg() {
		return codeImg;
	}

	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}

	public List<CartDetailsEntity> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetailsEntity> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
