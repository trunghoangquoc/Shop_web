package com.laptrinhjavawebshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavawebshop.service.IRoleService;


@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {
   
	@Autowired
	private IRoleService roleService;
	
//	@DeleteMapping("/api/role")
//	public String deleteRole(@RequestBody long[] ids) {
//		
//		if(roleService.deleteRole(ids).equals("Succses")) {
//			return "Succses";
//		}else {
//			return "Error";
//		}
//		
//	}
}
