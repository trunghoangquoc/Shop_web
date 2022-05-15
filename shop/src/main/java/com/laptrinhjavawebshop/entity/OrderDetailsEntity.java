package com.laptrinhjavawebshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orderdetails")
public class OrderDetailsEntity extends BaseEntity {
	
		@Column(name = "nameproduct")
		private String nameProduct;
		
		@Column(name = "quantity")
		private Long quantity;
		
		@Column(name = "price")
		private Float price;
	   
		@Column(name = "img")
		private String codeImg;
		
		@Column(name = "totalmoney")
		private Float totalMoney;
		
		@Column(name = "usernameorder")
		private String userNameOrder;
		
		@ManyToOne
		@JoinColumn(name = "order_id")// orderId n - 1 order
		private OrderEntity order; //order -- (mappedBy = "order") bên thằng OrderEntity

		
		
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

		public OrderEntity getOrder() {
			return order;
		}

		public void setOrder(OrderEntity order) {
			this.order = order;
		}
		
		
}
