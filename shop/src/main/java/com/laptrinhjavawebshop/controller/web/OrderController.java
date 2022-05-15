package com.laptrinhjavawebshop.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.dto.OrderDetailsDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.service.ICartService;
import com.laptrinhjavawebshop.service.IOrderService;
import com.laptrinhjavawebshop.util.MessageUtil;
import com.laptrinhjavawebshop.util.OrderValidator;

@Controller(value ="OrderControllerOfWeb")
public class OrderController {
      
	@Autowired
	private ICartService cartService;
	
	@Autowired 
	private OrderValidator orderValidator;
	
	@Autowired 
	private IOrderService orderService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public ModelAndView orderPage(@RequestParam(value = "message" ,required = false) String message, HttpServletRequest request) {
	
		ModelAndView mav = new ModelAndView("web/order");
		List<OrderDetailsDTO> result = new ArrayList<OrderDetailsDTO>();
		List<CartDetailsEntity> cartEntity = cartService.findByStatusAndUserNameOfCart();
		for (CartDetailsEntity item : cartEntity) {
			OrderDetailsDTO orderDetailsDto = new OrderDetailsDTO();
			
			orderDetailsDto.setId(item.getId());
			orderDetailsDto.setNameProduct(item.getNameProduct());
			orderDetailsDto.setPrice(item.getPrice());
			orderDetailsDto.setQuantity(item.getQuantity());
			orderDetailsDto.setUserNameOrder(item.getUserNameOfCart());
			orderDetailsDto.setTotalMoney(item.getTotalMoney());
			orderDetailsDto.setCodeImg(item.getCodeImg());
			result.add(orderDetailsDto);
			
		}
		mav.addObject("result" ,result );
		mav.addObject("newUserOrder", new OrderDTO());
		
		return mav;
	}
	
	@PostMapping("/order")
	public ModelAndView orderProcess(@ModelAttribute("newUserOrder") @Valid OrderDTO orderDto, BindingResult bindingResult, Model model) {
		
		orderValidator.validate(orderDto, bindingResult);
		
        if (bindingResult.hasErrors()) {
        	 return new ModelAndView("/order");
        }else {
        	if( orderService.createOrder(orderDto) != null) {
        		 return new ModelAndView("redirect:/orderSuccess");
        	}
            return new ModelAndView("redirect:/order?message=error_system");
        }

	}
	
	  @RequestMapping(value = "/orderSuccess" , method = RequestMethod.GET)
	    public ModelAndView orderSuccessPage() {
	        ModelAndView mav = new ModelAndView("web/orderSuccess");
	      
	        return mav;
	    }
	  
	  
}
