package com.laptrinhjavawebshop.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.dto.OrderDetailsDTO;
import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.service.IOrderService;
import com.laptrinhjavawebshop.util.MessageUtil;

@Controller(value ="OrderControllerOfAdmin")
@PreAuthorize("hasAuthority('ADMIN_ORDER')")
public class OrderController {
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private IOrderService orderService;
	
	//find List product
	@RequestMapping(value = "/admin/orderList", method = RequestMethod.GET)
	public ModelAndView orderList(
			@RequestParam(value = "page" ,required = false) Integer page,
            @RequestParam(value ="limit" ,required = false) Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("admin/order/orderList");

		OrderDTO model = new OrderDTO();
		model.setPage(page);
		model.setLimit(limit);
	   //xử lý offset và limit
		
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page - 1, limit, sortable);
		
		model.setListResult(orderService.findAll(pageable));
		model.setTotalItem(orderService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		//set message
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
		
	}
	
	@RequestMapping(value = "/admin/orderDetails" , method = RequestMethod.GET)
	public ModelAndView productEdit (@RequestParam (value = "orderId" ,required = false) Long id , HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("admin/order/orderDetails");
		OrderDetailsDTO model = new OrderDetailsDTO();
		if (id != null) {
			model.setListResult(orderService.orderDetails(id));
			
		}
		
		mav.addObject("model", model);
		
		return mav;
	}
}
