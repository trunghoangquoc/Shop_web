package com.laptrinhjavawebshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavawebshop.constant.SystemConstant;
import com.laptrinhjavawebshop.converter.CartConverter;
import com.laptrinhjavawebshop.converter.OrderConverter;
import com.laptrinhjavawebshop.converter.OrderDetailsConverter;
import com.laptrinhjavawebshop.converter.ProductConverter;
import com.laptrinhjavawebshop.dto.MyUser;
import com.laptrinhjavawebshop.dto.OrderDTO;
import com.laptrinhjavawebshop.entity.CartDetailsEntity;
import com.laptrinhjavawebshop.entity.OrderDetailsEntity;
import com.laptrinhjavawebshop.entity.OrderEntity;
import com.laptrinhjavawebshop.entity.ProductEntity;
import com.laptrinhjavawebshop.entity.UserEntity;
import com.laptrinhjavawebshop.repository.CartDetailsRepository;
import com.laptrinhjavawebshop.repository.OrderDetailsRepository;
import com.laptrinhjavawebshop.repository.OrderRepository;
import com.laptrinhjavawebshop.repository.ProductRepository;
import com.laptrinhjavawebshop.repository.UserRepository;
import com.laptrinhjavawebshop.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderConverter orderConverter;

	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private ProductConverter productConverter;
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	private OrderDetailsConverter orderDetailsConverter;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//create Order
	@Override
	@Transactional
	public OrderDTO createOrder(OrderDTO orderDto) {
	    
		OrderDTO dto = new OrderDTO();
		OrderEntity orderEntity = new OrderEntity();
		UserEntity userEntity = new UserEntity();
		List<CartDetailsEntity> cartDetailsEntity = new ArrayList<CartDetailsEntity>();
		OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
		ProductEntity productEntity = new ProductEntity();
		Optional<ProductEntity> OProductEntity ;
		
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!object.equals("anonymousUser")) {
			MyUser myUser = (MyUser) object;
			orderEntity = orderConverter.toOrderEntity(orderDto);
			orderEntity.setOrderStatus(1);
			orderEntity.setShortDescription("Đang Giao Hàng");
			orderEntity.setUserNameOrder(myUser.getUsername());
			//set user_id
			userEntity = userRepository.findByUserName(myUser.getUsername());
			orderEntity.setUserOrder(userEntity);
			//set totapay
			orderEntity.setTotalPay(totalPay());
            
			// save đơn hàng vào table Order
			 orderRepository.save(orderEntity);
		     dto = orderConverter.toDto(orderEntity);
		    // find product từ cartDetails  thêm vào  OrderDetails
		     cartDetailsEntity = cartDetailsRepository.findByStatusAndUserNameOfCart(SystemConstant.INACTIVE_STATUS, myUser.getUsername());
		    for (CartDetailsEntity item : cartDetailsEntity) {
				orderDetailsEntity = orderDetailsConverter.toOrderDetailsEntity(item);
				orderDetailsEntity.setTotalMoney((item.getPrice() * item.getQuantity()));
				orderDetailsEntity.setOrder(orderEntity);
				orderDetailsRepository.save(orderDetailsEntity);
				
				//up date số lượng sản phẩm trong table Product
				
				OProductEntity = productRepository.findById(item.getProduct().getId());
				productEntity = productConverter.toEntity(OProductEntity);
				productEntity.setTotalNumber(productEntity.getTotalNumber() - item.getQuantity());
				productRepository.save(productEntity);
				
				//delete sp trong cart sau khi đã order
				cartDetailsRepository.deleteById(item.getId());
			}
		    return dto;
		}else {
			return null;
		}
		
	}
	
	
	//set totalPay
	public Float totalPay () {
		List<CartDetailsEntity> cartEntity = new ArrayList<CartDetailsEntity>();
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MyUser myUser = (MyUser) object;
		cartEntity = cartDetailsRepository.findByStatusAndUserNameOfCart(SystemConstant.INACTIVE_STATUS, myUser.getUsername());
		float totaPay = 0;
		for (CartDetailsEntity item : cartEntity) {
			totaPay += (item.getPrice() * item.getQuantity());
		
		}	
		return totaPay;
	}

	
	//delete sản phẩm order

	@Override
	@Transactional
	public void delete(long[] ids) {
		
		CartDetailsEntity  cartDetailsEntity = new CartDetailsEntity();
		Optional<CartDetailsEntity> result ;
		for (long id : ids) {
			result = cartDetailsRepository.findById(id);
			cartDetailsEntity = cartConverter.toEntity(result);
			cartDetailsEntity.setStatus(1);
			
			cartDetailsRepository.save(cartDetailsEntity);
		}
	}

}
