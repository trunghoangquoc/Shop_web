package com.laptrinhjavawebshop.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.laptrinhjavawebshop.dto.OrderDTO;


@Component
public class OrderValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return OrderDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderDTO orderDto = (OrderDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "receiverName", "error.receiverName", "Phải nhập tên người nhận");
		ValidationUtils.rejectIfEmpty(errors, "receiverPhone", "error.receiverPhone", "Phải nhập số điện thoại người nhận");
		ValidationUtils.rejectIfEmpty(errors, "receiverAddress", "error.receiverAddress", "Địa chỉ không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email", "Email không được trống");
		
	}

}