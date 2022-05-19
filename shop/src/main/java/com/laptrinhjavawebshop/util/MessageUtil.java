package com.laptrinhjavawebshop.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Update success");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
			result.put("message", "Insert success");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Delete success");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("message", "Error system");
			result.put("alert", "danger");
		}else if(message.equals("createAccout_success")) {
			result.put("message", "Register Success");
			result.put("alert", "success");
		}else if(message.equals("inaccurate_information")) {
			result.put("message", "Error Inaccurate Information");
			result.put("alert", "danger");
		}else if(message.equals("addCart_success")) {
			result.put("message", "AddCart Success");
			result.put("alert", "success");
		}else if(message.equals("orders_success")) {
			result.put("message", "Orders Success");
			result.put("alert", "success");
		}else if(message.equals("feedback_success")) {
			result.put("message", "Send FeedBack Success");
			result.put("alert", "success");
		}else if(message.equals("addOrder_success")) {
			result.put("message", "Add To Order Success");
			result.put("alert", "success");
		}
		return result;
	}
	
	
}
