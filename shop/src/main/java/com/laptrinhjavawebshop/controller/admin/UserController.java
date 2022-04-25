package com.laptrinhjavawebshop.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.dto.UserDTO;
import com.laptrinhjavawebshop.service.IUserService;
import com.laptrinhjavawebshop.util.MessageUtil;

@Controller(value = "UserControllerOfAdmin")
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/user/listActive", method = RequestMethod.GET)
	public ModelAndView userListActive(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("admin/user/userList");
		// truyền vào page và limit
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);

		// xử lý offset và limit

		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);

		model.setListResult(userService.findAllActive(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;

	}
	@RequestMapping(value = "/admin/user/listDelete", method = RequestMethod.GET)
	public ModelAndView userListDelete(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("admin/user/userListDelete");
		// truyền vào page và limit
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);

		// xử lý offset và limit

		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);

		model.setListResult(userService.findAllDelete(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;

	}
//	
	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
	public ModelAndView productEdit(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/userEdit");
		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);

		}
		// xử lý message
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
//		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);

		return mav;
	}

}
