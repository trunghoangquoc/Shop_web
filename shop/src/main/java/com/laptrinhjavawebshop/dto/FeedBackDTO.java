package com.laptrinhjavawebshop.dto;

public class FeedBackDTO extends AbstractDTO<FeedBackDTO> {
	
	private String fullName;
	private String email;
	private String address;
	private String yourMessager;
	private String numberPhone;
	private Long id_user;
	
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getYourMessager() {
		return yourMessager;
	}
	public void setYourMessager(String yourMessager) {
		this.yourMessager = yourMessager;
	}
	
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
}
