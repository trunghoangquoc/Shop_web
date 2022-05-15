package com.laptrinhjavawebshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "cart")//để biết đang mapping với table trong database
public class CartEntity extends BaseEntity {
	
	
	@Column(name = "usernameofcart")
	private String userNameOfCart;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity userCart ;

	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<CartDetailsEntity> cartDetails = new ArrayList<>();


	public List<CartDetailsEntity> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetailsEntity> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public UserEntity getUserCart() {
		return userCart;
	}

	public void setUserCart(UserEntity userCart) {
		this.userCart = userCart;
	}

	public String getUserNameOfCart() {
		return userNameOfCart;
	}

	public void setUserNameOfCart(String userNameOfCart) {
		this.userNameOfCart = userNameOfCart;
	}
	
}
