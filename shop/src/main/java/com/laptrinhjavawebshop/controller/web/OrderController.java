package com.laptrinhjavawebshop.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavawebshop.converter.OrderConverter;
import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.dto.OrderDetailsDTO;
import com.laptrinhjavawebshop.dto.ProductDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.OrderEntity;
import com.laptrinhjavawebshop.entity.ProductEntity;
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
	private OrderConverter orderConverter;
	
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
		
		//set totalPay
		OrderDetailsDTO totalPay = new OrderDetailsDTO();
		float tota = 0;
		for (CartDetailsEntity i : cartEntity) {
			tota += (i.getPrice() * i.getQuantity());
		}
		totalPay.setTotalPay(tota);
		
		mav.addObject("totalPay", totalPay);
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
        		 return new ModelAndView("redirect:/trang-chu?message=orders_success");
        	}
            return new ModelAndView("redirect:/order?message=error_system");
        }

	}
	
	  @RequestMapping(value = "/orderSuccess" , method = RequestMethod.GET)
	    public ModelAndView orderSuccessPage(
	    		@RequestParam(value = "username" ,required = false) String userName,
	    		@RequestParam(value = "page" ,required = false) Integer page,
	            @RequestParam(value ="limit" ,required = false) Integer limit,
	            @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort,HttpServletRequest request ) {
	        ModelAndView mav = new ModelAndView("web/orderSuccess");
	        
			List<OrderDTO> listOrdertDto = new ArrayList<OrderDTO>();
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
			
			Page<OrderEntity> resultPage = orderService.findByUserNameOrder(userName, pageable);
			for (OrderEntity item : resultPage) {
				OrderDTO dto = new OrderDTO();
				dto = orderConverter.toDto(item);
				listOrdertDto.add(dto);
			}
			model.setListResult(listOrdertDto);
			model.setTotalItem(orderService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
			mav.addObject("model", model);
	        return mav;
	    }
	  
	  @RequestMapping(value = "/orderDetails" , method = RequestMethod.GET)
		public ModelAndView productEdit (@RequestParam (value = "orderId" ,required = false) Long id , HttpServletRequest request) {
			
			ModelAndView mav = new ModelAndView("web/orderDetails");
			OrderDetailsDTO model = new OrderDetailsDTO();
			if (id != null) {
				model.setListResult(orderService.orderDetails(id));
				
			}
			
			mav.addObject("model", model);
			
			return mav;
		}
}
