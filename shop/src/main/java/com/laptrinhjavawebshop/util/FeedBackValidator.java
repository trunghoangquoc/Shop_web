package com.laptrinhjavawebshop.util;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.laptrinhjavawebshop.dto.FeedBackDTO;

@Component
public class FeedBackValidator implements Validator {
	
	

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FeedBackDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FeedBackDTO feedBackDto = (FeedBackDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "fullName", "error.fullName", "Xin Mời Nhập Họ Tên");
		ValidationUtils.rejectIfEmpty(errors, "yourMessager", "error.yourMessager", " Xin Mời Bạn Nhập Phản Hồi");
		ValidationUtils.rejectIfEmpty(errors, "numberPhone", "error.numberPhone", "Xin Mời Nhập Số Điện Thoại");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.address", "Xin Mời Nhập Địa Chỉ");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email", "Email không được trống");
	
	}

}
