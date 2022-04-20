package com.laptrinhjavawebshop.dto;

public class FeedBackDTO extends AbstractDTO<FeedBackDTO> {
	
	private String fullName;
	private String email;
	private String address;
	private String yourMessager;
	private Long numberPhone;
	
	
	
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
	public Long getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(Long numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	
	
}
