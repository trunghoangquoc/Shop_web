package com.laptrinhjavawebshop.dto;


public class CartDTO extends AbstractDTO<CartDTO>{
	private String userNameOfCart;
	private String nameProduct;
	private Long quantity;
	private Float price;
	private String codeImg;
	private Float totalMoney;
	private Long productId; 
	private Integer status;
	
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getUserNameOfCart() {
		return userNameOfCart;
	}
	public void setUserNameOfCart(String userNameOfCart) {
		this.userNameOfCart = userNameOfCart;
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
	public Float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
