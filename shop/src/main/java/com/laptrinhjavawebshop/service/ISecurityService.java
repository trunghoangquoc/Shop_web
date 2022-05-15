package com.laptrinhjavawebshop.service;

public interface ISecurityService {

	String findLoggedInUsername();

	void autologin(String userName, String password);
}
