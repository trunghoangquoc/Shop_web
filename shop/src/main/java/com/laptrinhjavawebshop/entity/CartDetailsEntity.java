package com.laptrinhjavawebshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartdetails")
public class CartDetailsEntity extends BaseEntity {
   
	
	@Column(name = "nameproduct")
	private String nameProduct;
	
	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "price")
	private Float price;
   
	@Column(name = "img")
	private String codeImg;
	
	@Column(name = "usernameofcart")
	private String userNameOfCart;
	
	@Column(name = "totalmoney")
	private Float totalMoney;
	
	@Column
	private Integer status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_Id")
	private ProductEntity product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_Id")
	private CartEntity cart;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCodeImg() {
		return codeImg;
	}

	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}

	public String getUserNameOfCart() {
		return userNameOfCart;
	}

	public void setUserNameOfCart(String userNameOfCart) {
		this.userNameOfCart = userNameOfCart;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	
	
}
