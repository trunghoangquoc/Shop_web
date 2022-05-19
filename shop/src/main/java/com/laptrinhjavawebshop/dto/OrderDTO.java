package com.laptrinhjavawebshop.dto;



public class OrderDTO extends AbstractDTO<OrderDTO> {

	
	private String userNameOrder;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private String email;
	private Integer orderStatus;
	private String shortDescription;
	private Float totalPay;
	
	public OrderDTO() {
		super();
		
	}
	
	public OrderDTO(String userNameOrder, String receiverName, String receiverPhone, String receiverAddress,
			String email, Integer orderStatus, String shortDescription, Float totalPay) {
		super();
		this.userNameOrder = userNameOrder;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.email = email;
		this.orderStatus = orderStatus;
		this.shortDescription = shortDescription;
		this.totalPay = totalPay;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserNameOrder() {
		return userNameOrder;
	}
	public void setUserNameOrder(String userNameOrder) {
		this.userNameOrder = userNameOrder;
	}
	
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Float getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}
	
	
}
