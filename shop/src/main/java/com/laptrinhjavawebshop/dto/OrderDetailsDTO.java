package com.laptrinhjavawebshop.dto;

public class OrderDetailsDTO extends AbstractDTO<OrderDetailsDTO> {
	
	
	private String userNameOrder;
	private String nameProduct;
	private Long quantity;
	private Float price;
	private String codeImg;
	private Float totalMoney;
	private Long productId; 
	private Long orderId;
	private Float totalPay;
	
	public Float getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}
	public String getUserNameOrder() {
		return userNameOrder;
	}
	public void setUserNameOrder(String userNameOrder) {
		this.userNameOrder = userNameOrder;
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
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
}
