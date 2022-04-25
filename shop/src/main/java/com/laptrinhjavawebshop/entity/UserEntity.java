package com.laptrinhjavawebshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column
	private Integer status;
	
	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "user")
	private List<FeedBackEntity> feedback = new ArrayList<>();
	//vì 1 user có nhiều feedback nên cần tạo 1 list
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();

			
	public String getUserName() {
		return userName;
	}

	public List<FeedBackEntity> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<FeedBackEntity> feedback) {
		this.feedback = feedback;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
