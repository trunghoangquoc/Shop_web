package com.laptrinhjavawebshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedBackEntity extends BaseEntity {

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;
	
	@Column(name = "numberphone")
	private Long numberPhone;
	
	@Column(name = "yourmessager", columnDefinition = "TEXT")
	private String yourMessager;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;//mappedBy = "user" bên UserEntity


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getNumberPhone() {
		return numberPhone;
	}


	public void setNumberPhone(Long numberPhone) {
		this.numberPhone = numberPhone;
	}


	public String getYourMessager() {
		return yourMessager;
	}


	public void setYourMessager(String yourMessager) {
		this.yourMessager = yourMessager;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
