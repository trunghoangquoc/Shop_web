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
@Table(name = "orderuser")
public class OrderEntity extends BaseEntity {
	

	@Column(name = "usernameorder")
	private String userNameOrder;
	
	@Column(name = "receivername")
	private String receiverName;
	
	@Column(name = "receiverphone")
	private String receiverPhone;
	
	@Column(name = "receiveraddress")
	private String receiverAddress;
   
	@Column(name = "email")
	private String email;
	
	@Column(name = "orderstatus")
	private Integer orderStatus;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(name = "totalpay")
	private Float totalPay;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<OrderDetailsEntity> orderDetails = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userOrder ;  //userOrder -- (mappedBy = "userOrder") bên thằng UserEntity

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	
	public String getUserNameOrder() {
		return userNameOrder;
	}

	public void setUserNameOrder(String userNameOrder) {
		this.userNameOrder = userNameOrder;
	}

	public Float getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(Float totalPay) {
		this.totalPay = totalPay;
	}

	public List<OrderDetailsEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public UserEntity getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserEntity userOrder) {
		this.userOrder = userOrder;
	}
	
	
}
