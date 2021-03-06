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

import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.service.ICategoryService;
import com.laptrinhjavawebshop.service.IProductService;
import com.laptrinhjavawebshop.util.MessageUtil;


//Đặt tên  để đỡ bị conflicts with existing giữa admin và web
@Controller(value = "ProductControllerOfAdmin")
@PreAuthorize("hasAuthority('ADMIN_PRODUCT')")
public class ProductController {

	@Autowired
	private IProductService productService;
   
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView productList(@RequestParam(value = "page" ,required = false) int page,
                                    @RequestParam(value ="limit" ,required = false) int limit,
                                    @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request )  {
		
		ModelAndView mav = new ModelAndView("admin/product/productList");
		//truyền vào page và limit
		ProductDTO model = new ProductDTO();
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
		
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
		
	}
	
	@RequestMapping(value = "/admin/product/edit" , method = RequestMethod.GET)
	public ModelAndView productEdit (@RequestParam (value = "id" ,required = false) Long id , HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/productEdit");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
			
		}
		//xử lý message
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories",categoryService.findAll());
		mav.addObject("model", model);
		
		return mav;
	}
	

}
