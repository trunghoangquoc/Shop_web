package com.laptrinhjavawebshop.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/*
-Bản thân thằng Spring_Security có sẵn method User (từ import org.springframework.security.core.userdetails.User;)
method User chỉ có những thông tin chung uresName , password , id.   HẾT!

=> Nếu user có những thông tin thêm như : Email, Sdt,... thì cần Custom lại*/
public class MyUser extends User {

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private String fullName;
	private String email;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
