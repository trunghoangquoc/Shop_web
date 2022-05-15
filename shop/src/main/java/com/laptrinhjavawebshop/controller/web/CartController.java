package com.laptrinhjavawebshop.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.converter.CartConverter;
import com.laptrinhjavawebshop.dto.CartDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.service.ICartService;
import com.laptrinhjavawebshop.util.MessageUtil;

@Controller(value = "CartControllerOfWeb")
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/cart"  , method = RequestMethod.GET)
	public ModelAndView webCart (
			@RequestParam(name = "username" ,required = false) String username,
			@RequestParam(value = "page" ,required = false) Integer page,
            @RequestParam(value ="limit" ,required = false) Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("web/cart");
	    
		List<CartDTO> cartDto = new ArrayList<CartDTO>();
		CartDTO model = new CartDTO();
		model.setPage(page);
		model.setLimit(limit);
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page-1, limit, sortable);
		Page<CartDetailsEntity> resultPage = cartService.findByNameOfCart(username, pageable) ;
		for (CartDetailsEntity item : resultPage) {
			CartDTO dto = new CartDTO();
			dto = cartConverter.toDto(item);
			cartDto.add(dto);
		}
		model.setListResult(cartDto);
		model.setTotalItem(cartService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
}
